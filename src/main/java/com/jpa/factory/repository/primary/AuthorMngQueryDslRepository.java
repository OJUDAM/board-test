package com.jpa.factory.repository.primary;

import com.jpa.factory.model.entity.primary.AuthorMng;
import com.jpa.factory.model.entity.primary.QAuthorMng;
import com.jpa.factory.model.entity.primary.QBoardMng;
import com.jpa.factory.model.entity.primary.QMenu;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName    : com.jpa.factory.repository.primary
 * fileName       : AuthorMngQueryDslRepository
 * author         : 오주담
 * date           : 2023-01-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-05        오주담       최초 생성
 */
@Repository
@RequiredArgsConstructor
public class AuthorMngQueryDslRepository{

    private final JPAQueryFactory primaryQueryFactory;

    public List<AuthorMng> findAllWithMenu() {
        //프로젝트 컴파일 하면 자동으로 Q 클래스 생성됨
        QAuthorMng authorMng = QAuthorMng.authorMng;
        QBoardMng boardMng = QBoardMng.boardMng;
        QMenu menu = QMenu.menu;

        return primaryQueryFactory
                .selectFrom(authorMng)
                .leftJoin(authorMng.boardMng, boardMng)
                .fetchJoin()
                .distinct()
                .fetch();
    }

    public List<AuthorMng> findAllWithBoardMngAndMenu() {
        //프로젝트 컴파일 하면 자동으로 Q 클래스 생성됨
        QAuthorMng authorMng = QAuthorMng.authorMng;
        QBoardMng boardMng = QBoardMng.boardMng;
        QMenu menu = QMenu.menu;


        return primaryQueryFactory
                .selectFrom(authorMng)
                .leftJoin(authorMng.boardMng, boardMng)
                .fetchJoin()
                .leftJoin(boardMng.Menu, menu)
                .fetchJoin()
                .distinct()
                .fetch();
    }

    public Page<AuthorMng> findAllWithBoardMngAndMenuPageable(Pageable pageable) {
        //프로젝트 컴파일 하면 자동으로 Q 클래스 생성됨
        QAuthorMng authorMng = QAuthorMng.authorMng;
        QBoardMng boardMng = QBoardMng.boardMng;
        QMenu menu = QMenu.menu;

        List<AuthorMng>  content = primaryQueryFactory
                .selectFrom(authorMng)
                .leftJoin(authorMng.boardMng, boardMng)
                .fetchJoin()
                .leftJoin(boardMng.Menu, menu)
                .fetchJoin()
                .distinct()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = primaryQueryFactory
                .select(authorMng.baSeq.count())
                .from(authorMng)
                .leftJoin(authorMng.boardMng, boardMng)
                //.fetchJoin()
                .leftJoin(boardMng.Menu, menu)
                //.fetchJoin()
                .distinct();

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    public List<AuthorMng> findAllWithMenuByBaSeq() {
        //프로젝트 컴파일 하면 자동으로 Q 클래스 생성됨
        QAuthorMng authorMng = QAuthorMng.authorMng;

        return primaryQueryFactory
                .selectFrom(authorMng)
                .leftJoin(authorMng.boardMng)
                .where(authorMng.baSeq.eq("202110200001"))
                .fetchJoin()
                .distinct()
                .fetch();
    }
}
