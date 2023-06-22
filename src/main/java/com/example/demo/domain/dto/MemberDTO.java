package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDTO {
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private String phoneNumber;
    private String createdAt;

    public static MemberDTO fromMember(Member member){
        return new MemberDTO(
                member.getId(),
                member.getUserId(),
                member.getPassword(),
                member.getUserName(),
                member.getPhoneNumber(),
                member.getCreatedAt().toString()
        );
    }

}
