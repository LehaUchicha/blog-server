package ru.alexproject.blogserver;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.alexproject.blogserver.mapper.Mapper;
import ru.alexproject.blogserver.model.dto.*;
import ru.alexproject.blogserver.services.*;

import static ru.alexproject.blogserver.utils.EntityUtils.newId;

@TestPropertySource(locations = "classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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

    @Autowired
    protected Mapper modelMapper;

    protected PostDto createBasePostDto() {
        return PostDto.builder()
                .id(newId())
                .fullText("Base Full Text")
                .shortText("Base short Text")
                .title("Base Title")
                .build();
    }

    protected UserDto createBaseUserDto() {
        return UserDto.builder()
                .id(newId())
                .username("Alex")
                .firstName("Alex")
                .lastName("Lex")
                .password("pass")
                .build();
    }

    protected CommentDto createBaseCommentDto() {
        return CommentDto.builder()
                .id(newId())
                .text("Comment")
                .build();
    }

    protected DialogDto createBaseDialog() {
        return DialogDto.builder()
                .id(newId())
                .name("Best Dialog")
                .build();
    }

    protected UserDialogDto createBaseUserDialogDto() {
        return UserDialogDto.builder()
                .id(newId())
                .text("hello")
                .build();
    }
}
