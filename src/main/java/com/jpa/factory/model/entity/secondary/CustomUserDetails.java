package com.jpa.factory.model.entity.secondary;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * packageName    : com.jpa.factory.model.entity.secondary
 * fileName       : CustomUserDetails
 * author         : 오주담
 * date           : 2022-12-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-21        오주담       최초 생성
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "admin_user", schema = "BOARD")
public class CustomUserDetails  implements UserDetails {


    @Id
    private String userId;
    private String userPassword;
    private String userKname;
    private String userNick;
    private String userName;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> auths = new ArrayList<>();
        if(this.userId.equals("webmaster")) {
            auths.add(new SimpleGrantedAuthority("ROLE_WEBMASTER"));
        }
        auths.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

        return auths;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
