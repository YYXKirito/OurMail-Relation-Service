package com.ourmail.relationservice.service;

import com.ourmail.group.contract.GroupService;
import com.ourmail.relation.contract.*;
import com.ourmail.relationservice.domain.MemberShip;
import com.ourmail.relationservice.repository.LabelRepository;
import com.ourmail.relationservice.repository.LabelShipRepository;
import com.ourmail.relationservice.repository.MemberShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MemberShipServiceImpl implements MemberShipService {
    @Autowired
    private MemberShipRepository memberShipRepository;
    @Autowired
    private GroupService groupService;
    @Autowired
    private MemberShipService memberShipService;
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private LabelShipRepository labelShipRepository;

    @Override
    public void add(long userId, long groupId, int role) throws MemberShipExistsException {
        if (memberShipRepository.existsByUserIdAndGroupId(userId, groupId)) throw new MemberShipExistsException();
        MemberShip memberShip=new MemberShip();
        memberShip.setUserId(userId);
        memberShip.setGroupId(groupId);
        memberShip.setJoinDate(System.currentTimeMillis());
        memberShipRepository.save(memberShip);
    }

    @Override
    public void remove(long userId, long groupId) throws MemberShipNotExistsException {
        if (!memberShipRepository.existsByUserIdAndGroupId(userId, groupId)) throw new MemberShipNotExistsException();
        MemberShip memberShip=memberShipRepository.findMemberShipByUserIdAndGroupId(userId, groupId);
        memberShipRepository.delete(memberShip);
    }

    @Override
    public void setRole(long userId, long groupId, int role) throws MemberShipNotExistsException {
        if (!memberShipRepository.existsByUserIdAndGroupId(userId, groupId)) throw new MemberShipNotExistsException();
        MemberShip memberShip=memberShipRepository.findMemberShipByUserIdAndGroupId(userId, groupId);
        memberShip.setRole(role);
    }

    @Override
    public void setAlias(long userId, long groupId, String alias) throws MemberShipNotExistsException {
        if (!memberShipRepository.existsByUserIdAndGroupId(userId, groupId)) throw new MemberShipNotExistsException();
        MemberShip memberShip=memberShipRepository.findMemberShipByUserIdAndGroupId(userId, groupId);
        memberShip.setAlias(alias);
    }
    @Override
    public Member getMember(long userId, long groupId) throws MemberShipNotExistsException {
        if (!memberShipRepository.existsByUserIdAndGroupId(userId, groupId)) throw new MemberShipNotExistsException();
        MemberShip memberShip=memberShipRepository.findMemberShipByUserIdAndGroupId(userId, groupId);
        Member member=new Member();
        member.setUserId(memberShip.getUserId());
        member.setGroupId(memberShip.getGroupId());
        member.setRole(memberShip.getRole());
        member.setAlias(memberShip.getAlias());
        member.setJoinDate(memberShip.getJoinDate());
        member.setLabelIdList(labelShipRepository.findAllLabelIdByUserIdAndGroupId(userId, groupId));
        return member;
    }

    @Override
    public List<Member> getMembersByRole(long userId, long groupId, int role) {
        List<Member> memberList=new ArrayList<>();
        List<MemberShip> memberShipList=memberShipRepository.findAllMemberShipByUserIdAndGroupIdAndRole(userId, groupId, role);
        for (MemberShip i:memberShipList){
            Member member=new Member();
            member.setUserId(i.getUserId());
            member.setGroupId(i.getGroupId());
            member.setRole(i.getRole());
            member.setAlias(i.getAlias());
            member.setJoinDate(i.getJoinDate());
            member.setLabelIdList(labelShipRepository.findAllLabelIdByUserIdAndGroupId(userId, groupId));
            memberList.add(member);
        }
        return memberList;
    }

    @Override
    public List<Member> getMembersByUser(long userId) {
        List<Member> memberList=new ArrayList<>();
        List<MemberShip> memberShipList=memberShipRepository.findAllMemberShipByUserId(userId);
        for (MemberShip i:memberShipList){
            Member member=new Member();
            member.setUserId(i.getUserId());
            member.setGroupId(i.getGroupId());
            member.setRole(i.getRole());
            member.setAlias(i.getAlias());
            member.setJoinDate(i.getJoinDate());
            member.setLabelIdList(labelShipRepository.findAllLabelIdByUserIdAndGroupId(userId, i.getGroupId()));
            memberList.add(member);
        }
        return memberList;
    }

    @Override
    public List<Member> getMembersByGroup(long groupId) {
        List<Member> memberList=new ArrayList<>();
        List<MemberShip> memberShipList=memberShipRepository.findAllMemberShipByGroupId(groupId);
        for (MemberShip i:memberShipList){
            Member member=new Member();
            member.setUserId(i.getUserId());
            member.setGroupId(i.getGroupId());
            member.setRole(i.getRole());
            member.setAlias(i.getAlias());
            member.setJoinDate(i.getJoinDate());
            member.setLabelIdList(labelShipRepository.findAllLabelIdByUserIdAndGroupId(i.getUserId(), groupId));
            memberList.add(member);
        }
        return memberList;
    }

    @Override
    public List<Member> getMembersByGroupAndLabel(long groupId, long labelId) {
        List<Member> memberList=new ArrayList<>();
        List<MemberShip> memberShipList=memberShipRepository.findAllMemberShipByGroupIdAndLabelId(groupId,labelId);
        for (MemberShip i:memberShipList){
            Member member=new Member();
            member.setUserId(i.getUserId());
            member.setGroupId(i.getGroupId());
            member.setRole(i.getRole());
            member.setAlias(i.getAlias());
            member.setJoinDate(i.getJoinDate());
            member.setLabelIdList(labelShipRepository.findAllLabelIdByUserIdAndGroupId(i.getUserId(), groupId));
            memberList.add(member);
        }
        return memberList;
    }
}
