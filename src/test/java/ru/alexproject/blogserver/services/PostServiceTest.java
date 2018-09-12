package ru.alexproject.blogserver.services;

import org.junit.Assert;
import org.junit.Test;
import ru.alexproject.blogserver.BaseTest;
import ru.alexproject.blogserver.model.Post;

public class PostServiceTest extends BaseTest {

    @Test
    public void createPost() {
        Post post = createBasePost();
        int postCount = postService.getPosts().size();
        postService.save(post);
        Assert.assertEquals(postCount + 1, postService.getPosts().size());
    }

    @Test
    public void updatePost() {
        String newTitleValue = "New Title value";
        Post post = postService.getPostById(0l);
        Assert.assertNotEquals(newTitleValue, post.getTitle());
        post.setTitle(newTitleValue);
        postService.updatePost(0l, post);
        Assert.assertEquals(newTitleValue, postService.getPostById(0l).getTitle());
    }
}
