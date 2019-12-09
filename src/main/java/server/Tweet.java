package server;

import org.json.simple.JSONObject;

class Tweet {
  public long id;
  public long characterId;
  public String tweet;

  public Tweet(long id, long character_id, String tweet)
  {
    this.id = id;
    this.characterId = character_id;
    this.tweet = tweet;
  }

  public JSONObject toJson()
  {
      JSONObject res = new JSONObject();
      res.put("id", id);
      res.put("character_id", characterId);
      res.put("tweet", tweet);
      return res;
  }
}
