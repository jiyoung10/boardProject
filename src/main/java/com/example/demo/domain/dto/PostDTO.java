package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private String createdAt;

    public static PostDTO fromPost(Post post) {
        return new PostDTO(
                post.getId(),
                post.getAuthor(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt().toString()
        );
    }
}
