package com.ourmail.relationservice.service;

import com.ourmail.group.service.contract.GroupService;
import com.ourmail.relationservice.contract.MemberShipService;
import com.ourmail.relationservice.domain.MemberShip;
import com.ourmail.relationservice.repository.MemberShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberShipServiceImplTest {
    public static final String TEST_PASSWORD="test password";
    public static final long TEST_USERID=1;
    public static final long TEST_GROUPID=2;
    public static final long TEST_MEMBERSHIPID=1;
    @Autowired
    private MemberShipService memberShipService;
    @Autowired
    private MemberShipRepository memberShipRepository;
    @MockBean
    private GroupService groupService;
    @Test
    public void addNewMemberTest() throws Exception {
        when(groupService.findPasswordByGroupId(TEST_GROUPID)).thenReturn(TEST_PASSWORD);
        memberShipService.addNewMember(TEST_USERID,TEST_GROUPID,TEST_PASSWORD);
        MemberShip memberShip=memberShipRepository.findMemberShipById(TEST_MEMBERSHIPID);
        assertEquals(memberShip.getGroupId(),TEST_GROUPID);
        assertEquals(memberShip.getUserId(),TEST_USERID);
    }

}