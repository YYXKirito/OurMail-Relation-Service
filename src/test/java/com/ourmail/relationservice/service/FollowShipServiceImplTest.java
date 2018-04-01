package com.ourmail.relationservice.service;

import com.ourmail.group.service.contract.GroupService;
import com.ourmail.relationservice.contract.FollowShipService;
import com.ourmail.relationservice.domain.FollowShip;
import com.ourmail.relationservice.repository.FollowShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowShipServiceImplTest {
    public static final long TEST_USERID=1;
    public static final long TEST_TARGETID=2;
    public static final long TEST_ID=1;

    @Autowired
    FollowShipRepository followShipRepository;
    @Autowired
    FollowShipService followShipService;
    @MockBean
    GroupService groupService;

    @Test
    public void addNewFollower() throws Exception{
        followShipService.addNewFollower(TEST_USERID,TEST_TARGETID);
        FollowShip followShip=followShipRepository.findFollowShipById(TEST_ID);
        assertEquals(followShip.getUserId(),TEST_USERID);
        assertEquals(followShip.getTargetId(),TEST_TARGETID);
    }
}