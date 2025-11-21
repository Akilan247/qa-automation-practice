package org.example.FileHandling.csvExample;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static void main() throws IOException {
        dataFromCSV();

    }
    public static void dataFromCSV() throws IOException {

        File file = new File("C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                "Automation-testing\\test-data\\user-data.csv");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line;

        while((line = bufferedReader.readLine())!=null){

            String[] lineArr = line.split(",");

            for(String value : lineArr){
                System.out.print(value+"\t\t");
            }
            System.out.println();
        }

    }

    public  Object[][] getDataFromCSV() throws IOException {

        File file = new File("C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                "Automation-testing\\test-data\\user-data.csv");

        List<String> stringList = Files.readAllLines(file.toPath());

        int rows = stringList.size();
        int cols = stringList.getFirst().split(",").length;

        System.out.println(rows+" "+cols);

        Object[][] data = new Object[rows][cols];

        for (int row = 0; row < rows; row++){
            String[] lineArr = stringList.get(row).split(",");
            System.out.println(Arrays.toString(lineArr));
            for(int col = 0; col < cols; col++){
                data[row][col] = lineArr[col];
                System.out.println(lineArr[col]);
            }
        }

        for(Object[] ob : data){
            System.out.println(Arrays.toString(ob));
        }

        return data;
    }

}
