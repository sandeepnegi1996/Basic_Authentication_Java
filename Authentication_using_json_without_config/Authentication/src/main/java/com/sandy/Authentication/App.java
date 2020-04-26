package com.sandy.Authentication;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.User;
import passwordHashing.HashedPassword;;
public class App 
{
	
    public static void main( String[] args ) throws JsonMappingException, JsonProcessingException, NoSuchAlgorithmException
    {

    	System.out.println("############# Welcome to my personal Secret Login System  ####################");
    	System.out.println();
    	System.out.println("If you Login Successfully you will get to know some deep secret about you ");
    	System.out.println();
    	
    	Scanner scan=new Scanner(System.in);
    	System.out.print("Enter the username :   ");
    	
    	String username=scan.next();
    
    	System.out.print("Enter the password  :  ");
    	String password=scan.next();
    	String hashedPassword=null;
    	
    	try {
   
    		 hashedPassword=HashedPassword.getSHA256SecuredPassword(password);		 
    	}
    	
    	catch (Exception e) {
    		System.out.println(e);
 
    	}
    	
     	
    	//json Array this will be replaced by the configuration file
    	String jsonArray="[{\"username\":\"sandy\",\"password\":\"bf8d1d240f5a29dd4d3a1579b609ac3497ba200e9a49ce3078e059260b4b03fc\"},{\"username\":\"amit\",\"password\":\"1fec7401b302e76333629c9f68415b7718769e072f0613e54726143cda06d789\"}]";
    	
    	
    	//Deseializing the jsonArray into list of user
    	List<User> users = null;
    	try
    	{
    		ObjectMapper objectmapper=new ObjectMapper();
        	 users= objectmapper.readValue(jsonArray, new TypeReference<List<User>>() {} );
        
    	}
    	catch (Exception e)
    	{
    		System.out.println(e);
    	}
       	
    	
    	//create User object from the username and password and use conains method to find in the list
    	
    	User user1=new User();
    	user1.setUsername(username);
    	user1.setPassword(hashedPassword);

    	
    	//find user1 in list of users
    	// equals method in User class is overrided and checked that if username and password is equal then only it is equal
    	// another approach coming to my mind is to create a separate class and implements Comparator class
    	//compare to method where we can also do the same thing
    	
    	if(users.contains(user1))
    	{
    		System.out.println(" #################   login successfully done   #################################");
    	}
    	else
    	{
    		System.out.println("##################      Login Failed   #################################");
    	}
    	   	
       	scan.close();
    	
    }
}

