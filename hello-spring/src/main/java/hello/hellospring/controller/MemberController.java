package hello.hellospring.controller;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//컨트롤러라는 어노테이션을 붙이면 Spring 컨테이너에서 빈으로 스프링이 관리 해준다.
@Controller
public class MemberController {

    private final MemberService memberService;

    //DI
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

}
