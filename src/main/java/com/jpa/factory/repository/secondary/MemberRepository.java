package com.jpa.factory.repository.secondary;

import com.jpa.factory.model.entity.secondary.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.jpa.factory.repository.login
 * fileName       : userRepositroy
 * author         : 오주담
 * date           : 2022-12-21
 * description    : 로그인을 위한 사용자 매핑
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-21        오주담       최초 생성
 */
public interface MemberRepository extends JpaRepository<Member, String> {
}
