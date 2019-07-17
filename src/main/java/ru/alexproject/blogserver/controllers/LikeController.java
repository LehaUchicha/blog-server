package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.mapper.Mapper;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.dto.LikeDto;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.model.dto.UserDto;
import ru.alexproject.blogserver.services.LikeService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Likes.*;

@RestController
@RequestMapping(API_LIKES)
@CrossOrigin
public class LikeController {

    private LikeService likeService;

    private Mapper modelMapper;

    @Autowired
    public LikeController(LikeService likeService, Mapper modelMapper) {
        this.likeService = likeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<LikeDto> getAll() {
        return likeService.getAll().stream()
                .map(like -> modelMapper.convert(like, LikeDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = FOR_COMMENTS)
    public Set<LikeDto> getLikesOnComment() {
        return likeService.getLikesOnComment().stream()
                .map(like -> modelMapper.convert(like, LikeDto.class))
                .collect(Collectors.toSet());
    }

    @GetMapping(value = BY_COMMENT_ID)
    public Set<LikeDto> getLikesByCommentId(@PathVariable("id") Long id) {
        return likeService.getLikesByCommentId(id).stream()
                .map(like -> modelMapper.convert(like, LikeDto.class))
                .collect(Collectors.toSet());
    }

    @GetMapping(value = FOR_POSTS)
    public Set<LikeDto> getLikesOnPosts() {
        return likeService.getLikesOnPosts().stream()
                .map(like -> modelMapper.convert(like, LikeDto.class))
                .collect(Collectors.toSet());
    }

    @GetMapping(value = BY_POST_ID)
    public Set<LikeDto> getLikesByPostId(@PathVariable("id") Long id) {
        return likeService.getLikesByPostId(id).stream()
                .map(like -> modelMapper.convert(like, LikeDto.class))
                .collect(Collectors.toSet());
    }

    @PostMapping(value = "/increase")
    public void increasePostLikeCount(@RequestBody UserDto user, @RequestBody PostDto post) {
        likeService.increasePostLikeCount(modelMapper.convert(user, User.class), modelMapper.convert(post, Post.class));
    }

    @PostMapping(value = "/decrease")
    public void decreasePostLikeCount(@RequestBody UserDto user, @RequestBody PostDto post) {
        likeService.decreasePostLikeCount(modelMapper.convert(user, User.class), modelMapper.convert(post, Post.class));
    }
}
