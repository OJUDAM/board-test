package com.jpa.factory.model.entity.primary;

import com.jpa.factory.model.entity.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * packageName    : com.jpa.factory.model.entity.primary
 * fileName       : AuthorMngDTO
 * author         : 오주담
 * date           : 2022-12-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-29        오주담       최초 생성
 */

@Entity
@Table(name = "BOARD_AUTHOR", schema = "boarddb")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthorMng extends BaseEntity implements Serializable {

    @Id
    private String baSeq;

    private String baCode;

    private String userId;

    private String bmSeq;

    @ManyToOne
    @JoinColumn(name = "bmSeq", referencedColumnName = "bmSeq", insertable = false, updatable = false, nullable = false)
    private BoardMng boardMng;

}
