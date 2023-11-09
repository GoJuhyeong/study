package study.project.controller;

import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/member")
    public String memberForm() {
        return "member-form";
    }

    @PostMapping("/member")
    public String memberSave(MemberDto memberDto) {
        memberService.memberSave(memberDto);
        return "login-form";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login-form";
    }

    @PostMapping("/login")
    public String login(MemberDto memberDto, HttpSession session) {
        MemberDto loginResult = memberService.login(memberDto);
        if (loginResult != null) {
            //로그인 성공
            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "redirect:/posts";
        } else {
            //로그인 실패
            return "login-form";
        }

    }
}
