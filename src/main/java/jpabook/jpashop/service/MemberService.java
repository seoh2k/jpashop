package jpabook.jpashop.service;

import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // 회원 가입
    
    // 회원 전체 조회
}
