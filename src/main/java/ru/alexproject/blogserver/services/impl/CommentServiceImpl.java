package ru.alexproject.blogserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.repositories.CommentRepository;
import ru.alexproject.blogserver.services.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Override
    public List<CommentDto> getComments() {
        List<CommentDto> comments = new ArrayList<>();
        repository.findAll().forEach(comment -> comments.add(comment.toDto()));
        return comments;
    }

    @Override
    public CommentDto getCommentById(Long id) {
        return repository.findOne(id).toDto();
    }

    @Override
    public void save(CommentDto comment) {
        repository.save(comment.toEntity());
    }

    @Override
    public void updateComment(Long id, CommentDto commentDto) {
        Comment comment = repository.findOne(id);
        Optional.ofNullable(commentDto.getId())
                .ifPresent(comment::setId);
        Optional.ofNullable(commentDto.getAuthor())
                .ifPresent(comment::setAuthor);
        Optional.ofNullable(commentDto.getPost())
                .ifPresent(comment::setPost);
        Optional.ofNullable(commentDto.getText())
                .ifPresent(comment::setText);
        repository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        repository.delete(id);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long postId) {
        return repository.getCommentsByPostId(postId);
    }
}
