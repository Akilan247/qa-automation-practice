package JSONPractice;

import org.openqa.selenium.json.Json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JsonCrudOperations {

    public static void main(String[] args) throws IOException {

        //READ DATA FROM JSON FILE

        JsonUtil.readUserFromJson();

        //ADD NEW DATA FROM JSON FILE

        Person person = new Person(24,"Harish", Arrays.asList("Java","C","C++"));
//        JsonUtil.addNewDataToFile(person);

        //OVERWRITE THE EXISTING FILE

        JsonUtil.writeUserToJSon(person);


    }
}
