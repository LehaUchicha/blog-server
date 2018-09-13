package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getComments();

    CommentDto getCommentById(Long id);

    void save(CommentDto comment);

    void updateComment(Long id, CommentDto requestComment);

    void deleteComment(Long id);

    List<CommentDto> getCommentsByPostId(Long id);
}
