package ru.alexproject.blogserver.controllers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.Post;
import ru.alexproject.blogserver.repositories.PostRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 21.03.2018.
 */
@Slf4j
@RestController
@RequestMapping("/api/posts")
@CrossOrigin
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Post getPostById(@PathVariable("id") Long id){
        return postRepository.findById(id).get();
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("id") Long id){
        postRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post){
        postRepository.save(post);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + post);
    }

}
