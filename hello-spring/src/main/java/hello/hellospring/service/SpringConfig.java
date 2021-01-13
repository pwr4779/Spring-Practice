package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 컴포넌트 스캔방식이 편하긴 하지만 자바코드로 bean 생성 방법을 알아야한다.
 * 과거에는 xml로 빈을 설정했지만 지금은 안한다.
 * DI 3가지 방법
 * 1. 생성자로 들어가는방법,
 * 2. 필드 주입 방법(안좋음),
 * 3. setter 주입(단점:setting하고 이후에 접근하므로 public으로 열려 있는게 단점.)
 * 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용.
 * 정형화되지 않거나 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.
 */

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    //직접 설정 파일을 사용을 하면 DB가 설정이 안됬을 때 임시로 하나의 레포지토리로 구현 후
    // 나중에 여기만 DB레포지토리로만 바꿔 넣으면 된다.
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


}
