package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.model.Post;
import org.example.data.repo.PostRepo;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostServices implements PostService{
    private  final PostRepo postRepo;
    @Override
    public Post addPost(String title, String content, String imgUrl) {
        Post post = new Post();
        post.setContent(content);
        post.setTitle(title);
        post.setImgUrl(imgUrl);
        return postRepo.save(post);
    }

    @Override
    public Post addPost(String title, String content) {
        Post post = new Post();
        post.setContent(content);
        post.setTitle(title);
        return postRepo.save(post);
    }
}
