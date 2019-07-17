package ru.alexproject.blogserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexproject.blogserver.model.domain.Comment;
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
    @Transactional
    public List<Comment> getComments() {
        List<Comment> comments = new ArrayList<>();
        repository.findAll().forEach(comment -> comments.add(comment));
        return comments;
    }

    @Override
    public Comment getCommentById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void updateComment(Long id, Comment newComment) {
        Comment oldComment = repository.findOne(id);
        Optional.ofNullable(newComment.getId())
                .ifPresent(oldComment::setId);
        Optional.ofNullable(newComment.getAuthor())
                .ifPresent(oldComment::setAuthor);
        Optional.ofNullable(newComment.getPost())
                .ifPresent(oldComment::setPost);
        Optional.ofNullable(newComment.getText())
                .ifPresent(oldComment::setText);
        repository.save(newComment);
    }

    @Override
    public void deleteComment(Long id) {
        repository.delete(id);
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return repository.getCommentsByPostId(postId);
    }
}
