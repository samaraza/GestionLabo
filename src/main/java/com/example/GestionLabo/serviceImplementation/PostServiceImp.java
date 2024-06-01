package com.example.GestionLabo.serviceImplementation;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Posts;
import com.example.GestionLabo.repository.PostRepository;
import com.example.GestionLabo.requestDto.PostRequestDto;
import com.example.GestionLabo.serviceDeclaration.PostServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostServiceDec {
    private final PostRepository postRepositry ;
    @Override
    public Posts createPost(PostRequestDto post) {
        Posts post2 = Posts.builder()
                .title(post.getTitle())
                .date(post.getDate())
                .content(post.getContent())
                .build();
        return this.postRepositry.save(post2);
    }

    @Override
    public List<Posts> getAllPosts() {
        return postRepositry.findAll();
    }

    @Override
    public Posts updatePost(String id, Posts post) {
        return null;
    }

    @Override
    public void deletePost(String id) {
        if (!this.postRepositry.existsById(id)) {
            throw new CustomNotFoundException("product", id);
        }
        this.postRepositry.deleteById(id);

    }
}
