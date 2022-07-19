package Hello.core;

import Hello.core.member.MemberRepository;
import Hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan // 자동으로 스프링 빈을 긁어서 끌어올림
        (
                basePackages = "Hello.core.member",
                basePackageClasses = AutoAppConfig.class,
                excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
                //@ComponentScan 를 붙이면 @Configuration이 붙은 설정 정보도 자동으로 등록되니때문에 필터해
        )
public class AutoAppConfig {
        @Bean(name = "memoryMemberRepository")
        MemberRepository memberRepository() {
                return new MemoryMemberRepository() {
                };
        }
}

