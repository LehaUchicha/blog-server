package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.mapper.Mapper;
import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.services.CommentService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Comments.API_COMMENTS;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Common.ID;

@RestController
@RequestMapping(API_COMMENTS)
@CrossOrigin
public class CommentController {

    private CommentService commentService;

    private Mapper modelMapper;

    @Autowired
    public CommentController(CommentService commentService, Mapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<CommentDto> getComments() {
        return commentService.getComments().stream()
                .map(comment -> modelMapper.convert(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = ID)
    public CommentDto getCommentById(@PathVariable("id") Long id) {
        return modelMapper.convert(commentService.getCommentById(id), CommentDto.class);
    }

    @PostMapping
    public void createComment(@RequestBody CommentDto comment) {
        commentService.save(modelMapper.convert(comment, Comment.class));
    }

    @PutMapping(value = ID)
    public void updateComment(@PathVariable("id") Long id, @RequestBody CommentDto commentDto) {
        commentService.updateComment(id, modelMapper.convert(commentDto, Comment.class));
    }

    @DeleteMapping(value = ID)
    public void deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
    }

    public List<CommentDto> getCommentsByPostId(Long id) {
        return commentService.getComments().stream()
                .map(comment -> modelMapper.convert(comment, CommentDto.class))
                .collect(Collectors.toList());
    }
}
