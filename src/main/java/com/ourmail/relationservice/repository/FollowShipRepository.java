package com.ourmail.relationservice.repository;

import com.ourmail.relationservice.domain.FollowShip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowShipRepository extends CrudRepository<FollowShip, Long>{
    List<FollowShip> getFollowShipByUserId(long userId);
    FollowShip findFollowShipById(long id);
}
