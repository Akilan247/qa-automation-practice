package JSONPractice;

import java.io.IOException;
import java.util.Arrays;

public class JsonCrudOperations {

    public static void main(String[] args) throws IOException {

        //READ DATA FROM JSON FILE

        JsonUtil.readUserFromJson();

        //ADD NEW DATA FROM JSON FILE

        Person person = new Person(24,"sugash", Arrays.asList("Java","C","C++"));
        JsonUtil.addNewDataToFile(person);

        //OVERWRITE THE EXISTING FILE
//        JsonUtil.writeUserToJSon(person);


    }
}
