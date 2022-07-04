package Hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
    //데배 확정이 안되어서 MemoryMemberRepository 생성
@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();    //저장소니까 넣을값이 있어야함

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findBId(Long memberId) {
        return store.get(memberId);
    }
}
