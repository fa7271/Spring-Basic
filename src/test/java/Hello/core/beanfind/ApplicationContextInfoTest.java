package Hello.core.beanfind;

import Hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("다 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 꺼냄
        for (String beanDefinitionName : beanDefinitionNames) { //beanDefinitionNames 에 있는 앞에 변수에 넣어서 포문 돌림
            Object bean = ac.getBean(beanDefinitionName);   // 타입을 몰라서 object로 끄냄
            System.out.println("name = " + beanDefinitionName + " object =" +bean);
        }
    }
    @Test
    @DisplayName("둥록된 bean만 출력")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);// bean의 하나하나 정보들

            // role_application  직접 등록하는 빈
            // role_INFRASTRUCTURE 스프링이 내부에서 사용하는빈

            if (beanDefinition.getRole () == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName); //
                System.out.println("name = " + beanDefinitionName + " object =" +bean);
//                beanDefinition.getRole () == BeanDefinition.ROLE_APPLICATION
//                주로 애플리케이션을 개발하기 위해 등록한 빈 / 혹은 외부 라이브러리
//                ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            }
        }
    }
}
