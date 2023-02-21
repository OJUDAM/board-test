package com.jpa.factory.service.admin;

import com.jpa.factory.model.entity.primary.BoardMng;
import com.jpa.factory.repository.primary.BoardMngRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName    : com.jpa.factory.service.admin
 * fileName       : BoardMngService
 * author         : 오주담
 * date           : 2023-01-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-06        오주담       최초 생성
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardMngService {

    private final BoardMngRepository boardMngRepository;

    public List<BoardMng> findAll() {
        return boardMngRepository.findAll();
    }
}
