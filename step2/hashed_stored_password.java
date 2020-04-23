package step2;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class hashed_stored_password {

   private static HashMap<String,String> map=new HashMap<>();


   
   public static boolean checkValidUser(String username)
   {
       if (map.containsKey(username)) {
           return true;
       }
       else
       {
           
           return false;
       }
   }


   
   public static boolean checkPassword(String username,String password) throws NoSuchAlgorithmException
   {
      String storedPassword = map.get(username);


      //caclulate hash value of the password and then compare it with storedPassword that is stored hashvalue

      String enteredPasswordHashed=getSHA256SecuredPassword(password);

      if (storedPassword.equals(enteredPasswordHashed)) {
          return true;
          
      } else {
          return false;
      }


   }



   public static void userDetails(String username,String password) throws NoSuchAlgorithmException
   {

        String hashedPassword=hashed_stored_password.getSHA256SecuredPassword(password);

       map.put(username, hashedPassword);

   }

   public static String getSHA256SecuredPassword(String password)throws NoSuchAlgorithmException {

    StringBuffer hashedString=new StringBuffer();
    try
    {
       MessageDigest digest = MessageDigest.getInstance("SHA-256");
       byte[]  encodedHash =digest.digest(password.getBytes(StandardCharsets.UTF_8));
       
       for (int i = 0; i < encodedHash.length; i++) {

           String x= Integer.toHexString(0xff & encodedHash[i]);

           if (x.length()==1) {
               hashedString.append(0);
           }
           hashedString.append(x);
           
       }

    }
    catch (Exception exception) {
        System.out.println(exception);


    }


    return hashedString.toString();


   }


    public static void main(String[] args) throws NoSuchAlgorithmException {
    
        System.out.println("*********** Welcome to my Life Secred  ******************");
        Scanner scan=new Scanner(System.in);
        
        //here I am storing predefined usernames and password currently we don't have fucntionality such as add user name and password
        hashed_stored_password.userDetails("sandy", "sandy123");
        hashed_stored_password.userDetails("amit", "amit123");


        System.out.println("Enter UserName ");
        String username=scan.next();
        System.out.println("Enter Password");
        String password=scan.next();

        System.out.println("Entered UserName "+username+" password  "+password);


        
        boolean isValidUser=checkValidUser(username);
        boolean isValidPassword=false;
        if (isValidUser) {
            isValidPassword=checkPassword(username,password);
            
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

        
   //     hashed_stored_password.map.forEach((k,v)->{ System.out.println(k+"  "+v);});


    }
}