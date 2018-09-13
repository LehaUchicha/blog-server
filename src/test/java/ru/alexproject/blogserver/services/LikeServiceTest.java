package ru.alexproject.blogserver.services;

import org.junit.Assert;
import org.junit.Test;
import ru.alexproject.blogserver.BaseTest;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.model.dto.PostDto;

public class LikeServiceTest extends BaseTest {

    //TODO: Needs to create Entities with custom id for independend tests creation
    public void testIncreaseAlredyExistLikeToPost() {
        User user = userService.findUserById(1l).toEntity();
        PostDto post = postService.getPostById(0l);
        int likesCount = likeService.getLikesByPostId(post.getId()).size();
        likeService.increasePostLikeCount(user.toDto(), post);
        Assert.assertEquals(likesCount, likeService.getLikesByPostId(post.getId()).size());
    }

    @Test
    public void testIncreaseLikeToExistingComment() {
        User user = userService.findUserById(1l).toEntity();
        CommentDto comment = commentService.getCommentById(0l);
        int likesCount = likeService.getLikesByCommentId(comment.getId()).size();
        likeService.increaseCommentLikeCount(user.toDto(), comment);
        Assert.assertEquals(likesCount + 1, likeService.getLikesByCommentId(comment.getId()).size());
    }

    @Test
    public void testDecreaseLikeToExistingPost() {
        User user = userService.findUserById(1l).toEntity();
        PostDto post = postService.getPostById(0l);
        int likesCount = likeService.getLikesByPostId(post.getId()).size();
        likeService.decreasePostLikeCount(user.toDto(), post);
        int decreasedLikesCount = likeService.getLikesByPostId(post.getId()).size();
        Assert.assertEquals(likesCount - 1, likeService.getLikesByPostId(post.getId()).size());
    }

    @Test
    public void testDecreaseLikeToExistingComment() {
        User user = userService.findUserById(1l).toEntity();
        CommentDto comment = commentService.getCommentById(0l);
        int likesCount = likeService.getLikesByCommentId(comment.getId()).size();
        likeService.decreaseCommentLikeCount(user.toDto(), comment);
        Assert.assertEquals(likesCount - 1, likeService.getLikesByCommentId(comment.getId()).size());
    }
}
