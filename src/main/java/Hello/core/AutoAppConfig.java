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
                excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //타입 정해서 뺌
        )
public class AutoAppConfig {
        @Bean(name = "memoryMemberRepository")
        MemberRepository memberRepository() {
                return new MemoryMemberRepository() {
                };
        }
}

