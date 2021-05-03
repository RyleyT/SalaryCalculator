package SalaryCalculator;

import java.io.IOException;
import java.util.List;

/* The purpose of this application is to take in information about a list of employees from a CSV file, passed into the application as a command line argument,
 * and print the salary amount for each employee to the terminal. 
 */

public class main {

	public static void main(String[] args) throws IOException {
		String filepath = args[0].toString(); //Grab the passed in command line argument and set it as our file path
		List<Employee> employees = EmployeeFileReader.readFile(filepath); //Get our list of employees from the file	
		OutputFormatter.displayEmployeesByRole(employees); //Display the Employees to the terminal
	}

}
