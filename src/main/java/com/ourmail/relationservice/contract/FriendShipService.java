package com.ourmail.relationservice.contract;

import com.ourmail.relationservice.domain.FriendShip;

import java.util.List;

public interface FriendShipService {
    List<FriendShip> getFriendShipListByUserId();
}
