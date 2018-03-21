package ru.alexproject.blogserver.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexproject.blogserver.model.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 21.03.2018.
 */

@RestController
@RequestMapping("/api")
public class PostController {

   // private List<Post> posts = new ArrayList<>({});


    @RequestMapping("/posts")
    public List<Post> getPosts(){
        return Arrays.asList(new Post(1l, "title 1", "asdfasdfasdf"), new Post(2l, "title 2", "asdfffffffffffffffffffff"), new Post(3l, "title 3", "ttteeeexxxtttt"));
    }
}
