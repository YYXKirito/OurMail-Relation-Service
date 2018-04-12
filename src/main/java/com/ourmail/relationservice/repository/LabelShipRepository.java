package com.ourmail.relationservice.repository;

import com.ourmail.relationservice.domain.LabelShip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LabelShipRepository extends CrudRepository<LabelShip, Long> {
    List<Long> findAllLabelIdByUserIdAndGroupId(long userId,long groupId);
}
