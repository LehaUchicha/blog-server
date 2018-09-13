package ru.alexproject.blogserver.services;

import org.junit.Assert;
import org.junit.Test;
import ru.alexproject.blogserver.BaseTest;
import ru.alexproject.blogserver.model.dto.PostDto;

public class PostServiceTest extends BaseTest {

    @Test
    public void createPost() {
        PostDto post = createBasePostDto();
        postService.save(post);
        Assert.assertNotNull(postService.getPostById(post.getId()));
    }

    @Test
    public void updatePost() {
        String newTitle = "Updated Title";
        PostDto postDto = createBasePostDto();
        postService.save(postDto);
        PostDto persistentPostDto = postService.getPostById(postDto.getId());
        persistentPostDto.setTitle(newTitle);
        postService.updatePost(persistentPostDto.getId(), persistentPostDto);
        Assert.assertEquals(newTitle, postService.getPostById(persistentPostDto.getId()).getTitle());
    }
}
