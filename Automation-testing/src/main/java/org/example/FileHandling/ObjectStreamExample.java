package org.example.FileHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Employee implements Serializable{
    private int id;
    private String name;

    public Employee(int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Employee Id : "+
                getId() + "\tName : "+
                getName();
    }
}

public class ObjectStreamExample {
    public static void main(String[] args) throws FileNotFoundException {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"X"));
        employeeList.add(new Employee(2,"y"));
        employeeList.add(new Employee(3,"z"));
        Employee employee = new Employee(121,"Akilan");
        Employee employee1 = new Employee(122,"Akil");
        employeeList.add(employee);
        employeeList.add(employee1);


        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(("employee.dat")));
            for (Employee employe : employeeList){
                objectOutputStream.writeObject(employe);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(("employee.dat")));
            while(true){
                try {
                    Employee employee2 =(Employee) objectInputStream.readObject();
                    System.out.println(employee2);
                }catch (EOFException e){
                    break;
                }
            }
        }catch(ClassNotFoundException e){
            System.out.println("Class not found"+e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
