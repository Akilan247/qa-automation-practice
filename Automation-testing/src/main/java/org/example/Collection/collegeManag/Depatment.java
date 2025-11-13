package org.example.Collection.collegeManag;

import java.util.*;

public class Depatment {
    private Set<Integer> studentIdList = new HashSet<>();
    private Set<Integer> staffIdList = new HashSet<>();
    private int depId;
    private String name;
    private List<Map<Integer, Student>> studentList = new ArrayList<>();
    private List<Map<Integer, Staff>> staffList = new ArrayList<>();

    public Depatment(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<Integer, Student>> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Map<Integer, Student>> studentList) {
        this.studentList = studentList;
    }

    public List<Map<Integer, Staff>> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Map<Integer, Staff>> staffList) {
        this.staffList = staffList;
    }

    public Depatment(String name, int depId){
        this.depId = depId;
        this.name = name;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String addStudent(Student s){
        Map<Integer, Student> studentMap = new HashMap<>();
        Student std1 = new Student(s.getRollno(),s.getName(),s.getDept(),s.getMark());
        if(studentIdList.add(s.getRollno())){
            studentMap.put(s.getRollno(),std1);
            studentList.add(studentMap);
            return "Succesfully added";
        }
        return "already exist";
    }

    @Override
    public String toString() {
        return "Depatment :" +
                " \t\n depId=" + depId +
                ",\t\n name='" + name + '\'' +
                ",\t\n studentList=" + studentList +
                ",\t\n staffList=" + staffList +
                '}';
    }

    public String addStaff(Staff s){
        Map<Integer, Staff> staffMap = new HashMap<>();
        Staff std1 = new Staff(s.getId(),s.getName(),s.getDepId());
        if(staffIdList.add(s.getId())){
            staffMap.put(s.getId(),std1);
            staffList.add(staffMap);
            return "Succesfully added";
        }
        return "already exist";
    }
}
