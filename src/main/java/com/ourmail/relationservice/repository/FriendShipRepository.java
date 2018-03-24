package com.ourmail.relationservice.repository;

import com.ourmail.relationservice.domain.FriendShip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendShipRepository extends CrudRepository<FriendShip, Long>{
}
