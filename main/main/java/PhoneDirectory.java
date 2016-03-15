//Large Scale Programming
//Morgan Williams
//@02711227

package main.java;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class PhoneDirectory{
	String entryName;
	String entryNumber;
	String textFile;
	String seperator;
	
	public static List<PhoneDirectory> directory = new ArrayList<PhoneDirectory>();
	
	public PhoneDirectory(){
		entryName = null;
		entryNumber = null;
	}
	
	public PhoneDirectory(String location){
		try{
			File file1 = new File(System.getProperty("/Users/Morgan/Desktop/PhoneDirectory") + location + "/PhoneDirectory/main/resources/phoneDir.txt");
			textFile = location + "/PhoneDirectory/main/resources/phoneDir.txt";
			seperator = ",";
			Scanner input = new Scanner(file1);

			while(input.hasNextLine()) {
               PhoneDirectory temp = new PhoneDirectory();
               String in[] = new String[4];
               String line = input.nextLine();
               in = line.split(",");
               temp.entryName = in[0];
               temp.entryNumber = in[1];
               
               directory.add(temp);     
			}   

			input.close();     
			
			}
		catch (IOException e){
			//prints the stack trace of the exception 
			e.printStackTrace();
		}
	}
	
	//Delete Phone Directory Entry
	public void deleteEntry(String name){
		for(int x = 0; x < directory.size(); x++){
			if(directory.get(x).entryName.equals(name))
				directory.remove(x);
		}
	}
	
	//Add Phone Directory Entry
	public void addEntry(String name, String number){
		PhoneDirectory temp = new PhoneDirectory();
		temp.entryName = name;
		temp.entryNumber = number;
		directory.add(temp);
	}
	
	//Change Phone Directory Entry 
	public void changeEntry(String name, String number){
		for(int x = 0; x < directory.size(); x ++){
			if (directory.get(x).entryName.equals(name)){
				directory.get(x).entryNumber = number;
			}
		}
	}
	
	//Return phone number 
	public String getNumber(String name){
		for(int x = 0; x < directory.size(); x++){
			if(directory.get(x).entryName.equals(name))
				return directory.get(x).entryNumber;
		}
		return null;
	}
	
	public void printDirectory(){
		System.out.printf("%-15s%-20s", "Name: ", "Phone Number: ");
		System.out.println();
		for (int x = 0; x < directory.size(); x++) {
			String entryName1 = directory.get(x).entryName;
			String entryNumber1 = directory.get(x).entryNumber;
			System.out.printf("%-15s%-20s",entryName1, entryNumber1);
			System.out.println();
		}
	}
	
	public void write(){
		try {
            FileWriter fileWriter = new FileWriter(new File(System.getProperty("/Users/Morgan/Desktop/PhoneDirectory") + textFile));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int x = 0; x < directory.size(); x++) {
            	bufferedWriter.write(directory.get(x).entryName + seperator + directory.get(x).entryNumber);
            	bufferedWriter.newLine();
            }
            bufferedWriter.close();
        	}
        catch(IOException ex) {
            ex.printStackTrace();
        }
	}	
}