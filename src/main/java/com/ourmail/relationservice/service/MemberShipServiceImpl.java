package com.ourmail.relationservice.service;

import com.ourmail.relationservice.contract.MemberShipService;
import com.ourmail.relationservice.domain.MemberShip;
import com.ourmail.relationservice.repository.MemberShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberShipServiceImpl implements MemberShipService {
    @Autowired
    MemberShipRepository memberShipRepository;

    public void addNewMember(long userId, long groupId, String password) throws Exception{
        String targetPassword=findByGroupId(groupId).password;
        if (targetPassword!=password) throw new Exception("Wrong Password!");
        MemberShip memberShip=new MemberShip();
        memberShip.setUser(userId);
        memberShip.setGroup(groupId);
        memberShipRepository.save(memberShip);
    }
}
