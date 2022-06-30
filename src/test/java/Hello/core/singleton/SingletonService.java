package Hello.core.singleton;

public class SingletonService {
    //1개만 존재하게 됨
    //static 영역에 생성 new 를 통해 생성한 객체는 heap 영역에 생성 / 모든 객체가 공유 / 객체를 생성하지 않고도 static 자원 접근 가능
    private static final SingletonService instance = new SingletonService();

    // getInstane를 통해서 조회 할 수 있다.
    public static SingletonService getInstance(){
        return instance;
    }
    private SingletonService(){
        //new 로 생성하는거 막음
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
