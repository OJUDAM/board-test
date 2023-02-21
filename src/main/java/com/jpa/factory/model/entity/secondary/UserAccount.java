package com.jpa.factory.model.entity.secondary;

import org.springframework.security.core.userdetails.User;

import javax.persistence.Entity;

/**
 * packageName    : com.jpa.factory.model.entity.secondary
 * fileName       : UserAccount
 * author         : 오주담
 * date           : 2022-12-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-21        오주담       최초 생성
 */

public class UserAccount extends User {

    private final CustomUserDetails account;

    public UserAccount(CustomUserDetails account) {
        super(account.getUserId(), account.getUserPassword(), account.getAuthorities());
        this.account = account;
    }

    public CustomUserDetails getAccount() {
        return account;
    }
}
