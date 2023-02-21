package com.jpa.factory.service.admin;

import com.jpa.factory.model.entity.primary.BoardMng;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.jpa.factory.service.admin
 * fileName       : BoardMngServiceTest
 * author         : 오주담
 * date           : 2023-01-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-06        오주담       최초 생성
 */

@SpringBootTest
class BoardMngServiceTest {

    @Autowired
    private BoardMngService boardMngService;

    @Test
    public void findAllTest() {
        List<BoardMng> boardMngList = boardMngService.findAll();

        for (BoardMng mng : boardMngList) {
            System.out.println(mng.toString());
        }
    }
}
