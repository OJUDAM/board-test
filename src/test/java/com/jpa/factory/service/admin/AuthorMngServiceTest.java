package com.jpa.factory.service.admin;

import com.jpa.factory.model.entity.primary.AuthorMng;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.jpa.factory.service.admin
 * fileName       : AuthorMngServiceTest
 * author         : 오주담
 * date           : 2022-12-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-29        오주담       최초 생성
 */

@SpringBootTest
class AuthorMngServiceTest {

    @Autowired
    private AuthorMngService authorMngService;

    @Test
    void getAllAuthorMng() {
        List<AuthorMng> list = authorMngService.findAll();

        for (AuthorMng mng : list) {
            System.out.println(mng.toString());
        }
    }

    @Test
    void findAllWithMenuTest() {
        List<AuthorMng> list = authorMngService.findAllWithMenu();

        for (AuthorMng mng : list) {
            System.out.println(mng.toString());
        }
    }

    @Test
    void findAllWithBoardAndMenuTest() {
        List<AuthorMng> list = authorMngService.findAllWithBoardAndMenu();

        for (AuthorMng mng : list) {
            System.out.println(mng.toString());
        }
    }

    @Test
    void findAllWithMenuByBaSeq() {
        List<AuthorMng> list = authorMngService.findAllWithMenu();

        for (AuthorMng mng : list) {
            System.out.println(mng.toString());
        }
    }
}
