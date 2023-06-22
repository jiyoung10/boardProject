package com.example.demo.controller;

import com.example.demo.controller.request.JoinRequest;
import com.example.demo.controller.request.LoginRequest;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm(){
        return "member/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute JoinRequest joinRequest) throws Exception {
        memberService.join(joinRequest);
        return "member/login";
    }

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, Model model) throws Exception {
        model.addAttribute("loginResponse", memberService.login(loginRequest));
        return "member/loginAfter";
    }

}
