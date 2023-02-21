package com.jpa.factory.model.entity.primary;

import com.jpa.factory.model.entity.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Menu", schema = "menu")
@Getter
@Setter
public class Menu extends BaseEntity {
    @Id
    @Column(nullable = false)
    private String menuSeq;

    private String menuName;

    private Integer menuOrder;

    private Integer menuDepth;

    private String menuParent;

    private String menuSite;

    private String menuUrl;

    @Column(columnDefinition = "TEXT")
    private String menuContent;

    private String menuType;

//    private String createdAt;
//
//    private String createdBy;
//
//    private String updatedAt;
//
//    private String updatedBy;
//
//    @ColumnDefault(value = "Y")
//    @Column(columnDefinition = "char")
//    private String isUse;

    private String menuImage;

    private String menuUrlBack;

    @ColumnDefault(value = "Y")
    @Column(columnDefinition = "char")
    private String menuActivate;
}
