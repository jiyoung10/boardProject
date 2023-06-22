package com.example.demo.domain.entity;

import com.example.demo.controller.request.PostRequest;
import com.example.demo.controller.request.PostUpdateRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt = now();

    public Post(String title, String author, String content){
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public void update(PostUpdateRequest postUpdateRequest){
        this.author = postUpdateRequest.getAuthor();
        this.title = postUpdateRequest.getTitle();
        this.content = postUpdateRequest.getContent();
    }

    public static Post of(PostRequest postRequest) {
        return new Post(
                postRequest.getAuthor(),
                postRequest.getTitle(),
                postRequest.getContent()
        );
    }
}
