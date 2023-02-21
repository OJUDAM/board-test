package com.jpa.factory.model.dto.admin;

import lombok.Getter;

/**
 * packageName    : com.jpa.factory.model.dto.admin
 * fileName       : AuthorMngDTO
 * author         : 오주담
 * date           : 2023-01-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-05        오주담       최초 생성
 */
@Getter
public class AuthorMngDTO {

    public String baSeq;

    public String baCode;

    public String userId;

    public String bmSeq;

    public String createdBy;

    public String createdAt;

    public String updatedBy;

    public String updatedAt;

    public String isUse;

    //검색 조건
    public String classify;
    //검색 내용
    public String keyword;
}
