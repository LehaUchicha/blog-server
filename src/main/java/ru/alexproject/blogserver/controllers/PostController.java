package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.repositories.CommentRepository;
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

    @Autowired
    private PostService postService;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(value = POST_ID)
    public PostDto getPostById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getPosts();
    }

    @PostMapping
    public void createPost(@RequestBody PostDto post) {
        postService.save(post);
    }

    @PutMapping(value = POST_ID)
    public void updatePost(@PathVariable("id") Long id, @RequestBody PostDto post) {
        postService.updatePost(id, post);
    }

    @DeleteMapping(value = POST_ID)
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }

    @GetMapping(value = POST_ID_COMMENTS)
    public List<Comment> getCommentsByPostId(@PathVariable("id") Long id) {
        return commentRepository.findAll().stream().filter(comment -> id.equals(comment.getPost().getId())).collect(Collectors.toList());
    }
}
