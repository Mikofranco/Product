package org.example.service;

import org.example.data.model.Post;

public interface PostService {
    Post addPost(String title, String content, String imgUrl);
    Post addPost(String title, String content);

}
