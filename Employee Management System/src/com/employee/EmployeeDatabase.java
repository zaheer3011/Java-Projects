package com.employee;

import java.util.Map;
import java.util.HashMap;

public class EmployeeDatabase {

    private Map<Integer, Employee> employeeDetails = new HashMap <> ();

    protected EmployeeDatabase() {
        employeeDetails.put(1, new Employee( "Sriram", 45, "Management", "CEO", null));
        employeeDetails.put(2, new Employee( "Mukund", 25, "HR", "HR Manager", 1));
        employeeDetails.put(3, new Employee("Sebastian", 38, "Finance", "Finance Manange", 1));
        employeeDetails.put(4, new Employee("Aashritha", 32, "Product Management", "Dev Manager", 2));
        employeeDetails.put(5, new Employee("Mohammed Rafi", 35, "HR", "HR Lead", 2));
        employeeDetails.put(6, new Employee("Anjali Kumar", 29, "HR", "HR Associate", 5));
        employeeDetails.put(7, new Employee("Jsoeph", 40, "Finance", "Finance Associate", 3));
        employeeDetails.put(8, new Employee("Ramachandran", 37, "Product Development", "Tech Lead", 4));
        employeeDetails.put(9, new Employee("Abhinaya Shankar", 33, "Product Development", "Software Devloper", 8));
        employeeDetails.put(10, new Employee("Imran Khan", 28, "Product Testing", "QA Lead", 8));
    }

    protected void displayAllRecords() {

        System.out.println("+---------------------------------------------------------+ ");
        System.out.println("| Id | Name | Age | Department | Designation | Manager Id | ");
        System.out.println("+_________________________________________________________+ ");

        for(Employee emp : employeeDetails.values()) {

            Integer managerId = emp.getManagerId();
            String managerName = (managerId == null) ? "None" : employeeDetails.get(managerId).getName();

            System.out.println(emp.getId() + " | " + emp.getName() + " | " + emp.getAge() + " | " + emp.getDepartment() + " | " +
                    emp.getDesignation() + " | " + managerId);
        }

    }

    public void isRecordAvailable(int id) {

        if(employeeDetails.containsKey(id)) {
            Employee emp = employeeDetails.get(id);
            this.execute(emp);
        }

        else {
            System.out.println("Record Not Found");
        }
    }

    protected void updateEmployeeDetails(Employee emp) {

        if(emp != null) {
            int newId = emp.getId();
            employeeDetails.put(newId, emp);
            System.out.println("Id : " + newId);
            this.execute(emp);
            System.out.println("Employees Details Added...");
        }

        else {
            System.out.println("Records Not Found");
        }
    }

    public void updateEmployeename(int id, String name) {
        Employee emp = employeeDetails.get(id);
        if(emp != null) {
            System.out.println("Name Updated");
            this.execute(emp);
        }
    }

    public void updateEmployeeAge(int id, int age) {
        Employee emp = employeeDetails.get(id);
        emp.setAge(age);
        System.out.println("Age Updated");
        this.execute(emp);
    }

    public void updateEmployeeDepartment(int id, String department) {
        Employee emp = employeeDetails.get(id);
        emp.setDepartment(department);
        System.out.println("Department Updated");
        this.execute(emp);
    }

    public void updateEmployeeDesignation(int id, String designation) {
        Employee emp = employeeDetails.get(id);
        emp.setDesignation(designation);
        System.out.println("designation Updated");
        this.execute(emp);
    }

    public void updateManagerId(int id, int managerId) {
        Employee emp = employeeDetails.get(id);
        emp.setManagerId(managerId);
        System.out.println("Manager ID Updated");
        this.execute(emp);
    }

    public void removeEmployeeData(int id) {

        if(employeeDetails.get(id) != null) {
            employeeDetails.remove(id);
            System.out.println("Employee Data has been removed");
        }

        else {
            System.out.println("Invalid Id number");
        }

    }

    public void displayManagerRecord(String managerName) {

        Integer managerId = issManagerAvailable(managerName);
        if(managerId != null) {
            Employee emp = employeeDetails.get(managerId);
            execute(emp);
        }

        else {
            System.out.println("Manager Name is Not found");
        }
    }

    public void displayTreesOfEmployees(String name) {

        Integer managerId = issManagerAvailable(name);

        if(managerId == null) {
            System.out.println("Name not found!");
            return;
        }

        System.out.print(name + " -> ");

        try {
            while(managerId != null) {
                if(managerId == null) return;

                String managerName = employeeDetails.get(managerId).getName();
                System.out.print(managerName);

                managerId = issManagerAvailable(managerName);

                if(managerId != null) {
                    System.out.print(" -> ");
                }
            }
        }

        catch(NullPointerException exe) {
            System.out.println(exe.getMessage());
        }

        System.out.println();
    }

    public void showAllSummary() {

        Map<String, Integer> countDepartments = new HashMap <> ();
        Map<String, Integer> countDesignation = new HashMap <> ();
        Map<String, Integer> countManageers = new HashMap <> ();
        for(Employee emp : employeeDetails.values()) {
            countDepartments.put(emp.getDepartment(), countDepartments.getOrDefault(emp.getDepartment(), 0) + 1);
        }

        System.out.println("Department " + " " + "Count ");
        displayAllSUmmary(countDepartments);

        for(Employee emp : employeeDetails.values()) {
            countDesignation.put(emp.getDesignation(), countDesignation.getOrDefault(emp.getDesignation(), 0) + 1);
        }

        System.out.println("Designation  " + " " + "Count ");
        displayAllSUmmary(countDesignation);

        for(Employee emp : employeeDetails.values()) {
            countManageers.put(emp.getName(), countManageers.getOrDefault(emp.getName(), 0) + 1);
        }

        System.out.println("Designation  " + " " + "Count ");
        displayAllSUmmary(countManageers);

    }

    public int countDepartmentEmployees(String deptName) {

        int count = 0;
        for(Employee emp : employeeDetails.values()) {
            if(emp.getDepartment().equals(deptName))
                count += 1;
        }

        return count;
    }

    public void displayAllSUmmary(Map<String, Integer> countEmployees) {

        for(Map.Entry<String, Integer> entry : countEmployees.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println();
    }


    public Integer issManagerAvailable(String managerName) {

        int managerId = 0;
       for(Employee emp : employeeDetails.values()) {
           if(emp.getName().equalsIgnoreCase(managerName)) {
                managerId = emp.getManagerId();
                return managerId;
           }
       }

       return null;
    }

    private void execute(Employee emp) {

        System.out.println(emp.getId() + " | " + emp.getName() + " | " + emp.getAge() + " | " +
                emp.getDepartment() + " | " + emp.getDesignation() + " | " + emp.getManagerId());
    }

}
