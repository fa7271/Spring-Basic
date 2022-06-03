package Hello.core;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.order.Order;
import Hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrderApp {
    public static void main(String[] args) {

// 1        AppConfig appConfig = new AppConfig();
// 1       MemberService memberService = appConfig.memberService();        // 두개를 꺼내서 씀
// 1        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null,null);

        Long memberId = 1L;
        Member member = new Member(memberId,"song", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "knife", 10000);

        System.out.println("order = " + order);
    }
}
