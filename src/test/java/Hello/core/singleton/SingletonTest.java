package Hello.core.singleton;

import Hello.core.AppConfig;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 di 컨테이너")

    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        
        //1 . 조회 : 호출할 떄 마다 객체를 생성 하는지?
        MemberService memberService1 = appConfig.memberService();
        
        //2 . 조회 : 호출할 떄 마다 객체를 생성 하는지?
        MemberService memberService2 = appConfig.memberService();

        //3. 객체를 생성하지만 참조 값이 다름
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);

//        요청시마다 객체생성
//        해결 > 객체 1개만 생성하고 공유하면됨 >> 싱글톤패턴

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
//      new SingletonService();  private 라서 안됨
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
        // same   == 객체 인스턴스 참조 비교
        // equal  == 자바 비교
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글")

    void springContainer(){
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
// 싱글톤 컨테이너에 등록해줌
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        //3. 객체를 생성하지만 참조 값이 다름
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 == memberService2
        assertThat(memberService1).isSameAs(memberService2);

//        요청시마다 객체생성
//        해결 > 객체 1개만 생성하고 공유하면됨 >> 싱글톤패턴

    }
}


