package com.example.demo.controller.response;

import com.example.demo.domain.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String author;
    private String title;
    private String content;
    private String createdAt;
    public static PostResponse fromPostDTO(PostDTO postDTO) {
        return new PostResponse(
                postDTO.getId(),
                postDTO.getAuthor(),
                postDTO.getTitle(),
                postDTO.getContent(),
                postDTO.getCreatedAt()
        );
    }
}
