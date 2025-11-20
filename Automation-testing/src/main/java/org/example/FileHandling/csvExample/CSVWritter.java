package org.example.FileHandling.csvExample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWritter {

    public static void main() throws IOException {
        csvWritter();
    }

    public static Object[][] csvWritter() throws IOException {

        CSVReader csvReader = new CSVReader();

        String filePath = "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing\\test-data\\test-data2.csv";
        File file = new File(filePath);

        FileWriter fileWriter = new FileWriter(file);

        Object[][] data = csvReader.getDataFromCSV();

        for (Object[] objects : data){
            for (Object ob : objects){
                fileWriter.append((CharSequence) ob).append(",");
            }
            fileWriter.append("\n");
        }

        fileWriter.close();

        return data;
    }
}
