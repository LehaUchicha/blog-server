package ru.alexproject.blogserver;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.alexproject.blogserver.model.Post;
import ru.alexproject.blogserver.services.PostService;

import java.util.Collections;
import java.util.UUID;

@TestPropertySource(locations = "classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public abstract class BaseTest {

    @Autowired
    protected PostService postService;

    protected Post createBasePost() {
        Post post = new Post();
        post.setShortText("Base short Text");
        post.setFullText("Base Full Text");
        post.setTitle("Base Title");
        post.setComments(Collections.emptyList());
        return post;
    }

    protected Long newId(){
        return UUID.randomUUID().getMostSignificantBits();
    }
}
