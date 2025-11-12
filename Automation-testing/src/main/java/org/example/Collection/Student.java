package org.example.Collection;

public class Student {
    private int rollno;
    private String name;
    private int dept;
    private int mark;

    public Student(){}

    public Student(int rollno,String name,int dept,int mark){
        this.rollno = rollno;
        this.name =name;
        this.dept = dept;
        this.mark = mark;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "\trollno=" + rollno +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", mark=" + mark ;
    }
}
