package com.jpa.factory.service;

import com.jpa.factory.model.entity.primary.Menu;
import com.jpa.factory.repository.primary.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.jpa.factory.service
 * fileName       : MenuService
 * author         : 오주담
 * date           : 2022-12-19
 * description    : 메뉴 조회
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-19        오주담       최초 생성
 */

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getMenuList () {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuByMenuSeq (String MenuSeq) {
        return menuRepository.findById(MenuSeq);
    }
}
