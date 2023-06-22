package com.example.demo.domain.entity;

import com.example.demo.controller.request.JoinRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private String phoneNumber;
    private final LocalDateTime createdAt = now();

    public Member(String userId, String password, String userName, String phoneNumber){
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public static Member of(JoinRequest joinRequest) {
        return new Member(
                joinRequest.getUserId(),
                joinRequest.getPassword(),
                joinRequest.getUserName(),
                joinRequest.getPhoneNumber());
    }

}
