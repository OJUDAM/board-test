package com.jpa.factory.service.login;

import com.jpa.factory.model.entity.secondary.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * packageName    : com.jpa.factory.service.login
 * fileName       : UserServiceTest
 * author         : 오주담
 * date           : 2022-12-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-21        오주담       최초 생성
 */

@SpringBootTest
class UserServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void findAllUser() {
        List<Member>  memberList =  memberService.findAllMember();

        for (Member  member :  memberList) {
            System.out.println( member.toString());
        }
    }
}
