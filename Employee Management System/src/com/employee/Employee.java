package com.employee;

public class Employee {

    private int id;
    private String name;
    private int age;
    private String department;
    private String designation;
    private Integer managerId;

    private static int nextID = 0;

    public Employee( String name, int age, String department, String designation, Integer managerId) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.designation = designation;
        this.managerId = managerId;
        this.id = ++nextID;
    }

    public int getId() { return id; }
    public Integer getManagerId() { return managerId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public String getDesignation() { return designation; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setDepartment(String department){ this.department = department; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setManagerId(Integer managerId) { this.managerId = managerId; }
}
