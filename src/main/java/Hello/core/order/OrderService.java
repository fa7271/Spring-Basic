package Hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

    //최종 오더를 반환한다 >> 구현
}
