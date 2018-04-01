package com.ourmail.relationservice.service;

import com.ourmail.group.service.contract.GroupService;
import com.ourmail.relationservice.contract.MemberShipService;
import com.ourmail.relationservice.domain.MemberShip;
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

    @Override
    public void addNewMember(long userId, long groupId, String password) throws Exception{
        String targetPassword=groupService.findPasswordByGroupId(groupId);
        if (targetPassword!=password) throw new Exception("Wrong Password!");
        MemberShip memberShip=new MemberShip();
        memberShip.setUserId(userId);
        memberShip.setGroupId(groupId);
        List<MemberShip> memberShips=memberShipRepository.findMemberShipByGroupId(groupId);
        if (memberShips.contains(memberShip)) throw new Exception("User already existed!");
        memberShipRepository.save(memberShip);
    }

}
