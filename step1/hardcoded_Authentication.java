package step1;
import java.util.Scanner;

// To Compile this
// Go to parent Directory
// java step1.Test
//Step1 is the package name
 class Test {

    public static void main(String args[])
    {
       Scanner s=new Scanner(System.in);

       System.out.println("**** Login ****");
       System.out.println("Enter User Name  ");

       String username=s.next();

        System.out.println("Enter Password  ");

        String password=s.next();

        System.out.println("Entered username: " + username+ "  password is: "  + password);

        if (username.equals("sandy") && password.equals("123")) {
            System.out.println("Hi Successfully Logged in");
        } else {
            System.out.println("Wrong User Details were Entered");
            System.exit(0);
        }

    }
    
}