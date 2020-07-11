package com.whzhu.chess.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import com.whzhu.chess.models.Greeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.Map;
import java.util.HashMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerIT {

  @LocalServerPort private int port;

  private URL base;

  @Autowired private TestRestTemplate template;

  @BeforeEach
  public void setUp() throws Exception {
    this.base = new URL("http://localhost:" + port + "/greeting");
  }

  @Test
  public void getGreeting() throws Exception {
    ResponseEntity<Greeting> response = template.getForEntity(base.toString(), Greeting.class);
    assertThat(response.getBody().getContent()).isEqualTo("Hello, World!");
    assertThat(response.getBody().getId()).isEqualTo(1);
  }

  @Test
  public void getGreeting2() throws Exception {
    ResponseEntity<Greeting> response =
        template.getForEntity(
            String.format("%s?name=%s", base.toString(), "Spring Community"), Greeting.class);
    assertThat(response.getBody().getContent()).isEqualTo("Hello, Spring Community!");
    assertThat(response.getBody().getId()).isEqualTo(2);
  }
}
