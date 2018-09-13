package ru.alexproject.blogserver;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.alexproject.blogserver.model.dto.*;
import ru.alexproject.blogserver.services.*;

import static ru.alexproject.blogserver.model.EntityUtils.newId;

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

    @Autowired
    protected DialogService dialogService;

    protected PostDto createBasePostDto() {
        return PostDto.build()
                .withId(newId())
                .withFullText("Base Full Text")
                .withShortText("Base short Text")
                .withTitle("Base Title")
                .please();
    }

    protected UserDto createBaseUserDto() {
        return UserDto.build()
                .withId(newId())
                .withUsername("Alex")
                .withFirstName("Alex")
                .withLastName("Lex")
                .withPassword("pass")
                .please();
    }

    protected CommentDto createBaseCommentDto() {
        return CommentDto.build()
                .withId(newId())
                .withText("Comment")
                .please();
    }

    protected DialogDto createBaseDialog() {
        return DialogDto.build()
                .withId(newId())
                .withName("Best Dialog")
                .please();
    }

    protected UserDialogDto createBaseUserDialogDto() {
        return UserDialogDto.build()
                .withId(newId())
                .withText("hello")
                .please();
    }
}
