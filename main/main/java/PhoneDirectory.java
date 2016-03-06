//Large Scale Programming
//Morgan Williams
//@02711227

package main.java;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PhoneDirectory{
	static Properties properties = new Properties();
	
	public PhoneDirectory(){
		try (InputStream in = new FileInputStream("src/main/resources/phone.properties")) {
			Properties property1 = new Properties();
			property1.load(in);
			for (String property : property1.stringPropertyNames()) {
				String value = property1.getProperty(property);
				addEntry(property, value);
			}
		}
		catch (IOException e){
			//prints the stack trace of the exception 
			e.printStackTrace();
		}
	}
	
	//Delete Phone Directory Entry
	public void deleteEntry(String name){
		try{
			OutputStream out = new FileOutputStream("src/main/resources/phone.properties");
			properties.remove(name);
			properties.store(out,  "Phone Directory");
		}
		catch (IOException e){
			//prints the stack trace of the exception 
			e.printStackTrace();
		}
	}
	
	//Add Phone Directory Entry
	public void addEntry(String name, String number){
		try {
			OutputStream out = new FileOutputStream("src/main/resources/phone.properties");
			properties.setProperty(name, number);
			properties.store(out, "Phone Directory");
		}
		catch (IOException e){
			//prints the stack trace of the exception
			e.printStackTrace();
		}
	}
	
	//Change Phone Directory Entry 
	public void changeEntry(String name, String number){
		deleteEntry(name);
		addEntry(name, number);
	}
	
	//Return phone number 
	public String getNumber(String name){
		return properties.getProperty(name);
	}
	
	public void printDirectory(){
		System.out.printf("%-15s%-20s", "Name: ", "Phone Number: ");
		System.out.println();
		for (String property : properties.stringPropertyNames()){
			String value = properties.getProperty(property);
			System.out.printf("%-15s%-20s", property, value);
			System.out.println();
		}
	}
}