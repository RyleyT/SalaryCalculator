package SalaryCalculator;

import java.util.StringJoiner;
import java.util.regex.Pattern;

/* The purpose of this class is to create the data model that will be used for all employees in this project.
 * 
 */

enum Role {PART_TIME, FULL_TIME, CONTRACT, INVALID};

public class Employee {
	

	
	Role role;
	private String name;
	private double rate;
	private int hours;
	private double salary;
	
	public Employee() {
		
	}
	
	public Employee(String name, double rate, int hours, String role) throws IllegalArgumentException{
		this.rate = rate;
		this.hours = hours;
		this.name = name;		
		
		role = role.replaceAll(" ", "_"); //Replace any spaces in our role string with "_"
		try {
			this.role = Role.valueOf(role.toUpperCase());
		} catch (IllegalArgumentException e) { //If the role is not a legal value, throw exceptoion set to invalid.
			this.role = Role.INVALID;
			e.printStackTrace();
		}
		
		setSalary(rate, hours);
		
	}
	
	public void setSalary(double rate, int hours) { //Perform calculations for employee salary according to role. Set result as salary for employee.
		switch(role) {
		case PART_TIME:
			this.salary = rate*hours;
			break;
		case FULL_TIME:
			if(rate*hours > 50000) {
				this.salary = 50000;
			} else {
				this.salary = rate*hours;
			}
			
			break;
		case CONTRACT:
			this.salary = (10000 + (hours*rate));
			break;
		case INVALID:
			this.salary = (rate*hours);
			break;
		}
		
	}
	
	public double getSalary() { //return the salary
		return this.salary;
	}
	
	
	@Override
	public String toString() {
		return "Employee [role=" + role + ", name=" + name + ", rate=" + rate + ", hours=" + hours + ", Salary=" + salary +"]";
	}

	/* getters */
	public Role getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public double getRate() {
		return rate;
	}

	public int getHours() {
		return hours;
	}
	
	/* setters */
	public void setRole(Role role) {
		this.role = role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	
	
	
}
