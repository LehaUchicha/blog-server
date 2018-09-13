package ru.alexproject.blogserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexproject.blogserver.model.domain.Like;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.model.dto.LikeDto;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.model.dto.UserDto;
import ru.alexproject.blogserver.repositories.LikeRepository;
import ru.alexproject.blogserver.services.LikeService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository repository;

    @Override
    public List<LikeDto> getAll() {
        return repository.findAll().stream()
                .map(like -> like.toDto())
                .collect(Collectors.toList());
    }

    @Override
    public Set<LikeDto> getLikesOnComment() {
        return repository.getLikesOnComment().stream()
                .map(like -> like.toDto())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<LikeDto> getLikesByCommentId(Long id) {
        return repository.getLikesByCommentId(id).stream()
                .map(like -> like.toDto())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<LikeDto> getLikesOnPosts() {
        return repository.getLikesOnPosts().stream()
                .map(Like::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<LikeDto> getLikesByPostId(Long id) {
        return repository.getLikesByPostId(id).stream()
                .map(like -> like.toDto())
                .collect(Collectors.toSet());
    }

    @Override
    public void increasePostLikeCount(UserDto user, PostDto post) {
        if (repository.findLikesByUserAndPost(post.toEntity(), user.toEntity()) == null) {
            repository.save(
                    LikeDto.build()
                            .setUser(user.toEntity())
                            .setPost(post.toEntity())
                            .please()
                            .toEntity());
        }
    }

    @Override
    public void decreasePostLikeCount(UserDto user, PostDto post) {
        Optional.ofNullable(repository.findLikesByUserAndPost(post.toEntity(), user.toEntity()))
                .ifPresent(repository::delete);
    }

    @Override
    public void increaseCommentLikeCount(UserDto user, CommentDto commentDto) {
        if (repository.findLikesByUserAndComment(commentDto.toEntity(), user.toEntity()) == null) {
            repository.save(
                    LikeDto.build()
                            .setUser(user.toEntity())
                            .setComment(commentDto.toEntity())
                            .please()
                            .toEntity());
        }
    }

    @Override
    public void decreaseCommentLikeCount(UserDto user, CommentDto commentDto) {
        Optional.ofNullable(repository.findLikesByUserAndComment(commentDto.toEntity(), user.toEntity()))
                .ifPresent(repository::delete);
    }
}


