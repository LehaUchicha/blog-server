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
@RequestMapping("/api")
@CrossOrigin
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void createPost(@RequestBody Post post){
        log.debug("created post: {}", post);
        postRepository.saveAndFlush(post);
        //postRepository.save(post);
    }

    @RequestMapping(value = "/post", method = RequestMethod.DELETE)
    public void deletePost(@RequestBody Post post){
        postRepository.delete(post);
    }

}
