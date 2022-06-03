package Hello.core;

public class ClientRequirments {
    /*
        회원 가입 / 조회가능
        등급 일반/ vip
        자체베이스 / 외부시스템 연동

        회원은 상품 주문
        등급에따라 할인 정책
        모든 vip는 1000원 할인(고정금액 할인)
        할인 정책 변경 가능성 높음 / 오픈직전까지 미루고 싶음/ 안 할 수도있음

        스프링없는 순수 자바로 개발 후반부에 스프링으로 개발

        도메인 설계
        1 회원은 가입 조회
        2 일반과 vip
        3 자체db , 외부 시스템
        클라이언트 > 회원서비스 > 회원저장소(메모리 저장소 / db저장소 / 외부 시스템 연동 회원 저장소)

        memberservice (interface) << memberserivceimpl >> MemberRepository(interface)      << MEmoryMEmberRepository
                                                                                           << DbMEmberRepositry
        회원 객체 다이어그램
        클라이언트 > 회원서비스impl > 메모리 회원 저장소

        회원 서비스 : MemberServiceImpl


        ==================
        새로운 할인정책 금액별로 할인기준이 다름



     */
}
