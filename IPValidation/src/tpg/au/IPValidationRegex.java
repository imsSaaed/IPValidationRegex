package tpg.au;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by Rahimi, 7/5/2018 
 * Time Start : 10:25am 
 * Time Finish : 10:45am
 * 
 * Question 1
 * Write a class called IPValidationRegex which will use regular expression to validate input IP
   addresses according to the following criteria:
   
   IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0
   to 255. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
   
   Prepare a text file with a list of IP addresses and have your class read in the file then filter out
   any invalid IP address(es).
 * 
 * 
 */
public class IPValidationRegex {
	static Pattern pattern;
    static Matcher matcher;
    
    //criteria for regular expression to validate input IP Addresses
    private static final String IPADDRESS_PATTERN = 
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";	  
	
	
	
	//main method
    public static void main(String [] args) {
    	readTextFile();
    }
    
    //method for read IP Address from text file
    public static void readTextFile(){
    	// The name of the file to open.
        String fileName = "ipAddresses.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // List of IP Address
            ArrayList<String> list = new ArrayList<String>();
            
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                list.add(line);
            } 
            System.out.println();
            for(String ip:list){
            	boolean valid = validateIP(ip); 
            	if(valid){
            		System.out.println("IPAddress "+ip+" is valid.");
            	}else{
            		System.out.println("IPAddress "+ip+" is invalid.");                		
            	}
            		
            }
            
            // Always close files.
            bufferedReader.close();     
        }
        catch(FileNotFoundException ex) {
            System.out.println( "Unable to open file '" +  fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '"   + fileName + "'");       
        }
    }
    
    // validate for each IP
    public static boolean validateIP(String ip){
    	pattern = Pattern.compile(IPADDRESS_PATTERN);
    	matcher = pattern.matcher(ip);
    	
    	return matcher.matches();
    }
}
