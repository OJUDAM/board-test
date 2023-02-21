package com.jpa.factory.repository.primary;

import com.jpa.factory.model.entity.primary.AuthorMng;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.jpa.factory.repository.primary
 * fileName       : AuthorMngRepository
 * author         : 오주담
 * date           : 2022-12-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-29        오주담       최초 생성
 */
public interface AuthorMngRepository extends JpaRepository<AuthorMng, String> {
}
