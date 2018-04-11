package com.ourmail.relationservice.repository;

import com.ourmail.relationservice.domain.Label;
import org.springframework.data.repository.CrudRepository;

public interface LabelRepository extends CrudRepository<Label,Long> {
    boolean userExsitsByGroupAndLabel(long userId, long groupId, long labelId);
    Label findLabelByUserAndGroupAndLabelId(long userId, long groupId, long labelId);
}
