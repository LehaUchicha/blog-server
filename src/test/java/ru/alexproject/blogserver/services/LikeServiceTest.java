package ru.alexproject.blogserver.services;

import org.junit.Assert;
import org.junit.Test;
import ru.alexproject.blogserver.BaseTest;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.model.dto.UserDto;

public class LikeServiceTest extends BaseTest {

    @Test
    public void testIncreaseAlredyExistLikeToPost() {
        UserDto userDto = createBaseUserDto();
        userService.save(userDto);

        PostDto post = createBasePostDto();
        postService.save(post);

        int likesCount = likeService.getLikesByPostId(post.getId()).size();
        Assert.assertEquals(0, likesCount);
        likeService.increasePostLikeCount(userDto, post);
        Assert.assertEquals(likesCount + 1, likeService.getLikesByPostId(post.getId()).size());
    }

    @Test
    public void testIncreaseLikeToExistingComment() {
        UserDto userDto = createBaseUserDto();
        userService.save(userDto);

        PostDto postDto = createBasePostDto();
        postService.save(postDto);

        CommentDto commentDto = createBaseCommentDto();
        commentDto.setAuthor(userDto.toEntity());
        commentDto.setPost(postDto.toEntity());
        commentService.save(commentDto);

        int likesCount = likeService.getLikesByCommentId(commentDto.getId()).size();
        Assert.assertEquals(0, likesCount);
        likeService.increaseCommentLikeCount(userDto, commentDto);
        Assert.assertEquals(likesCount + 1, likeService.getLikesByCommentId(commentDto.getId()).size());
    }

    @Test
    public void testDecreaseLikeToExistingPost() {
        UserDto userDto = createBaseUserDto();
        userService.save(userDto);

        PostDto postDto = createBasePostDto();
        postService.save(postDto);

        int likesCount = likeService.getLikesByPostId(postDto.getId()).size();
        Assert.assertEquals(0, likesCount);
        likeService.increasePostLikeCount(userDto, postDto);
        likesCount++;
        Assert.assertEquals(likesCount, likeService.getLikesByPostId(postDto.getId()).size());

        likeService.decreasePostLikeCount(userDto, postDto);
        likesCount--;
        Assert.assertEquals(likesCount, likeService.getLikesByPostId(postDto.getId()).size());
    }

    @Test
    public void testDecreaseLikeToExistingComment() {
        UserDto userDto = createBaseUserDto();
        userService.save(userDto);

        PostDto postDto = createBasePostDto();
        postService.save(postDto);

        CommentDto commentDto = createBaseCommentDto();
        commentDto.setAuthor(userDto.toEntity());
        commentDto.setPost(postDto.toEntity());
        commentService.save(commentDto);

        int likesCount = likeService.getLikesByCommentId(commentDto.getId()).size();
        Assert.assertEquals(0, likesCount);
        likeService.increaseCommentLikeCount(userDto, commentDto);
        likesCount++;
        Assert.assertEquals(likesCount, likeService.getLikesByCommentId(commentDto.getId()).size());
        likeService.decreaseCommentLikeCount(userDto, commentDto);
        likesCount--;
        Assert.assertEquals(likesCount, likeService.getLikesByCommentId(commentDto.getId()).size());
    }
}
