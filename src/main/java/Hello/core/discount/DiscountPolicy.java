package Hello.core.discount;

import Hello.core.member.Member;

public interface DiscountPolicy {

    //@return 할인대상금액
    int discount(Member member, int price);
//구현체를 만들어야함
}
