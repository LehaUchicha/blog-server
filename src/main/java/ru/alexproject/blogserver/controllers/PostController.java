package ru.alexproject.blogserver.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.Comment;
import ru.alexproject.blogserver.model.Post;
import ru.alexproject.blogserver.repositories.CommentRepository;
import ru.alexproject.blogserver.services.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Posts.API_POSTS;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Posts.POST_ID;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Posts.POST_ID_COMMENTS;

/**
 * Created by Alex on 21.03.2018.
 */
@Slf4j
@RestController
@RequestMapping(API_POSTS)
@CrossOrigin
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(value = POST_ID)
    public Post getPostById(@PathVariable("id") Long id){
        return postService.getPostById(id);
    }

    @GetMapping
    public List<Post> getPosts(){
        List<Post> posts = new ArrayList<>();
        postService.getPosts().forEach(p -> posts.add(p));
        return posts;
    }

    @PostMapping
    public void createPost(@RequestBody Post post){
        System.out.println("created post: {}" + post);
        //postService.saveAndFlush(post);
        postService.createPost(post);
    }

    @PutMapping(value = POST_ID)
    public void updatePost(@PathVariable("id") Long id, @RequestBody Post post){
        Post p = postService.getPostById(id);
        p.setTitle(post.getTitle());
        p.setShortText(post.getShortText());
        p.setFullText(post.getFullText());
        postService.save(p);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + p);
    }

    @DeleteMapping(value = POST_ID)
    public void deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
    }

    @GetMapping(value = POST_ID_COMMENTS)
    public List<Comment> getCommentsByPostId(@PathVariable("id") Long id){
        return commentRepository.findAll().stream().filter(comment -> id.equals(comment.getPost().getId())).collect(Collectors.toList());
    }
}
