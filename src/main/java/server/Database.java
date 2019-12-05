import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Database {

    class Character {
    public int id;
    public String full_name, email;
    }

    // class Tweet {
    // public int id, user_id;
    // public String tweet;
    // }

    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("looneychars.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray characterList = (JSONArray) obj;
            System.out.println(characterList);

            //Iterate over characters array
            characterList.forEach(charac -> parseCharObj((JSONObject) charac));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseCharObj(JSONObject charac)
	{
        //Get character id
        String id = (String) charac.get("id");
        Integer.parseInt(id);
        System.out.println(id);

		//Get character full name
		String full_name = (String) charac.get("full_name");
		System.out.println(full_name);

		//Get character email
		String email = (String) charac.get("email");
        System.out.println(email);
	}
}