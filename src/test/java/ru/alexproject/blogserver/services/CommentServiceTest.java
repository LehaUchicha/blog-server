package ru.alexproject.blogserver.services;

import org.junit.Assert;
import org.junit.Test;
import ru.alexproject.blogserver.BaseTest;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.model.dto.PostDto;

public class CommentServiceTest extends BaseTest {

    @Test
    public void testCreateComment() {
        CommentDto commentDto = createBaseCommentDto();
        PostDto postDto = createBasePostDto();
        postService.save(postDto);
        commentDto.setPost(postDto.toEntity());
        commentService.save(commentDto);
        Assert.assertNotNull(commentService.getCommentById(commentDto.getId()));
    }

    @Test
    public void testUpdateComment(){
        String newComment = "newComment";
        CommentDto commentDto = createBaseCommentDto();
        PostDto postDto = createBasePostDto();
        postService.save(postDto);
        commentDto.setPost(postDto.toEntity());
        commentService.save(commentDto);
        Assert.assertNotNull(commentService.getCommentById(commentDto.getId()));

        CommentDto persistenceDto = commentService.getCommentById(commentDto.getId());
        persistenceDto.setText(newComment);
        commentService.updateComment(persistenceDto.getId(), persistenceDto);
        Assert.assertEquals(newComment, commentService.getCommentById(persistenceDto.getId()).getText());
    }
}
