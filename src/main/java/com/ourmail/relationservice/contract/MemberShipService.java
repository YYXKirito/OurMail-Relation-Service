package com.ourmail.relationservice.contract;

public interface MemberShipService {
    void addNewMember(long userId, long groupId, String password) throws Exception;
}
