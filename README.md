# EmployeeDB

A Java web application for managing employee data using JDBC, MySQL, and JSP. This project allows users to perform CRUD (Create, Read, Update, Delete) operations on an employee database.

## Features
- Add new employees
- View all employees
- Update employee details
- Delete employees from the database

## Technologies Used
- **Java (JDBC)**: For database connectivity and interaction
- **MySQL**: To store employee details
- **JSP**: For front-end rendering and user interaction

## Employee Details
- **employeeID**: Unique identifier for each employee
- **employeeName**: Name of the employee
- **employeeEmail**: Email address of the employee
- **employeeSalary**: Salary of the employee
- **designation**: Employee's job role or designation

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/employee-db.git

##create a database
CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
    employeeID INT PRIMARY KEY AUTO_INCREMENT,
    employeeName VARCHAR(100),
    employeeEmail VARCHAR(100),
    employeeSalary DOUBLE,
    designation VARCHAR(50)
);
## to access the project
http://localhost:8080/employee-db/
