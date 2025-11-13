package org.example.Collection.collegeManag;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Depatment> college = new HashMap<>();
        college.put(1001,new Depatment("CSE",1001));
        college.put(1002,new Depatment("IT",1002));
        college.put(1003,new Depatment("ECE",1003));
        college.put(1004,new Depatment("CIVIL",1004));

        int deptID = 1001;
//STUDENT
        Student akilan = new Student(1,"akilan",1001,89);
        Student x = new Student(2,"x",1001,85);
        Student Hari = new Student(1,"Hari",1002,79);

        String status  = college.get(akilan.getDept()).addStudent(akilan);

        System.out.println(college.get(x.getDept()).addStudent(x));

        college.get(Hari.getDept()).addStudent(Hari);

        Hari.setDept(1001);
        Hari.setRollno(3);

        college.get(Hari.getDept()).addStudent(Hari);

        System.out.println(college.get(1001).getStudentList().size());
//STAFF
        Staff segar = new Staff(201,"segar",1001);
        college.get(segar.getDepId()).addStaff(segar);
        college.get(1001).addStaff(new Staff(202,"XYZ",1001));

//PRINTING


        for(Depatment depatment : college.values()){
            List<Student> studentList = new ArrayList<>();
            List<Staff> staffList = new ArrayList<>();
            System.out.println(depatment.getName()+":");
            System.out.println("  Students :");

            for (Map<Integer, Student> s : depatment.getStudentList()){
                studentList.addAll(s.values());
            }
            Collections.sort(studentList);

            for (Student s : studentList){
                System.out.println(s);
            }

            for (Map<Integer, Staff> staff : depatment.getStaffList()){
                staffList.addAll(staff.values());
            }
            staffList.sort((s1,s2)->s1.compare(s1,s2));
            System.out.println("  Staffs :");
            for (Staff ss : staffList){
                System.out.println(ss);
            }
        }
    }
}