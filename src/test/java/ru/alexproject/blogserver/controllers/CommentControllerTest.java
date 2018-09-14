package ru.alexproject.blogserver.controllers;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
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
//        String expected = "[{\"id\":0,\"title\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"shortText\":\"Curret tecknologies are developed very fast. It difficult to controll all technologies\",\"fullText\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"comments\":[{\"id\":0,\"text\":\"good post, thanks\"},{\"id\":1,\"text\":\"отстой, братан, ну серьезно\"},{\"id\":2,\"text\":\"пойдет\"}]}]";
//
//        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testGetCommentById() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/comments/1"),
                HttpMethod.GET, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
//        String expected = "[{\"id\":0,\"title\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"shortText\":\"Curret tecknologies are developed very fast. It difficult to controll all technologies\",\"fullText\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"comments\":[{\"id\":0,\"text\":\"good post, thanks\"},{\"id\":1,\"text\":\"отстой, братан, ну серьезно\"},{\"id\":2,\"text\":\"пойдет\"}]}]";
//
//        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCreateUser() {
        CommentDto user = createBaseCommentDto();

        HttpEntity<CommentDto> entity = new HttpEntity<>(user, headers);

        ResponseEntity<String> postResponse = restTemplate.exchange(
                createURLWithPort("/api/comments/"),
                HttpMethod.POST, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        Assert.assertNotNull(commentService.getCommentById(user.getId()));
    }
}
