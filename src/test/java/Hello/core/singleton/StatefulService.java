package Hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 문제점 10000원이 20000원으로 바꿔치기됨 똑같은 컨테이너를 사용하기 때문
    }
// 2    public int order(String name, int price){
// 2       System.out.println("name = " + name + " price = " + price);
// 2       return price;
// 2   }
//    해결 방안 5번째줄도 주석처리
    public int getPrice(){
        return price;
    }
}
//커맨드 시프트 t > 테스트코드 만들기