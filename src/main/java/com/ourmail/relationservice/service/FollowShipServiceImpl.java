package com.ourmail.relationservice.service;

import com.ourmail.relation.contract.RelationService;
import com.ourmail.relationservice.contract.FollowShipService;
import com.ourmail.relationservice.domain.FollowShip;
import com.ourmail.relationservice.repository.FollowShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FollowShipServiceImpl implements FollowShipService {
    @Autowired
    private FollowShipRepository followShipRepository;

    RelationService relationService;

    @Override
    public void addNewFollower(long userId, long targetId) throws Exception{
        List<FollowShip> followShips=followShipRepository.getFollowShipByUserId(userId);
        FollowShip followShip=new FollowShip();
        followShip.setUserId(userId);
        followShip.setTargetId(targetId);
        if (followShips.contains(followShip)) throw new Exception("Target is already followed!");
        followShipRepository.save(followShip);
    }
}
