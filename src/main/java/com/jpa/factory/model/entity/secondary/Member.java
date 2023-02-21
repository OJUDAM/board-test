package com.jpa.factory.model.entity.secondary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * packageName    : com.jpa.factory.entity.login
 * fileName       : User
 * author         : 오주담
 * date           : 2022-12-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-21        오주담       최초 생성
 */

@Entity
@Table(name = "admin_user", schema = "BOARD")
@Getter
@Setter
@ToString
public class Member {

    @Id
    private String userId;

    private String userPassword;

    private String userHintQuestion;

    private String userHintAnswer;

    private String userKname;

    private String userNick;

    private String userName;

    private String userJumin;

    private String userSex;

    private String userSaengil;

    private String userEmail;

    private String userDefmail;

    private String userSinbun;

    private String userGroup;

    private String userSangtae;

    private String userPermit;

    private String userUpyeon;

    private String userJuso1;

    private String userJuso2;

    private String userHomeTel;

    private String userMobileTel;

    private String userOpen;

    private String userSogae;

    private String idUpdate;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    private String workdate;

    private String workid;

    private String userPasswordYn;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    private String userPwUpdateDate;
}
