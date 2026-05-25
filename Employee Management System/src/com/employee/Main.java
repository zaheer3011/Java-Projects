package com.employee;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        EmployeeDatabase employeeDatabase = new EmployeeDatabase();

        System.out.println("Employee Management System");
        int choice = 0;

        do {

            System.out.println("1. Show All records");
            System.out.println("2. Search and update records");
            System.out.println("3. Remove Employee");
            System.out.println("4. Manager Report");
            System.out.println("5. Reporting To - Tree");
            System.out.println("6. Summary Reports");
            System.out.println("7. Quit");
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch(choice) {

                case 1 -> {
                    employeeDatabase.displayAllRecords();
                    break;
                }

                case 2 -> {
                    boolean looped = true;
                    int options = 0;

                    while (looped) {
                        System.out.println("\n1. Search");
                        System.out.println("2. Update");
                        System.out.println("3. Exit");
                        options = sc.nextInt();

                        // Search Data
                        if (options == 1) {
                            System.out.println("Enter Id : ");
                            int searchOptions = sc.nextInt();

                            employeeDatabase.isRecordAvailable(searchOptions);

                        // Update Data
                        } else if (options == 2) {
                            int updateOptions;

                            // Add another criteria
                            do {
                                System.out.println("\n1. Add another criteria");
                                System.out.println("2. Update Record");
                                System.out.println("3. Exit");
                                updateOptions = sc.nextInt();

                                if(updateOptions == 1) {
                                    Integer managerId;
                                    int age;
                                    String name, department, designation;

                                    sc.nextLine();
                                    System.out.println("Name : ");
                                    name = sc.nextLine();
                                    System.out.println("Age : ");
                                    age = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Department : ");
                                    department = sc.nextLine();
                                    System.out.println("Designation : ");
                                    designation = sc.nextLine();
                                    System.out.println("Manager Id : ");
                                    managerId = sc.nextInt();

                                    Employee emp = new Employee(name, age, department, designation, managerId);
                                    employeeDatabase.updateEmployeeDetails(emp);

                                }

                                else if(updateOptions == 2) {
                                    int id, updatechoice;
                                    System.out.println("Enter your id : ");
                                    id = sc.nextInt();
                                    do {
                                        System.out.println("1. Name" + '\n' + "2. Age" + '\n' + "3. Department" + '\n' +
                                                "4. Designation" + '\n' + "5. ManagerId" + '\n' + "6. Exit");
                                        updatechoice = sc.nextInt();

                                        switch (updatechoice) {

                                            case 1 -> {
                                                sc.nextLine();
                                                System.out.println("Name : ");
                                                String name = sc.nextLine();
                                                employeeDatabase.updateEmployeename(id, name);
                                            }

                                            case 2 -> {
                                                int age;
                                                System.out.println("Age : ");
                                                age = sc.nextInt();
                                                employeeDatabase.updateEmployeeAge(id, age);
                                            }

                                            case 3 -> {
                                                String department;
                                                sc.nextLine();
                                                System.out.println("Department : ");
                                                department = sc.nextLine();
                                                employeeDatabase.updateEmployeeDepartment(id, department);
                                            }

                                            case 4 -> {
                                                String designation;
                                                sc.nextLine();
                                                System.out.println("Designation : ");
                                                designation = sc.nextLine();
                                                employeeDatabase.updateEmployeeDesignation(id, designation);
                                            }

                                            case 5 -> {
                                                Integer managerId;
                                                System.out.println("managerId : ");
                                                managerId = sc.nextInt();
                                                employeeDatabase.updateManagerId(id, managerId);
                                            }

                                            case 6 -> {
                                                break;
                                            }

                                            default -> {
                                                System.out.println("Invalid choice");
                                            }
                                        }

                                    } while(updatechoice != 6);
                                }

                                else {
                                    System.out.println("Invalid Option");
                                }


                            } while(updateOptions != 3);

                        } else if (options == 3) {
                            looped = false;
                        } else {
                            System.out.println("Invalid Option");
                        }
                    }

                }

                case 3 -> {
                    int id;
                    System.out.println("id : ");
                    id = sc.nextInt();
                    employeeDatabase.removeEmployeeData(id);
                    break;
                }

                case 4 -> {
                    sc.nextLine();
                    String managerName;
                    System.out.println("Manager Name : ");
                    managerName = sc.nextLine();
                    employeeDatabase.displayManagerRecord(managerName);
                    break;
                }

                case 5 -> {
                    String name;
                    sc.nextLine();
                    System.out.println("Name : ");
                    name = sc.nextLine();
                    employeeDatabase.displayTreesOfEmployees(name);
                    break;
                }

                case 6 -> {
                    employeeDatabase.showAllSummary();
                    break;
                }


                case 7 -> {
                    break;
                }

                default -> {
                    System.out.println("Invalid choice");
                }

            }


        } while( choice != 7 );
    }
}
