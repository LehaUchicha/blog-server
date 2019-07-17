package ru.alexproject.blogserver.controllers;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.alexproject.blogserver.BaseIntegrationTest;
import ru.alexproject.blogserver.model.dto.PostDto;

public class PostControllerTest extends BaseIntegrationTest {

    @Test
    public void testGetAllPosts() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/posts/"),
                HttpMethod.GET, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
//        String expected = "[{\"id\":0,\"title\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"shortText\":\"Curret tecknologies are developed very fast. It difficult to controll all technologies\",\"fullText\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"comments\":[{\"id\":0,\"text\":\"good post, thanks\"},{\"id\":1,\"text\":\"отстой, братан, ну серьезно\"},{\"id\":2,\"text\":\"пойдет\"}]}]";
//
//        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testGetPostById() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("api/posts/post/0"),
                HttpMethod.GET, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        //TODO: Create Json file which compare with appeared value or compare entities
        //String expected = "{\"id\":0,\"title\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"shortText\":\"Curret tecknologies are developed very fast. It difficult to controll all technologies\",\"fullText\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"comments\":[{\"id\":0,\"text\":\"good post, thanks\"},{\"id\":1,\"text\":\"отстой, братан, ну серьезно\"},{\"id\":2,\"text\":\"пойдет\"}]}";
        //JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    @Ignore
    public void testCreatePost() {
        PostDto post = createBasePostDto();

        HttpEntity<PostDto> entity = new HttpEntity<>(post, headers);

        ResponseEntity<String> postResponse = restTemplate.exchange(
                createURLWithPort("/api/posts/"),
                HttpMethod.POST, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        Assert.assertNotNull(postService.getPostById(post.getId()));
    }

    @Test
    @Ignore
    public void testUpdatePost() {
        HttpEntity<PostDto> entity = new HttpEntity<PostDto>(null, headers);

        ResponseEntity<PostDto> getResponse = restTemplate.exchange(
                createURLWithPort("/api/posts/post/0"),
                HttpMethod.GET, entity, PostDto.class);

        PostDto postDto = getResponse.getBody();
        String updatedString = "updated";
        postDto.setTitle(updatedString);

        HttpEntity<PostDto> updateEntity = new HttpEntity<>(postDto, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/posts/post/0"),
                HttpMethod.PUT, updateEntity, String.class);

        ResponseEntity<PostDto> getUpdatedResponse = restTemplate.exchange(
                createURLWithPort("/api/posts/post/0"),
                HttpMethod.GET, new HttpEntity<>(null, headers), PostDto.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertTrue(getUpdatedResponse.getBody().getTitle().equals(updatedString));
    }

//    @Test
//    public void testDeletePost() {
//        Post post = restTemplate.exchange(createURLWithPort("/api/posts/post/0"),
//                HttpMethod.GET, new HttpEntity<>(null, headers), PostDto.class).getBody();
//
//        HttpEntity deleteEntity = new HttpEntity(post, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/posts/post/0"),
//                HttpMethod.DELETE, deleteEntity, String.class);
//    }
}
