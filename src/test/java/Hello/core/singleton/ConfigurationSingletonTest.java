package Hello.core.singleton;

import Hello.core.AppConfig;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemberServiceImpl;
import Hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepsitory = ac.getBean("memberRepository", MemberRepository.class);
        //impl 에 있는 메소드 끄내려고

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepsitory = " + memberRepsitory);


        // new 로 호출하면 다른 인스턴스가 생성되어야 하는데 안된다는 의문을 가질 수 있다.
        // >> 이미 생성된 인스턴스는 만들지 않는다.
        // @Configuration 이 적용된 Appconfig 때문
        // 스스링이 CGLIB라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한 것


        // 모두 같은 인스턴스를 참고하고있다.
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepsitory);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepsitory);
    }
    @Test
    void configurataionDeap(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean은  " + bean.getClass());
    }
}
