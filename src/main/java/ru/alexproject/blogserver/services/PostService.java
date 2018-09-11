package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getPosts();

    void createPost(Post post);

    void updatePost(Long id, Post post);

    void deletePost(Long id);

    Post getPostById(Long id);

    void save(Post post);
}
