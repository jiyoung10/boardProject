package com.example.demo.service;

import com.example.demo.controller.request.JoinRequest;
import com.example.demo.controller.request.LoginRequest;
import com.example.demo.controller.response.JoinResponse;
import com.example.demo.controller.response.LoginResponse;
import com.example.demo.domain.dto.MemberDTO;
import com.example.demo.domain.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원 가입
    public void join(JoinRequest joinRequest) throws Exception {
        // 가입 아이디 중복 시 예외 발생
        if(memberRepository.findByUserId(joinRequest.getUserId()).isPresent()){
          throw new Exception("MEMBER_ALREADY_EXIST");
        }
        Member member = Member.of(joinRequest);
        // 회원 정보 저장
        memberRepository.save(member);
    }

    // 로그인
    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        // 일치하는 회원 없을 시 예외 발생
        Member member = memberRepository.findByUserId(loginRequest.getUserId()).orElseThrow(
                 ()-> new Exception("MEMBER_DOSE_NOT_EXIST"));

        return LoginResponse.fromMemberDTO(MemberDTO.fromMember(member));
    }

}
