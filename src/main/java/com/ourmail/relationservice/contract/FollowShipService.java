package com.ourmail.relationservice.contract;

public interface FollowShipService {
    void addNewFollower(long userId, long targetId) throws Exception;
}
