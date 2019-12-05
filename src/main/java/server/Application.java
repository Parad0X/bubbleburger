package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
  @RequestMapping("/")
  public String home() {
      return
        "<h1>API:</h1>" +
        "<ul>" +
        "  <li>/characters</li>" +
        "  <li>/characters/{id}</li>" +
        "  <li>/characters/{id}/tweets</li>" +
        "  <li>/characters/{id}/tweets/{tweetId}</li>" +
        "</ul>";
  }

  @RequestMapping("/characters")
  public String characters() {
    return "Characters";
  }

  @RequestMapping("/characters/{id}")
  public String getCharacter(String chracterId) {
    return "Character";
  }

  @RequestMapping("/characters/{id}/tweets")
  public String getCharacterTweets(String chracterId) {
    return "Tweets";
  }

  @RequestMapping("/characters/{id}/tweets/{tweetId}")
  public String getTweet(String id, String tweetId) {
    return "Tweet";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
