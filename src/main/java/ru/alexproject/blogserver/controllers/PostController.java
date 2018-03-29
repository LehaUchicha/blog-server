package ru.alexproject.blogserver.controllers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.Comment;
import ru.alexproject.blogserver.model.Post;
import ru.alexproject.blogserver.repositories.CommentRepository;
import ru.alexproject.blogserver.repositories.PostRepository;

import java.util.ArrayList;
import java.util.Arrays;
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
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(value = POST_ID, method = RequestMethod.GET)
    public Post getPostById(@PathVariable("id") Long id){
        return postRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createPost(@RequestBody Post post){
        System.out.println("created post: {}" + post);
        postRepository.saveAndFlush(post);
        //postRepository.save(post);
    }

    @RequestMapping(value = POST_ID, method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("id") Long id){
        postRepository.delete(id);
    }

    @RequestMapping(value = POST_ID, method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post){
        postRepository.save(post);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + post);
    }

    @RequestMapping(value = POST_ID_COMMENTS, method = RequestMethod.GET)
    public List<Comment> getCommentsByPostId(@PathVariable("id") Long id){
        return commentRepository.findAll().stream().filter(comment -> id.equals(comment.getPost().getId())).collect(Collectors.toList());
    }

//    @RequestMapping(value = "post/{id}", method = RequestMethod.GET)
//    public Post increaseLikeCount(@PathVariable("id") Long id){
//        return postRepository.findById(id).get();
//    }



}
