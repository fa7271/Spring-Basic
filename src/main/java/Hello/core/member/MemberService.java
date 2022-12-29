package Hello.core.member;

// 회원가입 회원조회 역할
public interface MemberService {

    void join(Member member);               //회원가입
    Member findMember(Long memberId);       //회원조회
}
//구현체만들기 MemberServiceImpl