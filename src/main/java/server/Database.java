package server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Database {

    public static Collection<Character> getCharacters()
    {
        ArrayList<Character> characters = new ArrayList();

        return characters;
    }

    public static Character getCharacter(int id)
    {
        return new Character(1, "Andrei", "abc45432@gmail.com");
    }

    public static Collection<Tweet> getCharacterTweets(int characterId)
    {
        ArrayList<Tweet> tweets = new ArrayList();

        return tweets;
    }

    public static Tweet getTweet(int tweetId)
    {
        return new Tweet(1, 5, "Hello!");
    }
}