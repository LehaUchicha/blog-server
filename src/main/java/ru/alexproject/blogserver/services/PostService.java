package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.dto.PostDto;

import java.util.List;

public interface PostService {

    List<Post> getPosts();

    void save(Post post);

    void updatePost(Long id, Post post);

    void deletePost(Long id);

    Post getPostById(Long id);
}
