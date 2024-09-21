package com.jsp.jdbc.employeedb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

 class EmployeeRepository {
	  Connection connection=null;
   
	    public EmployeeRepository() {
	        try {
	            Properties props = new Properties();
	            InputStream input = getClass().getClassLoader().getResourceAsStream("connection.properties");
	            if (input == null) {
	                throw new FileNotFoundException("Property file 'connection.properties' not found in the classpath");
	            }
	            props.load(input);

	            String url = props.getProperty("db.url");
	            String username = props.getProperty("db.username");
	            String password = props.getProperty("db.password");

	           
	            connection = DriverManager.getConnection(url, username, password);
	            System.out.println("Connection established successfully.");
	            EmployeeRepository repository = new EmployeeRepository();
	            if (repository.connection != null) {
	                System.out.println("Connection established successfully.");
	            } else {
	                System.out.println("Failed to establish connection.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void addEmployee(String name, String email, double salary, String designation) {
	        String sql = "INSERT INTO employees (employeeName, employeeEmail, employeeSalary, designation) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, name);
	            stmt.setString(2, email);
	            stmt.setDouble(3, salary);
	            stmt.setString(4, designation);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Employee findEmployeeById(int id) {
	        String sql = "SELECT * FROM employees WHERE employeeID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Employee(
	                        rs.getInt("employeeID"),
	                        rs.getString("employeeName"),
	                        rs.getString("employeeEmail"),
	                        rs.getDouble("employeeSalary"),
	                        rs.getString("designation")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public Employee findEmployeeByEmail(String email) {
	        String sql = "SELECT * FROM employees WHERE employeeEmail = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, email);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Employee(
	                        rs.getInt("employeeID"),
	                        rs.getString("employeeName"),
	                        rs.getString("employeeEmail"),
	                        rs.getDouble("employeeSalary"),
	                        rs.getString("designation")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public List<Employee> findAllEmployees() {
	        List<Employee> employees = new ArrayList<>();
	        String sql = "SELECT * FROM employees";
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                employees.add(new Employee(
	                        rs.getInt("employeeID"),
	                        rs.getString("employeeName"),
	                        rs.getString("employeeEmail"),
	                        rs.getDouble("employeeSalary"),
	                        rs.getString("designation")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return employees;
	    }

	    public void updateEmployeeSalaryByDesignation(String designation, double newSalary) {
	        String sql = "UPDATE employees SET employeeSalary = ? WHERE designation = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setDouble(1, newSalary);
	            stmt.setString(2, designation);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteAllEmployeesBetweenSalary(double minSalary, double maxSalary) {
	        String sql = "DELETE FROM employees WHERE employeeSalary BETWEEN ? AND ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setDouble(1, minSalary);
	            stmt.setDouble(2, maxSalary);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteEmployeeByEmail(String email) {
	        String sql = "DELETE FROM employees WHERE employeeEmail = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, email);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
