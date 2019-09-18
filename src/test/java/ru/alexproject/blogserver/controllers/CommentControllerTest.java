package ru.alexproject.blogserver.controllers;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.alexproject.blogserver.BaseIntegrationTest;
import ru.alexproject.blogserver.model.dto.CommentDto;

public class CommentControllerTest extends BaseIntegrationTest {

    @Test
    public void testGetAllComments() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/comments/"),
                HttpMethod.GET, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        String expected = "[" +
                "{" +
                    "\"id\":0," +
                    "\"text\":\"good post, thanks\"," +
                    "\"author\":{\"id\":1," +
                    "\"username\":\"a.a\"," +
                    "\"firstName\":\"a\"," +
                    "\"lastName\":\"a\"}," +
                    "\"post\":{\"id\":0," +
                    "\"title\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\"," +
                    "\"shortText\":\"Curret tecknologies are developed very fast. It difficult to controll all technologies\"," +
                    "\"fullText\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\"}" +
                "}," +
                "{" +
                    "\"id\":1," +
                    "\"text\":\"отстой, братан, ну серьезно\"," +
                    "\"author\":{\"id\":2,\"username\":\"b.b\"," +
                    "\"firstName\":\"b\",\"lastName\":\"b\"}," +
                    "\"post\":{\"id\":0," +
                    "\"title\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\"," +
                    "\"shortText\":\"Curret tecknologies are developed very fast. It difficult to controll all technologies\"," +
                    "\"fullText\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\"}" +
                "}," +
                "{" +
                    "\"id\":2," +
                    "\"text\":\"пойдет\"," +
                    "\"author\":{\"id\":1," +
                    "\"username\":\"a.a\"," +
                    "\"firstName\":\"a\"," +
                    "\"lastName\":\"a\"}," +
                    "\"post\":{\"id\":0," +
                    "\"title\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\"," +
                    "\"shortText\":\"Curret tecknologies are developed very fast. It difficult to controll all technologies\"," +
                    "\"fullText\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\"" +
                "}}]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testGetCommentById() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/comments/0"),
                HttpMethod.GET, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        String expected = "{\"id\":0,\"text\":\"good post, thanks\",\"author\":{\"id\":1,\"username\":\"a.a\",\"firstName\":\"a\",\"lastName\":\"a\"},\"post\":{\"id\":0,\"title\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"shortText\":\"Curret tecknologies are developed very fast. It difficult to controll all technologies\",\"fullText\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\"}}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCreateComment() {
        CommentDto commentDto = createBaseCommentDto();

        HttpEntity<CommentDto> entity = new HttpEntity<>(commentDto, headers);

        ResponseEntity<String> postResponse = restTemplate.exchange(
                createURLWithPort("/api/comments/"),
                HttpMethod.POST, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        Assert.assertNotNull(commentService.getCommentById(commentDto.getId()));
        commentService.deleteComment(commentDto.getId());
    }
}