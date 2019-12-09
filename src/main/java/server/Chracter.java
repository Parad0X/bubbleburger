package server;

import org.json.simple.JSONObject;

class Character {
  public long id;
  public String full_name, email;

  public Character(long id, String full_name, String email)
  {
    this.id = id;
    this.full_name = full_name;
    this.email = email;
  }

  public JSONObject toJson()
  {
      JSONObject res = new JSONObject();
      res.put("id", id);
      res.put("full_name", full_name);
      res.put("email", email);
      return res;
  }
}
