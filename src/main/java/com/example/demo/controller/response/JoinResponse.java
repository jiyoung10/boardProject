package com.example.demo.controller.response;

import com.example.demo.domain.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoinResponse {
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private String phoneNumber;
    private String createdAt;

    public static JoinResponse fromMemberDTO(MemberDTO memberDTO) {
        return new JoinResponse(
                memberDTO.getId(),
                memberDTO.getUserId(),
                memberDTO.getPassword(),
                memberDTO.getUserName(),
                memberDTO.getPhoneNumber(),
                memberDTO.getCreatedAt()
        );
    }
}
