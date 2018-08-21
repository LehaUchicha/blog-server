package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.Comment;
import ru.alexproject.blogserver.model.Like;
import ru.alexproject.blogserver.model.Post;
import ru.alexproject.blogserver.model.User;
import ru.alexproject.blogserver.repositories.CommentRepository;
import ru.alexproject.blogserver.repositories.LikeRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Comments.API_COMMENTS;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Common.ID;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Likes.*;

@RestController
@RequestMapping(API_LIKES)
@CrossOrigin
public class LikeController {

    @Autowired
    private LikeRepository likeRepository;

    @GetMapping
    public List<Like> getAll() {
        return likeRepository.findAll();
    }

    @GetMapping(value = FOR_COMMENTS)
    public Set<Like> getLikesOnComment() {
        return likeRepository.findAll().stream()
                .filter(like -> like.getComment() != null)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = BY_COMMENT_ID)
    public Set<Like> getLikesByCommentId(@PathVariable("id") Long id) {
        return likeRepository.findAll().stream()
                .filter(like -> like.getComment() != null)
                .filter(like -> like.getComment().getId().equals(id))
                .collect(Collectors.toSet());
    }

    @GetMapping(value = FOR_POSTS)
    public Set<Like> getLikesOnPosts() {
        return likeRepository.findAll().stream()
                .filter(like -> like.getPost() != null)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = BY_POST_ID)
    public Set<Like> getLikesByPostId(@PathVariable("id") Long id) {
        return likeRepository.findAll().stream()
                .filter(like -> like.getPost() != null)
                .filter(like -> like.getPost().getId().equals(id))
                .collect(Collectors.toSet());
    }

    @PostMapping(value = "/increase")
    public void increasePostLikeCount(@RequestBody User user, @RequestBody Post post) {
        Like like = new Like(user);
        like.setPost(post);
        likeRepository.save(like);
    }

    @PostMapping(value = "/decrease")
    public void decreasePostLikeCount(@RequestBody User user, @RequestBody Post post) {
        likeRepository.findAll().stream()
                .filter(like -> like.getUser().equals(user))
                .filter(like -> like.getPost().equals(post))
                .findFirst()
                .ifPresent(likeRepository::delete);
    }
}
