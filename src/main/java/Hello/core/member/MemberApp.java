package Hello.core.member;

import Hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//되나 안되나
public class MemberApp {

    public static void main(String[] args) {

//        2 AppConfig appConfig = new AppConfig();                      //appconfig 사용 개발
//        2 MemberService memberService = appConfig.memberService();    //memverserivce 를 꺼내 멤버서비스안에는 impl들어있음

//       1 MemberService memberService = new MemberServiceImpl();        // 직접 해주는거임 별로 안좋다

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //객체를 관리해줌 appconfig에 있는 @ 붙은것들을 스프링 컨테이너에 넣고 관리
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        // config에서 멤버서비스 끄낼때 보통 메소드 이름으로 등록이 되어있음 뒤에는 타입 // 호출하는거
        Member member = new Member(1L, "Member A ", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }

}
