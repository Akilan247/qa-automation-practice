package JSONPractice;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadJsonUsingJSONSimpleExample {

    public static void main(String[] args) throws IOException {

        // USING JSON-SIMPLE LIBRARY

        JSONParser jsonParser = new JSONParser();

        File file = new File("C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing\\test-data\\data.json");
        try{
            FileReader fileReader = new FileReader(file);
            Object obj = jsonParser.parse(fileReader);
            JSONArray jsonArray = (JSONArray) obj;

            for (Object object : jsonArray){
                JSONObject jsonObject = (JSONObject) object;
                String name =(String) jsonObject.get("name");
                long age =(long) jsonObject.get("age");

//                System.out.print("Name :"+name+" ");
//                System.out.print("Age :"+age+" ");
//                System.out.print(" "+jsonObject.get("skills"));
//                System.out.println();
            }

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

// USING JACKSON LIBRARY----

        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> personList = objectMapper.readValue(file,new TypeReference<List<Person>>() {});

        for (Person person : personList){
            System.out.println(person);
        }
    }
}
