package ru.alexproject.blogserver;

import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseIntegrationTest extends BaseTest{

    @LocalServerPort
    protected int port;

    protected TestRestTemplate restTemplate = new TestRestTemplate();

    protected HttpHeaders headers =new HttpHeaders();

//    @BeforeClass
//    public void init(){
//        restTemplate = new TestRestTemplate();
//        headers = new HttpHeaders();
//    }

    protected String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
