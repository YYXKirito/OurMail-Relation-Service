package com.ourmail.relationservice.repository;

import com.ourmail.relationservice.domain.FollowShip;
import com.ourmail.relationservice.domain.MemberShip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberShipRepository extends CrudRepository<MemberShip, Long>{
    List<MemberShip> findAllMemberShipByGroupId(long groupId);
    List<MemberShip> findAllMemberShipByUserId(long userId);
    List<MemberShip> findAllMemberShipByGroupIdAndLabelId(long groupId, long labelId);
    List<MemberShip> findAllMemberShipByUserIdAndGroupIdAndRole(long userId, long groupId, int role);
    MemberShip findMemberShipById(long id);
    boolean existsByUserIdAndGroupId(long userId, long groupId);
    MemberShip findMemberShipByUserIdAndGroupId(long userId, long groupId);
}
