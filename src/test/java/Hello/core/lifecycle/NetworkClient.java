package Hello.core.lifecycle;

//1번 import org.springframework.beans.factory.DisposableBean;
//1번 import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient { //1번 인터페이스 implements InitializingBean, DisposableBean
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //  서비스 시작시 호출
    public void connect() {
        System.out.println("conect :" + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message :" + message);

    }
    // 서비스 종료

    public void disconnect() {
        System.out.println(" close : " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("init ");
        connect();
        call(" 초기화 연결 메시지");
    }
    @PreDestroy
    public void close() {
        System.out.println("close");
        call(" 초기화 연결 메시지 2");
        disconnect();
    }
/*
1번 방식식    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call(" 초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        call(" 초기화 연결 메시지 2");
        disconnect();
    }
    */
}
