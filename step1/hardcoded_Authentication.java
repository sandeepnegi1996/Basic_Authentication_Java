package step1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// To Compile this
// Go to parent Directory
// java step1.Test
//Step1 is the package name
 class Test {

    HashMap<String,String> userDetails=new HashMap<String,String>();
    


    public  boolean checkValidUser(String username)
    {
        if (userDetails.containsKey(username)) {
            return true;
        }
        else
        {
            
            return false;
        }
    }

    public boolean checkPassword(String username,String password)
    {
       String storedPassword = userDetails.get(username);

       if (storedPassword.equals(password)) {
           return true;
           
       } else {
           return false;
       }


    }
    public static void main(String args[])
    {
        Test t1=new Test();
        t1.userDetails.put("amit", "amit123");
        t1.userDetails.put("sandy", "sandy123");

        
       Scanner s=new Scanner(System.in);
       System.out.println("**** Login ****");
       System.out.println("Enter User Name  ");

       String username=s.next();

        System.out.println("Enter Password  ");

        String password=s.next();

        System.out.println("Entered username: " + username+ "  password is: "  + password);


       

        boolean isValidUser=t1.checkValidUser(username);
        boolean isValidPassword=false;
        if (isValidUser) {
            isValidPassword=t1.checkPassword(username,password);
            
        } else {
            System.out.println("No Account Exists");
            
        }

        if (isValidPassword) {

            System.out.println("**** Logged In **** ");
            System.out.println("You are eligible for my deepest Darkest Secret  ");
            System.out.println(" I want atleast Two monitor setup with one mac book bro this is my dream desk ");
            System.out.println("************************");
            
        } else {
            System.out.println("**** invalid user ****");
        }

    }
    
}