package Hello.core.beanfind;

import Hello.core.AppConfig;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")

    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);     // 멤버서비스가 멤버서비스임플에 있으면 성공
    }

    @Test
    @DisplayName("타입으로만 조회")
//구체화보다는 인터페이스를 써주는게 좋음 (역할 의존)
    void findBeanByType(){
        MemberService memberService = ac.getBean( MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);     // 멤버서비스가 멤버서비스임플에 있으면 성공
    }

    @Test
    @DisplayName("구체으로 조회") // 유연성이 떨어진다.

    void findBeanByName2(){
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);     // 멤버서비스가 멤버서비스임플에 있으면 성공
    }

    @Test
    @DisplayName("없음")
    void findBeanByNameX(){
        //MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, // 무조건 터져야한다 예외가 성공 해야한다.
                ()->ac.getBean("xxxx", MemberService.class)); // 이게 실행했을때
        // 예외가 던져지면 성공
    }
}
