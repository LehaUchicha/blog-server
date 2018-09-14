package ru.alexproject.blogserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.repositories.PostRepository;
import ru.alexproject.blogserver.services.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDto getPostById(Long id) {
        return postRepository.findOne(id).toDto();
    }

    @Override
    public void save(PostDto post) {
        postRepository.save(post.toEntity());
    }

    public List<PostDto> getPosts() {
        List<PostDto> posts = new ArrayList<>();
        postRepository.findAll().forEach(p -> posts.add(p.toDto()));
        return posts;
    }

    @Override
    public void updatePost(Long id, PostDto postDto) {
        Post persistent = postRepository.findOne(id);
        Optional.ofNullable(postDto.getTitle())
                .ifPresent(persistent::setTitle);
        Optional.ofNullable(postDto.getShortText())
                .ifPresent(persistent::setShortText);
        Optional.ofNullable(postDto.getFullText())
                .ifPresent(persistent::setFullText);
        Optional.ofNullable(postDto.getComments())
                .ifPresent(persistent::setComments);
        postRepository.save(persistent);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.delete(id);
    }


}
