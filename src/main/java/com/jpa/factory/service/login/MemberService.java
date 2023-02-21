package com.jpa.factory.service.login;

import com.jpa.factory.model.entity.secondary.Member;
import com.jpa.factory.repository.secondary.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName    : com.jpa.factory.service.login
 * fileName       : UserService
 * author         : 오주담
 * date           : 2022-12-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-21        오주담       최초 생성
 */
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }
}
