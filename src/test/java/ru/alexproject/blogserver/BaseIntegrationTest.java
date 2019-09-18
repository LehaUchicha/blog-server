package ru.alexproject.blogserver;

import org.junit.Before;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;

public abstract class BaseIntegrationTest extends BaseTest{

    @LocalServerPort
    protected int port;

    protected TestRestTemplate restTemplate;

    protected HttpHeaders headers =new HttpHeaders();

    @Before
    public void init(){
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
    }

    protected String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
