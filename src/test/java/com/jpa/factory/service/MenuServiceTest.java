package com.jpa.factory.service;

import com.jpa.factory.model.entity.primary.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.jpa.factory.service
 * fileName       : MenuServiceTest
 * author         : 오주담
 * date           : 2022-12-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-19        오주담       최초 생성
 */
@SpringBootTest
class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Test
    void findAllMenuTest() {
        List<Menu> menus = menuService.getMenuList();

        for (Menu menu : menus) {
            System.out.println(menu.toString());
        }
    }

    @Test
    void findByMenuSeqTest(){
        Optional<Menu> menu = menuService.getMenuByMenuSeq("20210903069");

        System.out.println(menu.toString());
    }

}
