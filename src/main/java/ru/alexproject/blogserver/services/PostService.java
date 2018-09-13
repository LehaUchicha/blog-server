package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> getPosts();

    void save(PostDto post);

    void updatePost(Long id, PostDto post);

    void deletePost(Long id);

    PostDto getPostById(Long id);
}
