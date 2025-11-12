package org.example.FileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FolderHandlingExample {

    public static void main(String[] args) throws IOException {

//        writeFile("C:\\myfolder2\\myfile.txt");
        readFile("C:\\myfolder2\\myfile.txt");

    }

    private static void createFile(String s) throws IOException {
        File file = new File(s);
        if(file.createNewFile()){
            System.out.println("File is created "+ file.getName());
        }else {
            System.out.println("File not created..");
        }
    }

    public static void readFile(String s) throws IOException {
        File file = new File(s);

//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        while (bufferedReader.ready()){
//            System.out.println(bufferedReader.readLine());
//        }

//        FileInputStream fileInputStream = new FileInputStream(file);
//        int i = 0;
//        while ((i = fileInputStream.read()) != -1){
//            System.out.print((char) i);
//        }

        FileReader fileReader = new FileReader(file);
        int i=0;
        while (( i = fileReader.read())!=-1){
            System.out.print((char) i);
        }

    }
    public static void writeFile(String s) throws IOException {

        //WRITING THE FILE USING FILE WRITER

        FileWriter fileWriter = new FileWriter(s,true);
        fileWriter.write("Appended the text");

        //WRITING THE FILE USING BUFFERED WRITER

//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        bufferedWriter.newLine();
//        bufferedWriter.write("Java File Handling");

//        bufferedWriter.close();
    }

    private static void createFolder(String s) {
        File folder = new File(s);

        if(!checkFolderExist(s)){
            folder.mkdir();
            System.out.println("Folder created...");
        }else{

            for(File file : folder.listFiles()){

                if (file.exists()){
                    file.delete();
                }else {
                    System.out.println("file not found");
                }
            }
            System.out.println("Already exist..");
        }
    }

    public static boolean checkFolderExist(String s){
        File file = new File(s);
        return file.exists();
    }

    public static void deleteFolder(String s){
        File file = new File(s);
        if(checkFolderExist(s)){
            String status = file.delete() ? "Deleted.." : "Not deleted";
            System.out.println(status);
        }else {
            System.out.println("File Not found..");
        }
    }
}
