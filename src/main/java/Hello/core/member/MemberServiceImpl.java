package Hello.core.member;


//회원가입 조회
public class MemberServiceImpl implements MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); // MemoryMemberRepository 구현체에서 가져와서 memberRepository 넣어줌 // 직접 넣어주는거임 >>
     private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {       //생성자를 통해서 memberRepository 뭐가들어갈지 구현
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findBId(memberId);
    }
}
