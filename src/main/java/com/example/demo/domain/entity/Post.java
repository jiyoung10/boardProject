package com.example.demo.domain.entity;

import com.example.demo.controller.request.PostRequest;
import com.example.demo.controller.request.PostUpdateRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "post")
@Getter
@Table(name = "post")
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

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
