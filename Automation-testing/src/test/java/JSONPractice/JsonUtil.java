package JSONPractice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class JsonUtil {

    private static final ObjectMapper objectMapper=new ObjectMapper();
    private static final String path = "C:\\Users\\aximsoft\\IdeaProjects" +
            "\\qa-automation-practice\\Automation-testing\\test-data\\data.json";

    public static List<Person> readUserFromJson() throws IOException {

        List<Person> personList = objectMapper.readValue(new File(path),new TypeReference<List<Person>>() {});

        for(Person person : personList){
            System.out.println(person);
        }
        return personList;
    }

    public static void writeUserToJSon(Person person) throws IOException {

        try {
            File file = new File(path);
            if(file.exists()){
//                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path),person);
                objectMapper.writeValue(file,person);
                System.out.println("Json File Updated..");
            }else {
                System.out.println("File not found");
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void writeUsersToJSon(List<Person> person) throws IOException {

        try {
            File file = new File(path);
            if(file.exists()){

                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path),person);

                System.out.println("Json File Updated..");

            }else {
                System.out.println("File not found");
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void addNewDataToFile(Person person) throws IOException {
        List<Person> personList = readUserFromJson();
        personList.add(person);

        writeUsersToJSon(personList);
    }
}
