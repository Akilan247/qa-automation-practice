package org.example.FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesExample {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        FileInputStream  fileInputStream = new FileInputStream(new File("C:\\Users\\aximsoft\\" +
                "IdeaProjects\\Collection-Practice\\data.properties"));

        properties.load(fileInputStream);

//        System.out.println(properties.getProperty("age"));

        for(String s : properties.stringPropertyNames()){
            System.out.println(properties.getProperty(s));
        }
    }
}
