package com.jsp.jdbc.employeedb;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employee by ID");
            System.out.println("3. Find Employee by Email");
            System.out.println("4. Find All Employees");
            System.out.println("5. Update Employee Salary by Designation");
            System.out.println("6. Delete All Employees Between Salary");
            System.out.println("7. Delete Employee by Email");
            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter designation: ");
                    scanner.nextLine();  
                    String designation = scanner.nextLine();
                    repository.addEmployee(name, email, salary, designation);
                    break;
                case 2:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    Employee employeeById = repository.findEmployeeById(id);
                    System.out.println(employeeById);
                    break;
                case 3:
                    System.out.print("Enter employee email: ");
                    email = scanner.nextLine();
                    Employee employeeByEmail = repository.findEmployeeByEmail(email);
                    System.out.println(employeeByEmail);
                    break;
                case 4:
                    System.out.println("All Employees:");
                    for (Employee e : repository.findAllEmployees()) {
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.print("Enter designation: ");
                    designation = scanner.nextLine();
                    System.out.print("Enter new salary: ");
                    salary = scanner.nextDouble();
                    repository.updateEmployeeSalaryByDesignation(designation, salary);
                    break;
                case 6:
                    System.out.print("Enter min salary: ");
                    double minSalary = scanner.nextDouble();
                    System.out.print("Enter max salary: ");
                    double maxSalary = scanner.nextDouble();
                    repository.deleteAllEmployeesBetweenSalary(minSalary, maxSalary);
                    break;
                case 7:
                    System.out.print("Enter employee email: ");
                    email = scanner.nextLine();
                    repository.deleteEmployeeByEmail(email);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
