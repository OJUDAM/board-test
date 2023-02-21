package com.jpa.factory.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * packageName    : com.jpa.factory.handler
 * fileName       : LoginSuccessHander
 * author         : 오주담
 * date           : 2022-12-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-21        오주담       최초 생성
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(12000); //20분

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) authentication.getPrincipal();
        String adminId = user.getUsername();

        if (adminId.equals("webmaster")) {
            response.sendRedirect("/admin/author-mng");
        } else {
            response.sendRedirect("/board/board?site=MAIN");
        }
    }
}
