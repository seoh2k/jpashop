package jpabook.jpashop.service;

import jpabook.jpashop.exception.NotEoughStockException;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //readOnly = true : 데이터의 변경이 없는 읽기전용 메서드에 사용, 성능향상
@RequiredArgsConstructor // lombok
public class MemberService {

    private final MemberRepository memberRepository; // final: 컴파일 시점에 memberRepository를 설정하지 않는 오류를 체크할 수 있음

    /**
     * 회원가입
     */
    @Transactional // 변경
    public Long join(Member member) {

        validationDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validationDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
