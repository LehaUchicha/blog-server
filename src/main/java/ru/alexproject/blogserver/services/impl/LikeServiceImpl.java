package ru.alexproject.blogserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.domain.Like;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.repositories.LikeRepository;
import ru.alexproject.blogserver.services.LikeService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository repository;

    @Override
    @Transactional
    public List<Like> getAll() {
        return repository.findAll();
    }

    @Override
    public Set<Like> getLikesOnComment() {
        return repository.getLikesOnComment();
    }

    @Override
    public Set<Like> getLikesByCommentId(Long id) {
        return repository.getLikesByCommentId(id);
    }

    @Override
    public Set<Like> getLikesOnPosts() {
        return repository.getLikesOnPosts();
    }

    @Override
    public Set<Like> getLikesByPostId(Long id) {
        return repository.getLikesByPostId(id);
    }

    @Override
    public void increasePostLikeCount(User user, Post post) {
        repository.save(Like.builder()
                .user(user)
                .post(post)
                .build());
    }

    @Override
    public void decreasePostLikeCount(User user, Post post) {
        Optional.ofNullable(repository.findLikesByUserAndPost(post, user))
                .ifPresent(repository::delete);
    }

    @Override
    public void increaseCommentLikeCount(User user, Comment comment) {
        repository.save(Like.builder()
                .user(user)
                .comment(comment)
                .build());
    }

    @Override
    public void decreaseCommentLikeCount(User user, Comment comment) {
        Optional.ofNullable(repository.findLikesByUserAndComment(comment, user))
                .ifPresent(repository::delete);
    }
}