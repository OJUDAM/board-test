package com.jpa.factory.service.login;

import com.jpa.factory.model.entity.secondary.CustomUserDetails;
import com.jpa.factory.model.entity.secondary.UserAccount;
import com.jpa.factory.repository.secondary.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.jpa.factory.service.login
 * fileName       : CustomUserDetailService
 * author         : 오주담
 * date           : 2022-12-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-20        오주담       최초 생성
 */
@Service("customUserDetailService")
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CustomUserDetails customUserDetails = null;

        if (username == null) {
            throw new UsernameNotFoundException(username);
        }

        customUserDetails = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return new UserAccount(customUserDetails);
    }


    public CustomUserDetails findUserByUserId(String username) throws UsernameNotFoundException {

        return userRepository.findById(username).orElseThrow();
    }

}
