package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.model.dto.LikeDto;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.model.dto.UserDto;

import java.util.List;
import java.util.Set;

public interface LikeService {

    List<LikeDto> getAll();

    Set<LikeDto> getLikesOnComment();

    Set<LikeDto> getLikesByCommentId(Long id);

    Set<LikeDto> getLikesOnPosts();

    Set<LikeDto> getLikesByPostId(Long id);

    void increasePostLikeCount(UserDto user, PostDto post);

    void decreasePostLikeCount(UserDto user, PostDto post);

    void increaseCommentLikeCount(UserDto user, CommentDto post);

    void decreaseCommentLikeCount(UserDto user, CommentDto post);
}
