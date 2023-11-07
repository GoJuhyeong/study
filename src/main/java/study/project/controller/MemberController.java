package study.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import study.project.dto.MemberDto;
import study.project.service.MemberService;


@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/save")
    public String memberForm() {
        return "memberForm";
    }

    @PostMapping("/member/save")
    public String memberSave(MemberDto memberDto) {
        System.out.println("memberDto = " + memberDto);
        memberService.memberSave(memberDto);
        return "redirect:/list";
    }
}
