package Hello.core.order;

import Hello.core.annotation.MainDiscountPolicy;
import Hello.core.discount.DiscountPolicy;
import Hello.core.discount.FixDiscountPolicy;
import Hello.core.discount.RateDiscountPolicy;
import Hello.core.member.Member;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemberServiceImpl;
import Hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final이 붙은걸 가지고 생성자를 만들어줌 31~34 줄을 만들어 줌
public class OrderServiceImpl implements OrderService{

// 2   private final MemberRepository memberRepository = new MemoryMemberRepository();//회원 찾아야함
//  1 private final DiscountPolicy discountPolicy = new FixDiscountPolicy();//고정할인정책 가져와야함   >>>>>>>>>>>> ratediscountpolciy로바꿔야함
//  1 private final DiscountPolicy discountPolicy = new RateDiscountPolicy();                        객체를 직접 생성하고 선택하는 꼴 // 이거랑 위에는 구체화된거에 의존돼서 dip위반됨,,  >> 추상에만 의존하게 변경(인터페이스)

// 2 ***  private DiscountPolicy discountPolicy;   //  인터페이스에만 의존함  >> 근데 구현체가없는데 어떻게 실행된다는 의문이 생김  >> nullpoinException
// >>> 누군가가 구현객체를 생성하고 대신생성하고 주입해주어야하한다 >>> 예를들면 원래는 배우가 공연도하고 상대 배역도 찾는다>> 배우는 공연만, 상대배역은 기획자가
//   해결 >>> 기획자 역할이 appconfig> 구현객체를 생성하고 연결하는 책임을 가지는 별도의 클래스

    private final MemberRepository memberRepository;    //순수한 인터페이스에만 의존
    private final DiscountPolicy discountPolicy;         //순수한 인터페이스에만 의존
    //private final 로 되어있으면 무조건 생성자나 기본으로 할당 되어야함

    @Autowired // 생성자가 1개면 생략가능. >> 이전은 appcconfig 에서 new로 의존관계를 주입해주는것.
//    @MainDiscountPolicy Discountpolicy 가 우선임
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {       //orderservice 타입이 orderd인 createOrder 클래스
        Member member = memberRepository.findBId(memberId);                  //회원정보조회
        int discountPrice = discountPolicy.discount(member, itemPrice);      //할인정책에다가 넘김

        return new Order(memberId,itemName,itemPrice,discountPrice);    // 갔다가 돌아옴
    }

    // test code
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
