package SalaryCalculator;

/* The purpose of this class is to help separate the logic needed to read input from a CSV file and create employees based off of that input
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeFileReader {
	
	public static String header;
	
	public static List<Employee> readFile(String filename) throws IOException { //This function will read a file and return a list of Employees from the files contents.
		
		List<Employee> employees = new ArrayList <Employee>();
		
		List<String> fileContents = Files.readAllLines((Paths.get(filename))); // Here we take advantage of the java.nio.file.Files class to open and read all lines from a file and store the contents in a variable in a single step.
		
		header = fileContents.get(0); //We take the first element of the file as a header.
		fileContents.remove(0); //remove the header from the list
		
		for(String line:fileContents) { // for each line in the fileContents we will look at each string and parse them individually						
			String[] string = line.split(","); //using regular expression, split each line using comma as the delimiter.
			
			/* Here parse each line of the CSV to create an employee model*/
			String name = string[0];
			double rate = Double.parseDouble(string[1]);
			int hours = Integer.parseInt(string[2]);
			String role = string[3];			
			
			Employee e = new Employee(name, rate, hours, role);
			employees.add(e); //create the model and add it to our list
		}
		
		return employees;
	
	}
}
