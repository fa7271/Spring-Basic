package Hello.core.member;

public interface MemberRepository { //인터페이스 안건드림

    void save(Member member);   //멤버 회원을 저장 void 는 리턴값이 없음 헷갈리지 말기.
    Member findBId(Long memberId);// 회원의 아이디를 찾는기능
}

//구현체 만들기>>MemberRepositoryImpl
