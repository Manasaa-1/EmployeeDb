package com.jsp.jdbc.employeedb;

public class Employee {
	 private int employeeID;
	    private String employeeName;
	    private String employeeEmail;
	    private double employeeSalary;
	    private String designation;
	    

	    

		public Employee(int employeeID, String employeeName, String employeeEmail, double employeeSalary, String designation) {
	        this.employeeID = employeeID;
	        this.employeeName = employeeName;
	        this.employeeEmail = employeeEmail;
	        this.employeeSalary = employeeSalary;
	        this.designation = designation;
	    }

	    @Override
	    public String toString() {
	        return "Employee{" +
	                "employeeID=" + employeeID +
	                ", employeeName='" + employeeName + '\'' +
	                ", employeeEmail='" + employeeEmail + '\'' +
	                ", employeeSalary=" + employeeSalary +
	                ", designation='" + designation + '\'' +
	                '}';
	    }

}
