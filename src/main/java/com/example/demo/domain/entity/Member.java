package com.example.demo.domain.entity;

import com.example.demo.controller.request.JoinRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "member")
@Getter
@Table(name = "member")
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "password")
    private String password;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

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
