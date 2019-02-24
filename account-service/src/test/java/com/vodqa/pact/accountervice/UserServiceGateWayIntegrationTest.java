package com.vodqa.pact.accountervice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ActiveProfiles("test")
@RestClientTest(UserServiceGateway.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceGateWayIntegrationTest {
    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockRestServiceServer;
    private UserServiceGateway gateway;

    @Before
    public void setUp() throws Exception {
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);

        gateway = new UserServiceGateway(restTemplate, "localhost", "8052");
    }


    @Test
    public void shouldReturnUser() throws Exception {
        String body = "{\"userName\":\"Gopinath\"," +
                "\"emailId\":\"gopinath@gmail.com\"}";

        mockRestServiceServer.expect(requestTo("http://localhost:8052/user"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(body, MediaType.APPLICATION_JSON));

        User user = gateway.getuser();

        User expectedUser = new User("Gopinath", "gopinath@gmail.com");
        assertThat(user).isEqualTo(expectedUser);
    }
}