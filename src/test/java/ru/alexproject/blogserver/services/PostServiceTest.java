package ru.alexproject.blogserver.services;

import org.junit.Assert;
import org.junit.Test;
import ru.alexproject.blogserver.BaseTest;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.dto.PostDto;

public class PostServiceTest extends BaseTest {

    @Test
    public void createPost() {
        PostDto postDto = createBasePostDto();
        postService.save(modelMapper.convert(postDto, Post.class));
        Assert.assertNotNull(postService.getPostById(postDto.getId()));
    }

    @Test
    public void updatePost() {
        String newTitle = "Updated Title";
        PostDto postDto = createBasePostDto();
        postService.save(modelMapper.convert(postDto, Post.class));
        Post persistentPost = postService.getPostById(postDto.getId());
        persistentPost.setTitle(newTitle);
        postService.updatePost(persistentPost.getId(), persistentPost);
        Assert.assertEquals(newTitle, postService.getPostById(persistentPost.getId()).getTitle());
    }
}
