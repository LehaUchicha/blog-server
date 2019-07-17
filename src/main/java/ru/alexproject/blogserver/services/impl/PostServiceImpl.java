package ru.alexproject.blogserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.repositories.PostRepository;
import ru.alexproject.blogserver.services.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    public Post getPostById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Cacheable("posts")
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(p -> posts.add(p));
        return posts;
    }

    @Override
    public void updatePost(Long id, Post post) {
        Post persistent = postRepository.findOne(id);
        Optional.ofNullable(post.getTitle())
                .ifPresent(persistent::setTitle);
        Optional.ofNullable(post.getShortText())
                .ifPresent(persistent::setShortText);
        Optional.ofNullable(post.getFullText())
                .ifPresent(persistent::setFullText);
        Optional.ofNullable(post.getComments())
                .ifPresent(persistent::setComments);
        postRepository.save(persistent);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.delete(id);
    }
}
