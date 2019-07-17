package ru.alexproject.blogserver.services;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.alexproject.blogserver.BaseTest;
import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.model.dto.UserDto;

@Ignore
public class LikeServiceTest extends BaseTest {

    @Test
    public void testIncreaseAlredyExistLikeToPost() {
        UserDto userDto = createBaseUserDto();
        userService.save(modelMapper.convert(userDto, User.class));

        PostDto postDto = createBasePostDto();
        postService.save(modelMapper.convert(postDto, Post.class));

        int likesCount = likeService.getLikesByPostId(postDto.getId()).size();
        Assert.assertEquals(0, likesCount);
        likeService.increasePostLikeCount(modelMapper.convert(userDto, User.class), modelMapper.convert(postDto, Post.class));
        Assert.assertEquals(likesCount + 1, likeService.getLikesByPostId(postDto.getId()).size());
    }

    @Test
    public void testIncreaseLikeToExistingComment() {
        UserDto userDto = createBaseUserDto();
        userService.save(modelMapper.convert(userDto, User.class));

        PostDto postDto = createBasePostDto();
        postService.save(modelMapper.convert(postDto, Post.class));

        CommentDto commentDto = createBaseCommentDto();
        commentDto.setAuthor(userDto);
        commentDto.setPost(postDto);
        commentService.save(modelMapper.convert(commentDto, Comment.class));

        int likesCount = likeService.getLikesByCommentId(commentDto.getId()).size();
        Assert.assertEquals(0, likesCount);
        likeService.increaseCommentLikeCount(modelMapper.convert(userDto, User.class), modelMapper.convert(commentDto, Comment.class));
        Assert.assertEquals(likesCount + 1, likeService.getLikesByCommentId(commentDto.getId()).size());
    }

    @Test
    public void testDecreaseLikeToExistingPost() {
        UserDto userDto = createBaseUserDto();
        userService.save(modelMapper.convert(userDto, User.class));

        PostDto postDto = createBasePostDto();
        postService.save(modelMapper.convert(postDto, Post.class));

        int likesCount = likeService.getLikesByPostId(postDto.getId()).size();
        Assert.assertEquals(0, likesCount);
        likeService.increasePostLikeCount(modelMapper.convert(userDto, User.class), modelMapper.convert(postDto, Post.class));
        likesCount++;
        Assert.assertEquals(likesCount, likeService.getLikesByPostId(postDto.getId()).size());

        likeService.decreasePostLikeCount(modelMapper.convert(userDto, User.class), modelMapper.convert(postDto, Post.class));
        likesCount--;
        Assert.assertEquals(likesCount, likeService.getLikesByPostId(postDto.getId()).size());
    }

    @Test
    public void testDecreaseLikeToExistingComment() {
        UserDto userDto = createBaseUserDto();
        userService.save(modelMapper.convert(userDto, User.class));

        PostDto postDto = createBasePostDto();
        postService.save(modelMapper.convert(postDto, Post.class));

        CommentDto commentDto = createBaseCommentDto();
        commentDto.setAuthor(userDto);
        commentDto.setPost(postDto);
        commentService.save(modelMapper.convert(commentDto, Comment.class));

        int likesCount = likeService.getLikesByCommentId(commentDto.getId()).size();
        Assert.assertEquals(0, likesCount);
        likeService.increaseCommentLikeCount(modelMapper.convert(userDto, User.class), modelMapper.convert(commentDto, Comment.class));
        likesCount++;
        Assert.assertEquals(likesCount, likeService.getLikesByCommentId(commentDto.getId()).size());
        likeService.decreaseCommentLikeCount(modelMapper.convert(userDto, User.class), modelMapper.convert(commentDto, Comment.class));
        likesCount--;
        Assert.assertEquals(likesCount, likeService.getLikesByCommentId(commentDto.getId()).size());
    }
}
