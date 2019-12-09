package server;

import java.io.FileReader;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class Database {

    public static Collection<Character> getCharacters()
    {
        ArrayList<Character> characters = new ArrayList<Character>();

        JSONArray jsonCharacters = readJsonFile("looneychars.json");

        jsonCharacters.forEach(entry -> {
            JSONObject j = (JSONObject) entry;

            long id = (long) j.get("id");
            String name = (String) j.get("full_name");
            String email = (String) j.get("email");

            characters.add(
                new Character(id, name, email)
            );
        });

        return characters;
    }

    public static Character getCharacter(int id)
    {
        for (Character character: getCharacters()) {
            if (character.id == id) {
                return character;
            }
        }

        return null;
    }

    public static Collection<Tweet> getCharacterTweets(int characterId)
    {
        Collection<Tweet> characterTweets = new ArrayList<Tweet>();

        for (Tweet tweet: getTweets()) {
            if (tweet.characterId == characterId) {
                characterTweets.add(tweet);
            }
        }

        return characterTweets;
    }

    public static Tweet getTweet(int characterId, int tweetId)
    {
        for (Tweet tweet: getCharacterTweets(characterId)) {
            if (tweet.id == tweetId) {
                return tweet;
            }
        }

        return null;
    }

    private static Collection<Tweet> getTweets()
    {
        ArrayList<Tweet> tweets = new ArrayList();

        JSONArray jsonTweets = readJsonFile("looneytweets.json");

        jsonTweets.forEach(entry -> {
            JSONObject j = (JSONObject) entry;

            long id = (long) j.get("id");
            long characterId = (long) j.get("character_id");
            String tweet = (String) j.get("tweet");

            tweets.add(
                new Tweet(id, characterId, tweet)
            );
        });

        return tweets;
    }

    private static JSONArray readJsonFile(String filename)
    {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filename)) {
            return (JSONArray) jsonParser.parse(reader);
        } catch (Exception e) {
            return new JSONArray();
        }
    }
}