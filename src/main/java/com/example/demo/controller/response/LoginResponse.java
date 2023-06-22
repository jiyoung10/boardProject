package com.example.demo.controller.response;

import com.example.demo.domain.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private String phoneNumber;
    private String createdAt;

    public static LoginResponse fromMemberDTO(MemberDTO memberDTO) {
        return new LoginResponse(
                memberDTO.getId(),
                memberDTO.getUserId(),
                memberDTO.getPassword(),
                memberDTO.getUserName(),
                memberDTO.getPhoneNumber(),
                memberDTO.getCreatedAt()
        );
    }
}
