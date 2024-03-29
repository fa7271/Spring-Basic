package Hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {
    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1"); // 빈 조회하기 직전에 생성되기 때문에

        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class); // 이때 init 이 호출됨
        System.out.println("find prototypeBean2");

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close(); // 프로토 타입이라 호출 안됨 /이미 만들고 버린거임

        prototypeBean1.destroy(); // 수동으로 직접 호출
        prototypeBean2.destroy();
    }
    @Scope("prototype")
//    @Component  17번 줄 땜에 알아서 해줌
    static class PrototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("destroy");
        }
    }
}
