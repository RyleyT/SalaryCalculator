package SalaryCalculator;

import java.util.ArrayList;
import java.util.List;

/* The purpose of this class is to format the output that is displayed to the terminal.
 * The output should group together employees by role and display their total salary and name.  
 */

public class OutputFormatter {
	
	public static void displayEmployeesByRole(List<Employee> employees) {
		
		/* Build separate lists for each role */
		List<Employee> fullTime = new ArrayList<Employee>();
		List<Employee> partTime = new ArrayList<Employee>();
		List<Employee> contract = new ArrayList<Employee>();
		List<Employee> invalid = new ArrayList<Employee>();
		
		for(Employee e:employees) { // Separate each role into its own individual list
			if(e.getRole().toString() == "FULL_TIME") {
				fullTime.add(e);
			} if(e.getRole().toString() == "PART_TIME") {
				partTime.add(e);
			} if(e.getRole().toString() == "CONTRACT") {
				contract.add(e);
			} if(e.getRole().toString() == "INVALID") {
				invalid.add(e);
			}
		}
	
	double totalSalary = 0;	
	/* Check each list of roles and see if its populated, if it is print the employees and salaries for that role */
	if(fullTime.size() != 0) {	
		System.out.println("FULL TIME EMPLOYEES");
		for(Employee e:fullTime) {
			totalSalary += e.getSalary();
			System.out.println ("Name: " + e.getName() + ", Salary: $" + e.getSalary() );
		}
		System.out.println("Total Salary for Full Time Employees: $" + totalSalary);
		totalSalary = 0;
	}
	System.out.println(""); //Separating each list with a blank new line for a cleaner look.
	if(partTime.size() != 0) {		
		System.out.println("PART TIME EMPLOYEES");
		for(Employee e:partTime) {
			totalSalary += e.getSalary();
			System.out.println ("Name: " + e.getName() + ", Salary: $" + e.getSalary() );
		}
		System.out.println("Total Salary for Part Time Employees: $" + totalSalary);
		totalSalary = 0;
	}
	System.out.println("");
	if(contract.size() != 0) {		
		System.out.println("CONTRACT EMPLOYEES");
		for(Employee e:contract) {
			totalSalary += e.getSalary();
			System.out.println ("Name: " + e.getName() + ", Salary: $" + e.getSalary() );
		} 
		System.out.println("Total Salary for Contract Employees: $" + totalSalary);
		totalSalary = 0;
	}
	System.out.println("");
	if(invalid.size() != 0) {
		System.out.println("EMPLOYEES WITH INVALID ROLE");		
		for(Employee e:invalid) {
			totalSalary += e.getSalary();
			System.out.println ("Name: " + e.getName() + ", Salary: $" + e.getSalary() );
		}
		System.out.println("Total Salary for Invalid Employees: $" + totalSalary);
		totalSalary = 0;
	}
}


}
