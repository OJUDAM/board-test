package com.jpa.factory.common.component;

import com.jpa.factory.model.entity.secondary.UserAccount;
import com.jpa.factory.service.login.CustomUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * packageName    : com.jpa.factory.common.component
 * fileName       : CustomAuthenticationProvider
 * author         : 오주담
 * date           : 2022-12-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-20        오주담       최초 생성
 */
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired @Qualifier("customUserDetailService")
    private CustomUserDetailService userDetailService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = "";
        String password = "";
        UserAccount userAccount = null;

        try {
            name = authentication.getName();
            password = authentication.getCredentials().toString();
            userAccount = (UserAccount) userDetailService.loadUserByUsername(name);

            if (userAccount == null) {
                log.error(":::::::: LOGIN FAIL ::::::::");
                throw new BadCredentialsException(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadCredentialsException(name);
        }

        return new UsernamePasswordAuthenticationToken(userAccount, password, userAccount.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
