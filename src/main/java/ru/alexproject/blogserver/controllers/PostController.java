package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.mapper.Mapper;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.services.CommentService;
import ru.alexproject.blogserver.services.PostService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Posts.*;

/**
 * Created by Alex on 21.03.2018.
 */
@RestController
@RequestMapping(API_POSTS)
@CrossOrigin
public class PostController {

    private PostService postService;

    private CommentService commentService;

    private Mapper modelMapper;

    @Autowired
    public PostController(PostService postService, CommentService commentService, Mapper modelMapper) {
        this.postService = postService;
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = POST_ID)
    public PostDto getPostById(@PathVariable("id") Long id) {
        return modelMapper.convert(postService.getPostById(id), PostDto.class);
    }

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getPosts().stream()
                .map(post -> modelMapper.convert(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public void createPost(@RequestBody PostDto post) {
        postService.save(modelMapper.convert(post, Post.class));
    }

    @PutMapping(value = POST_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    @ResponseBody
    public void updatePost(@PathVariable("id") Long id, @RequestBody PostDto post) {
        postService.updatePost(id, modelMapper.convert(post, Post.class));
    }

    @DeleteMapping(value = POST_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }

    @GetMapping(value = POST_ID_COMMENTS, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentDto> getCommentsByPostId(@PathVariable("id") Long id) {
        return postService.getPostById(id).getComments().stream()
                .map(comment -> modelMapper.convert(comment, CommentDto.class))
                .collect(Collectors.toList());
    }
}
