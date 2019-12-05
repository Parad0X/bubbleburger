package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  @RequestMapping("/characters")
  public String characters() {
    return "Characters";
  }

  @RequestMapping("/characters/{id}")
  public String getCharacter() {
    return "Character";
  }

  public String getCharacterTweets() {
    return "Tweets";
  }

  public String getTweet() {
    return "Tweet";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
