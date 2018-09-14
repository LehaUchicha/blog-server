package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.services.CommentService;
import ru.alexproject.blogserver.services.PostService;

import java.util.List;

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
    private CommentService commentRepository;

    @GetMapping(value = POST_ID)
    public PostDto getPostById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getPosts();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPost(@RequestBody PostDto post) {
        postService.save(post);
    }

    @PutMapping(value = POST_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void updatePost(@PathVariable("id") Long id, @RequestBody PostDto post) {
        postService.updatePost(id, post);
    }

    @DeleteMapping(value = POST_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }

    @GetMapping(value = POST_ID_COMMENTS, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentDto> getCommentsByPostId(@PathVariable("id") Long id) {
        return commentRepository.getCommentsByPostId(id);
    }
}
