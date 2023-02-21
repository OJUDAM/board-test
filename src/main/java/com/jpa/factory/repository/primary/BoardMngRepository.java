package com.jpa.factory.repository.primary;

import com.jpa.factory.model.entity.primary.BoardMng;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.jpa.factory.repository.primary
 * fileName       : BoardMngRepository
 * author         : 오주담
 * date           : 2023-01-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-06        오주담       최초 생성
 */
public interface BoardMngRepository extends JpaRepository<BoardMng, String> {
}
