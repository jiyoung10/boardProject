package com.example.demo.controller;

import com.example.demo.controller.request.PostRequest;
import com.example.demo.controller.request.PostUpdateRequest;
import com.example.demo.domain.entity.Post;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 작성 폼 조회
    @GetMapping("/post")
    public String postForm(){
        return "board/post";
    }

    // 게시글 저장
    @PostMapping("/post")
    public String savePost(@ModelAttribute PostRequest postRequest, Model model){
        model.addAttribute("postResponse", postService.savePost(postRequest));
        return "board/postAfter";
    }

    // 게시글 수정
    @PostMapping("/post/update/{id}")
    public String updatePost(@PathVariable("id") Long id, @ModelAttribute PostUpdateRequest postUpdateRequest, Model model) throws Exception {
        model.addAttribute("postResponse", postService.updatePost(id, postUpdateRequest));
        return "/board/postAfter";
    }

    // 게시글 삭제
    @PostMapping("/post/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) throws Exception {
        postService.delete(id);
        return "board/postList";
    }

    //***** 게시판 리스트 *****
    @GetMapping("/postList")
    public String postList(Model model){
        List<Post> postList = postService.getPostList();
        model.addAttribute(postList);
        return "board/postList";
    }

    // 게시글 키워드 검색 조회
    @GetMapping("/post/search/{keyword}")
    public String searchPostByKeyword(@PathVariable("keyword") String keyword, Model model){
        log.info("GET /post/search/{}", keyword);
        List<Post> postList = postService.searchPostByKeyword(keyword);
        model.addAttribute(postList);
        return "board/postList";
    }

    // 게시글 상세 조회
    @GetMapping("/post/view")
    public String PostView(Long id, Model model) throws Exception {
        model.addAttribute("postView", postService.postView(id));
        return "board/postView";
    }

}
