package com.jpa.factory.model.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * packageName    : com.jpa.factory.model.entity.common
 * fileName       : commonEntity
 * author         : 오주담
 * date           : 2023-01-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-05        오주담       최초 생성
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    protected String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    protected LocalDateTime createdAt;

    protected String updatedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    protected LocalDateTime updatedAt;

    @Column(columnDefinition = "char")
    protected String isUse;

    @Transient
    protected String classify;

    @Transient
    protected String keyword;
}
