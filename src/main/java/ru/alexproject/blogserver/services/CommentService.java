package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComments();

    Comment getCommentById(Long id);

    void save(Comment comment);

    void updateComment(Long id, Comment requestComment);

    void deleteComment(Long id);

    List<Comment> getCommentsByPostId(Long id);
}
