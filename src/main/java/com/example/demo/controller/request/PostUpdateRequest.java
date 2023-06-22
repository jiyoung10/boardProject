package com.example.demo.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateRequest {
    private String title;
    private String author;
    private String content;
}
