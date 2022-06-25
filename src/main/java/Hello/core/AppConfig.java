package Hello.core;

import Hello.core.discount.DiscountPolicy;
import Hello.core.discount.FixDiscountPolicy;
import Hello.core.discount.RateDiscountPolicy;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import Hello.core.member.MemoryMemberRepository;
import Hello.core.order.OrderService;
import Hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//관심사를 확실하게 분리 // ex)공연 기획자
//필요한 구현객체를 다 생성한다
//생성한 객체 인스턴스의 참를 생성자를 통해서 주입해준다
//구체 클래스를 직접 선택하고 전체 구성을 책임진다 impl은 기능을 실행하는 책임을 지면됨

//구성하는 영역

//프로그램의 제어흐름은 appconfig가 갖고있음
//ioC컨테이너 또는 DI컨테이너 요즘은 DI컨테이너라고함
@Configuration // + Bean 해주면 다 등록이 됨 AppConfig에 설정을 구성한다 라는 뜻
public class AppConfig {
    // @Bean 스프링 컨테이너에 스프링 빈으로 등록한다.
    @Bean
    public MemberService memberService() {                  //2
        return new MemberServiceImpl(memberRepository());   //구현체 생성 되는데 메모리 멤버 레파지토리가 들어옴  생상해서 impl를 생성 주입 >> 생성자 주입
    }
    @Bean
    public MemoryMemberRepository memberRepository() {     //1
        return new MemoryMemberRepository();                //MemoryMemberRepository 를 생성해서
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(), //
                  discountPolicy());  //두개들고 리턴됨
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
          return new RateDiscountPolicy();
    }
}
