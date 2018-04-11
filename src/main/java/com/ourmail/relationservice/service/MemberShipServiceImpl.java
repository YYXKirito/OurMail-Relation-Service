package com.ourmail.relationservice.service;

import com.ourmail.group.contract.GroupService;
import com.ourmail.relation.contract.*;
import com.ourmail.relationservice.domain.Label;
import com.ourmail.relationservice.domain.MemberShip;
import com.ourmail.relationservice.repository.LabelRepository;
import com.ourmail.relationservice.repository.MemberShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    public void add(long userId, long groupId, int role) throws MemberShipExistsException {
        if (memberShipRepository.userExistsInGroup(userId, groupId)) throw new MemberShipExistsException();
        MemberShip memberShip=new MemberShip();
        memberShip.setUserId(userId);
        memberShip.setGroupId(groupId);
        memberShip.setJoinDate();
        memberShipRepository.save(memberShip);
    }

    @Override
    public void remove(long userId, long groupId) throws MemberShipNotExistsException {
        if (!memberShipRepository.userExistsInGroup(userId, groupId)) throw new MemberShipNotExistsException();
        MemberShip memberShip=memberShipRepository.findMemberShipByUserAndGroup(userId, groupId);
        memberShipRepository.delete(memberShip);
    }

    @Override
    public void setRole(long userId, long groupId, int role) throws MemberShipNotExistsException {
        if (!memberShipRepository.userExistsInGroup(userId, groupId)) throw new MemberShipNotExistsException();
        MemberShip memberShip=memberShipRepository.findMemberShipByUserAndGroup(userId, groupId);
        memberShip.setRole(role);
    }

    @Override
    public void setAlias(long userId, long groupId, String alias) throws MemberShipNotExistsException {
        if (!memberShipRepository.userExistsInGroup(userId, groupId)) throw new MemberShipNotExistsException();
        MemberShip memberShip=memberShipRepository.findMemberShipByUserAndGroup(userId, groupId);
        memberShip.setAlias(alias);
    }

    @Override
    public void addLabel(long userId, long groupId, long labelId) throws MemberShipNotExistsException {
        if (!memberShipRepository.userExistsInGroup(userId, groupId)) throw new MemberShipNotExistsException();
        MemberShip memberShip=memberShipRepository.findMemberShipByUserAndGroup(userId, groupId);
        Label label=new Label();
        label.setUserId(userId);
        label.setGroupId(groupId);
        label.setLabelId(labelId);
        labelRepository.save(label);
    }

    @Override
    public void removeLabel(long userId, long groupId, long labelId) throws LabelNotExistsException {
        if (!labelRepository.userExsitsByGroupAndLabel(userId, groupId, labelId)) throw new LabelNotExistsException();
        Label label=labelRepository.findLabelByUserAndGroupAndLabelId(userId, groupId, labelId);
        labelRepository.delete(label);
    }

    @Override
    public Member getMember(long userId, long groupId) throws MemberShipNotExistsException {
        if (!memberShipRepository.userExistsInGroup(userId, groupId)) throw new MemberShipNotExistsException();
        MemberShip memberShip=memberShipRepository.findMemberShipByUserAndGroup(userId, groupId);
        Member member=new Member();
        member.setUserId(memberShip.getUserId());
        member.setGroupId(memberShip.getGroupId());
        member.setRole(memberShip.getRole());
        member.setAlias(memberShip.getAlias());

    }

    @Override
    public List<Member> getMembersByRole(long l, long l1, int i) {
        return null;
    }

    @Override
    public List<Member> getMembersByUser(long l) {
        return null;
    }

    @Override
    public List<Member> getMembersByGroup(long l) {
        return null;
    }

    @Override
    public List<Member> getMembersByGroupLabel(long l, int i) {
        return null;
    }
}
