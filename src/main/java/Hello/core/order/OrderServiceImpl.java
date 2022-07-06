package Hello.core.order;

import Hello.core.discount.DiscountPolicy;
import Hello.core.discount.FixDiscountPolicy;
import Hello.core.discount.RateDiscountPolicy;
import Hello.core.member.Member;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemberServiceImpl;
import Hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

// 2   private final MemberRepository memberRepository = new MemoryMemberRepository();//회원 찾아야함
//  1 private final DiscountPolicy discountPolicy = new FixDiscountPolicy();//고정할인정책 가져와야함   >>>>>>>>>>>> ratediscountpolciy로바꿔야함
//  1 private final DiscountPolicy discountPolicy = new RateDiscountPolicy();                        객체를 직접 생성하고 선택하는 꼴 // 이거랑 위에는 구체화된거에 의존돼서 dip위반됨,,  >> 추상에만 의존하게 변경(인터페이스)

// 2 ***  private DiscountPolicy discountPolicy;   //  인터페이스에만 의존함  >> 근데 구현체가없는데 어떻게 실행된다는 의문이 생김  >> nullpoinException  >>> 누군가가 구현객체를 생성하고 대신생성하고 주입해주어야하한다  << 존나중요

    private final MemberRepository memberRepository;    //순수한 인터페이스에만 의존
    private final DiscountPolicy discountPolicy;         //순수한 인터페이스에만 의존

    @Autowired // 생략가능
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //private final 로 되어있으면 무조건 생성자나 기본으로 할당 되어야함
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
