package Learn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		 HashMap< String, String> map = new HashMap<>();
		    
	     Scanner input = new Scanner(System.in);     
	     
	     map.put("Akash", "trichy");
	     map.put("gokul", "Chennai");
	     map.put("siddarth", "Chennai");
	     map.put("santhosh", "coimbatore");
	     map.put("lokesh", "Chennai");

	     // add one employee for wipro 
	     System.out.print("Enter your name : ");
	     String name = input.next();
	     System.out.print("Enter your city : ");
	     String city = input.next();
	     
	     map.put(name,city);
	     
	     // add total no of employees
	     int count=0;
	     for(Map.Entry<String, String> hm : map.entrySet()) {
	    	 
	    	 count++;
	    	if(hm.getValue().equals("Chennai")) {

	    		System.out.println(hm.getKey()+" - "+hm.getValue());
	    	}
	     }
	     
			System.out.println("Total = "+count);

	}

}
