package server;

import org.json.simple.JSONObject;

class Tweet {
  public int id, character_id;
  public String tweet;

  public Tweet(int id, int character_id, String tweet)
  {
    this.id = id;
    this.character_id = character_id;
    this.tweet = tweet;
  }

  public JSONObject toJson()
  {
      JSONObject res = new JSONObject();
      res.put("id", id);
      res.put("character_id", character_id);
      res.put("tweet", tweet);
      return res;
  }
}
