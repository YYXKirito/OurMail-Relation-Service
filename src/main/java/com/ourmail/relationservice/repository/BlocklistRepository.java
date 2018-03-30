package com.ourmail.relationservice.repository;

import com.ourmail.relationservice.domain.Blocklist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlocklistRepository extends CrudRepository<Blocklist, Long>{
    List<Blocklist> getBlocklistByUserId(long userId);
}
