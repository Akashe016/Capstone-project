package Learn;

import java.util.HashMap;
import java.util.Map;

public class Assignment {

	
	public String name;
    public String location;

    public Assignment(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public static void main(String[] args) {
    	
        // Creating a map to store Wipro employees
        Map<String, Assignment> wiproEmployees = new HashMap<>();

        // Adding employees to the map
        wiproEmployees.put("Patrick", new Assignment("Patrick", "Bengaluru"));
        wiproEmployees.put("John", new Assignment("John", "Hyderabad"));

        // Adding one more employee
        wiproEmployees.put("Rajesh", new Assignment("Rajesh", "Mumbai"));

        // Total number of employees
        int totalEmployees = wiproEmployees.size();
        System.out.println("Total number of employees: " + totalEmployees);
        
        // Printing all employees
        System.out.println("All employees:");
        for (Map.Entry<String, Assignment> entry : wiproEmployees.entrySet()) {
            String employeeName = entry.getKey();
            Assignment employee = entry.getValue();
            System.out.println("Name: " + employee.name + ", Location: " + employee.location);
        }
    }
}
