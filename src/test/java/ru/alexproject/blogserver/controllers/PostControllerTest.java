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
import ru.alexproject.blogserver.model.dto.PostDto;

import java.net.URI;
import java.net.URISyntaxException;

public class PostControllerTest extends BaseIntegrationTest {

    @Test
    public void testGetAllPosts() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/posts/"),
                HttpMethod.GET, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        String expected = "[{\"id\":0,\"title\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"shortText\":\"Curret tecknologies are developed very fast. It difficult to controll all technologies\",\"fullText\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\"}]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testGetPostById() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("api/posts/post/0"),
                HttpMethod.GET, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        //TODO: Create Json file which compare with appeared value or compare entities
        String expected = "{\"id\":0,\"title\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\",\"shortText\":\"Curret tecknologies are developed very fast. It difficult to controll all technologies\",\"fullText\":\"Spring Boot - Spring Data JPA with Hibernate and H2 Web Console\"}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
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
    public void testUpdatePost() throws URISyntaxException {
        HttpEntity<PostDto> entity = new HttpEntity<PostDto>(null, headers);

        ResponseEntity<PostDto> getResponse = restTemplate.exchange(
                createURLWithPort("/api/posts/post/0"),
                HttpMethod.GET, entity, PostDto.class);

        PostDto postDto = getResponse.getBody();
        String updatedString = "updated";
        postDto.setTitle(updatedString);

        HttpEntity<PostDto> updateEntity = new HttpEntity<>(postDto, headers);

        restTemplate.withBasicAuth("a.a", "a")
                .put(new URI("http://localhost:"+port+"/api/posts/post/0"), updateEntity);

        ResponseEntity<PostDto> getUpdatedResponse = restTemplate.exchange(
                createURLWithPort("/api/posts/post/0"),
                HttpMethod.GET, new HttpEntity<>(null, headers), PostDto.class);

        Assert.assertEquals(HttpStatus.OK, getUpdatedResponse.getStatusCode());
        Assert.assertTrue(getUpdatedResponse.getBody().getTitle().equals(updatedString));
    }

    @Test
    public void testDeletePost() {
        PostDto post = restTemplate.exchange(createURLWithPort("/api/posts/post/0"),
                HttpMethod.GET, new HttpEntity<>(null, headers), PostDto.class).getBody();

        HttpEntity deleteEntity = new HttpEntity(post, headers);

        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/posts/post/0"),
                HttpMethod.DELETE, deleteEntity, String.class);
    }
}
