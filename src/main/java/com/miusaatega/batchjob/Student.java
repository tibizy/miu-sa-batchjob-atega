package com.miusaatega.batchjob;

public class Student {
    private String firstName;
    private String lastName;
    private double gpa;
    private int age;

    public Student(String firstName, String lastName, double gpa, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
