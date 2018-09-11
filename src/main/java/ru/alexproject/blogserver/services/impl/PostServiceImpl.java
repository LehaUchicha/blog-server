package ru.alexproject.blogserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.Comment;
import ru.alexproject.blogserver.model.Post;
import ru.alexproject.blogserver.repositories.CommentRepository;
import ru.alexproject.blogserver.repositories.PostRepository;
import ru.alexproject.blogserver.services.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Posts.POST_ID;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Posts.POST_ID_COMMENTS;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    public Post getPostById(Long id){
        return postRepository.findOne(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    public List<Post> getPosts(){
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(p -> posts.add(p));
        return posts;
    }

    @Override
    public void createPost(Post post){
        System.out.println("created post: {}" + post);
        //postRepository.saveAndFlush(post);
        postRepository.save(post);
    }

    @Override
    public void updatePost(Long id, Post post){
        Post p = postRepository.findOne(id);
        p.setTitle(post.getTitle());
        p.setShortText(post.getShortText());
        p.setFullText(post.getFullText());
        postRepository.save(p);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + p);
    }

    @Override
    public void deletePost(Long id){
        postRepository.delete(id);
    }


}
