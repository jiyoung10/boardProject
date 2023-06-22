package com.example.demo.service;

import com.example.demo.controller.request.JoinRequest;
import com.example.demo.controller.request.PostRequest;
import com.example.demo.controller.request.PostUpdateRequest;
import com.example.demo.controller.response.PostResponse;
import com.example.demo.domain.dto.PostDTO;
import com.example.demo.domain.entity.Post;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponse savePost(PostRequest postRequest) {
        Post post = Post.of(postRequest);
        postRepository.save(post);
        return PostResponse.fromPostDTO(PostDTO.fromPost(post));
    }

    public List<Post> getPostList() {
        List<Post> postList = postRepository.findAll();
        return postList;
    }

    public PostResponse updatePost(Long postId, PostUpdateRequest postUpdateRequest) throws Exception {
        // 게시글이 존재하지 않을 시 예외 발생
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new Exception("POST_DOSE_NOT_EXIST"));

        post.update(postUpdateRequest);
        postRepository.save(post);
        return PostResponse.fromPostDTO(PostDTO.fromPost(post));
    }

    public void delete(Long id) throws Exception {
        // 게시글이 존재하지 않을 시 예외 발생
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new Exception("POST_DOSE_NOT_EXIST"));

        postRepository.delete(post);
    }

    public PostResponse postView(Long postId) throws Exception {
        // 게시글이 존재하지 않을 시 예외 발생
        Post post = postRepository.findById(postId).get();

        return PostResponse.fromPostDTO(PostDTO.fromPost(post));
    }

}
