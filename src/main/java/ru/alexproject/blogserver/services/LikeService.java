package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.domain.Like;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.model.dto.LikeDto;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.model.dto.UserDto;

import java.util.List;
import java.util.Set;

public interface LikeService {

    List<Like> getAll();

    Set<Like> getLikesOnComment();

    Set<Like> getLikesByCommentId(Long id);

    Set<Like> getLikesOnPosts();

    Set<Like> getLikesByPostId(Long id);

    void increasePostLikeCount(User user, Post post);

    void decreasePostLikeCount(User user, Post post);

    void increaseCommentLikeCount(User user, Comment comment);

    void decreaseCommentLikeCount(User user, Comment comment);
}
