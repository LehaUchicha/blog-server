package ru.alexproject.blogserver;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.alexproject.blogserver.model.dto.PostDto;
import ru.alexproject.blogserver.services.CommentService;
import ru.alexproject.blogserver.services.LikeService;
import ru.alexproject.blogserver.services.PostService;
import ru.alexproject.blogserver.services.UserService;

import java.util.UUID;

@TestPropertySource(locations = "classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public abstract class BaseTest {

    @Autowired
    protected PostService postService;

    @Autowired
    protected LikeService likeService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected CommentService commentService;

    protected PostDto createBasePostDto() {
        return PostDto.build()
                .withFullText("Base Full Text")
                .withShortText("Base short Text")
                .withTitle("Base Title")
                .please();
    }

    protected Long newId() {
        return UUID.randomUUID().getMostSignificantBits();
    }
}
