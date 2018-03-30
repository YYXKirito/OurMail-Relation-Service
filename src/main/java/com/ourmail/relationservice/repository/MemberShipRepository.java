package com.ourmail.relationservice.repository;

import com.ourmail.relationservice.domain.FollowShip;
import com.ourmail.relationservice.domain.MemberShip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberShipRepository extends CrudRepository<MemberShip, Long>{
    List<FollowShip> findFriendShipByUserId(long)
}
