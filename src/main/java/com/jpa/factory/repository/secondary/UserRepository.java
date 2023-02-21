package com.jpa.factory.repository.secondary;

import com.jpa.factory.model.entity.secondary.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.jpa.factory.repository.secondary
 * fileName       : UserRepository
 * author         : 오주담
 * date           : 2022-12-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-21        오주담       최초 생성
 */
public interface UserRepository  extends JpaRepository<CustomUserDetails, String> {
}
