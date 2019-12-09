package server;

import java.util.*;

import javax.servlet.http.*;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
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
  public Collection<JSONObject> characters() {
    Collection<Character> characters = Database.getCharacters();
    ArrayList<JSONObject> charactersJson = new ArrayList<JSONObject>();

    for (Character c: characters) {
      charactersJson.add(c.toJson());
    }

    return charactersJson;
  }

  @RequestMapping("/characters/{id}")
  public JSONObject getCharacter(@PathVariable("id") int characterId) {
    return Database.getCharacter(characterId).toJson();
  }

  @RequestMapping("/characters/{id}/tweets")
  public Collection<JSONObject> getCharacterTweets(@PathVariable("id") int characterId) {
    Collection<Tweet> tweets = Database.getCharacterTweets(characterId);
    ArrayList<JSONObject> tweetsJson = new ArrayList<JSONObject>();

    for (Tweet t: tweets) {
      tweetsJson.add(t.toJson());
    }

    return tweetsJson;
  }

  @RequestMapping("/characters/{id}/tweets/{tweetId}")
  public JSONObject getTweet(
    @PathVariable("id") int characterId,
    @PathVariable("tweetId") int tweetId
  ) {
    return Database.getTweet(characterId, tweetId).toJson();
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
