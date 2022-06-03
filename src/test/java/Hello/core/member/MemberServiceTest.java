package Hello.core.member;

import Hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

        MemberService memberService;

        @BeforeEach
        public void beforeEach(){
            AppConfig appConfig = new AppConfig();
            memberService = appConfig.memberService();
        }

    @Test
    void join(){
        //given
        Member member = new Member(1L,"송보석",Grade.VIP);     //VIP를 만들어

        //when
        memberService.join(member);                                     // 조인을해
        Member findMember = memberService.findMember(1L);

        //when
        Assertions.assertThat(member).isEqualTo(findMember);  // 조인한거랑 찾은거를 검증해
    }
}

//test