package JSONPractice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonExample {

    public static void main(String[] args) throws IOException {

        // USING JSON-SIMPLE LIBRARY

        JSONParser jsonParser = new JSONParser();
        File file;
        file = new File("data.json");
        try{
            file = new File("data.json");
            FileReader fileReader = new FileReader(file);
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;

            String name =(String) jsonObject.get("name");
            long age =(long) jsonObject.get("age");

            System.out.println(name);
            System.out.println(age);
            System.out.println(jsonObject.get("skills"));

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
// USING JACKSON LIBRARY----

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(file, Person.class);
//
//        System.out.println(person);
    }
}
