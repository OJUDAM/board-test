package com.jpa.factory.model.entity.primary;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jpa.factory.model.entity.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * packageName    : com.jpa.factory.model.entity.primary
 * fileName       : BoardMng
 * author         : 오주담
 * date           : 2023-01-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-05        오주담       최초 생성
 */

@Entity
@Table(name = "BOARD_MNG", schema = "boarddb")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorColumn
public class BoardMng extends BaseEntity implements Serializable {

    @Id
    private String bmSeq;

    private String bmType;

    private String bmCode;

    private int bmAttachSize;

    private int bmAttachCount;

    @Column(columnDefinition = "char")
    private String bmActivate;

    private String menuSeq;

    @Column(columnDefinition = "char")
    private String bmLinkType;

    @ManyToOne
    @JoinColumn(name = "menuSeq", referencedColumnName = "menuSeq", insertable = false, updatable = false, nullable = false)
    private Menu Menu;

}
