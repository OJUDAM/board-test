package com.jpa.factory.service.admin;

import com.jpa.factory.common.util.StringUtils;
import com.jpa.factory.model.dto.admin.AuthorMngDTO;
import com.jpa.factory.model.entity.primary.AuthorMng;
import com.jpa.factory.repository.primary.AuthorMngQueryDslRepository;
import com.jpa.factory.repository.primary.AuthorMngRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attoparser.util.TextUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.jpa.factory.service.admin
 * fileName       : AuthorMngService
 * author         : 오주담
 * date           : 2022-12-29
 * description    : 권환 관리 서비스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-29        오주담       최초 생성
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorMngService {
    private final AuthorMngRepository authorMngRepository;
    private final AuthorMngQueryDslRepository authorMngQueryDslRepository;

    public List<AuthorMng> findAll() {
        return authorMngRepository.findAll();
    }

    public Page<AuthorMng> findAll(Pageable pageable, AuthorMngDTO authorMngDTO) {

        Page<AuthorMng> authorMngList = null;

        String classify = authorMngDTO.getClassify();
        String keyword = authorMngDTO.getKeyword();

//        if (classify.equals("all") && !StringUtils.isNull(keyword)) {
//            authorMngList = authorMngRepository.find
//        }

        return authorMngRepository.findAll(pageable);
    }

    public Page<AuthorMng> findAllWithMenu(Pageable pageable, AuthorMngDTO authorMngDTO) {

        Page<AuthorMng> authorMngList = null;

        String classify = authorMngDTO.getClassify();
        String keyword = authorMngDTO.getKeyword();

//        if (classify.equals("all") && !StringUtils.isNull(keyword)) {
//            authorMngList = authorMngRepository.find
//        }

        return authorMngQueryDslRepository.findAllWithBoardMngAndMenuPageable(pageable);
    }


    public List<AuthorMng> findAllWithMenu() {
        List<AuthorMng> list = authorMngQueryDslRepository.findAllWithMenu();

        return list;
    }

    public List<AuthorMng> findAllWithBoardAndMenu() {
        List<AuthorMng> list = authorMngQueryDslRepository.findAllWithBoardMngAndMenu();

        return list;
    }

    public Page<AuthorMng> findAllWithBoardAndMenuPageable(Pageable pageable) {


        Page<AuthorMng> list = authorMngQueryDslRepository.findAllWithBoardMngAndMenuPageable(pageable);

        return list;
    }
}
