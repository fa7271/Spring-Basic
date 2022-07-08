package Hello.core.discount;

import Hello.core.annotation.MainDiscountPolicy;
import Hello.core.member.Grade;
import Hello.core.member.Member;
import jdk.jfr.Percentage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy") // 문자기 때문에 오류 잡기 힘듦
//@Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;// 10% 할인

    @Override       //vip만 1000원 할인 basic은 할인 x
    public int discount(Member member, int price) {
        if (member.getGrade() ==Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
