//Large Scale Programming
//Morgan Williams
//@02711227

package test.java;
import main.java.PhoneDirectory;
import java.util.Scanner;

public class Driver extends PhoneDirectory{
	
	public static void main(String[] s){
		//Create a Phone Directory
		PhoneDirectory directory1 = new PhoneDirectory("/src");	
		System.out.println("Phone Directory:\n");
		
		int userSelection = 0;
		Scanner in = new Scanner(System.in);
		String name, number;
		
		//User Prompt
		do{ //prompt user to add entry
			System.out.println("Enter 1 to add an entry to the Phone Directory and press enter.");
			//prompt user to delete entry
			System.out.println("Enter 2 to delete an entry from the Phone Directory and press enter.");
			//prompt user to change entry
			System.out.println("Enter 3 to get the number from an entry in the Phone Directory and press enter.");
			//prompt user to get the number of an entry
			System.out.println("Enter 4 to change an entry in the Phone Directory and press enter.");
			//prompt user to print the Phone Directory
			System.out.println("Enter 5 to print the Phone Directory and press enter.");
			//prompt user to exit the program
			System.out.println("Enter 0 to exit the program and press enter.");
			
			userSelection = in.nextInt();
			in.nextLine();
			switch(userSelection){
			//add an entry
			case 1:
				System.out.println("Enter the name of the entry.");
				name = in.nextLine();
				name.trim();
				System.out.println("Enter the number of the entry.");
				number = in.nextLine();
				directory1.addEntry(name, number);
				break;
			//delete an entry
			case 2: 
				System.out.println("Enter the name of the entry you want to delete.");
				name = in.nextLine();
				name.trim();
				directory1.deleteEntry("Name");
				break;
			//get a number
			case 3: 
				System.out.println("Enter the name of the entry you want to retrieve a number from.");
				name = in.nextLine();
				name.trim();
				System.out.println(directory1.getNumber(name));
				break;
			//change an entry
			case 4: 
				System.out.println("Enter the name of the entry you want to change.");
				name = in.nextLine();
				name.trim();
				System.out.println("Enter the number of the entry you want to change.");
				number = in.nextLine();
				directory1.changeEntry(name, number);
				break;
			//print the Phone Directory
			case 5: 
				directory1.printDirectory();
				break;
				   
			default:
				break;
		   }
		   }while(userSelection != 0);	   
		   
			directory1.write();
		    in.close();

	}
}
