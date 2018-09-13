package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.dto.LikeDto;
import ru.alexproject.blogserver.services.LikeService;

import java.util.List;
import java.util.Set;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Likes.*;

@RestController
@RequestMapping(API_LIKES)
@CrossOrigin
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping
    public List<LikeDto> getAll() {
        return likeService.getAll();
    }

    @GetMapping(value = FOR_COMMENTS)
    public Set<LikeDto> getLikesOnComment() {
        return likeService.getLikesOnComment();
    }

    @GetMapping(value = BY_COMMENT_ID)
    public Set<LikeDto> getLikesByCommentId(@PathVariable("id") Long id) {
        return likeService.getLikesByCommentId(id);
    }

    @GetMapping(value = FOR_POSTS)
    public Set<LikeDto> getLikesOnPosts() {
        return likeService.getLikesOnPosts();
    }

    @GetMapping(value = BY_POST_ID)
    public Set<LikeDto> getLikesByPostId(@PathVariable("id") Long id) {
        return likeService.getLikesByPostId(id);
    }

    @PostMapping(value = "/increase")
    public void increasePostLikeCount(@RequestBody User user, @RequestBody Post post) {
        likeService.increasePostLikeCount(user.toDto(), post.toDto());
    }

    @PostMapping(value = "/decrease")
    public void decreasePostLikeCount(@RequestBody User user, @RequestBody Post post) {
        likeService.decreasePostLikeCount(user.toDto(), post.toDto());
    }
}
