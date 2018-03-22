package ru.alexproject.blogserver.controllers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 21.03.2018.
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PostController {

    ArrayList<Post> posts = new ArrayList<Post>(
            Arrays.asList(new Post("1", "title 1", "asdfasdfasdf"),
                    new Post("2", "title 2", "asdfffffffffffffffffffff"),
                    new Post("3", "title 3", "ttteeeexxxtttt")));

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getPosts(){
        return posts;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void createPost(@RequestBody Post post){
        posts.add(post);
    }

    @RequestMapping(value = "/post", method = RequestMethod.DELETE)
    public void deletePost(@RequestBody Post post){
        posts.remove(post);
    }

}
