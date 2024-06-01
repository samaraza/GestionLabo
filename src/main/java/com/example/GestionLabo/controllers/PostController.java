package com.example.GestionLabo.controllers;

import com.example.GestionLabo.models.Posts;
import com.example.GestionLabo.requestDto.PostRequestDto;
import com.example.GestionLabo.serviceImplementation.PostServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
@Slf4j
public class PostController {

    private final PostServiceImp postServiceImp ;
    public PostController(PostServiceImp postServiceImp) {
        this.postServiceImp = postServiceImp;
    }
    @PostMapping("")
    public Posts createPost(@RequestBody PostRequestDto postRequestDto) {


        log.info(""+postRequestDto);

        return postServiceImp.createPost(postRequestDto);
    }
    @GetMapping("")
    public List<Posts> getAllPosts() {
        return postServiceImp.getAllPosts();
    }
    public Posts updatePost(String id, Posts post) {

        return postServiceImp.updatePost(id, post);
    }
    @DeleteMapping("{id}")
    public void deletePost(  @PathVariable("id") String id)
    {
        postServiceImp.deletePost(id);
    }

}
