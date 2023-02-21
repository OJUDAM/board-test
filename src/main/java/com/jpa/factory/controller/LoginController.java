package com.jpa.factory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName    : com.jpa.factory.controller
 * fileName       : LoginController
 * author         : 오주담
 * date           : 2022-12-20
 * description    : 관리자 로그인 컨트롤러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-20        오주담       최초 생성
 */


@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String goLoginForm() {
        return "login/login";
    }
}
