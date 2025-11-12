package org.example.Collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Depatment> college = new HashMap<>();
        college.put(101,new Depatment("CSE",101));
        college.put(102,new Depatment("IT",102));
        college.put(103,new Depatment("ECE",103));
        college.put(104,new Depatment("CIVIL",104));

        int deptID = 101;
//STUDENT
        Student akilan = new Student(1,"akilan",101,89);
        Student x = new Student(2,"x",101,89);
        Student Hari = new Student(1,"Hari",102,89);

        String status  = college.get(akilan.getDept()).addStudent(akilan);

        System.out.println(status);

        System.out.println(college.get(x.getDept()).addStudent(x));

        college.get(Hari.getDept()).addStudent(Hari);

        Hari.setDept(101);
        Hari.setRollno(3);

        college.get(Hari.getDept()).addStudent(Hari);



        System.out.println(college.get(101).getStudentList().size());
//STAFF

        Staff segar = new Staff(201,"segar",101);
        college.get(segar.getDepId()).addStaff(segar);


//PRINTING

        for(Depatment depatment : college.values()){
            System.out.println(depatment.getName()+":");
            System.out.println("  Students :");
            for (Map<Integer, Student> s : depatment.getStudentList()){
                for(Student ss : s.values()){
                    System.out.println(ss);
                }
            }

            for (Map<Integer, Staff> staff : depatment.getStaffList()){
                for (Staff ss : staff.values()){
                    System.out.println(ss);
                }
            }
        }

        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
//        list.remove("Apple");
//        list.add("MAngo");
        System.out.println(list);

//        Map<Integer, String> map = Map.of(1, "One", 2, "Two");
    }

}