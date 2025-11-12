package org.example.FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class WritePropertiesExample {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        properties.setProperty("name","Akilan");
        properties.setProperty("age","X");
        properties.setProperty("dob","Y");
        properties.setProperty("phno","Z");

        File file = new File("C:\\Users\\aximsoft\\IdeaProjects\\Collection-Practice\\data.properties");

        FileWriter fileWriter = new FileWriter(file);

        properties.store(fileWriter,"Properties example");

        fileWriter.close();
    }
}
