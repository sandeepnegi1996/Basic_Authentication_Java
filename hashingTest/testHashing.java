package hashingTest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class testHashing {


    //     //Add salt
    //     private static byte[] getSalt() throws NoSuchAlgorithmException
    //     {
    //         SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
    //         byte[] salt = new byte[16];
    //         sr.nextBytes(salt);
    //         return salt;
    //     }
    // private static String get_SHA_1_SecurePassword(String passwordToHash, byte[] salt)
    // {
    //     String generatedPassword = null;
    //     try {
    //         MessageDigest md = MessageDigest.getInstance("SHA-1");
    //         md.update(salt);
    //         byte[] bytes = md.digest(passwordToHash.getBytes());
    //         StringBuilder sb = new StringBuilder();
    //         for(int i=0; i< bytes.length ;i++)
    //         {
    //             sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    //         }
    //         generatedPassword = sb.toString();
    //     } 
    //     catch (NoSuchAlgorithmException e) 
    //     {
    //         e.printStackTrace();
    //     }
    //     return generatedPassword;
    // }
     
    public static void main(String[] args) throws NoSuchAlgorithmException {

    //     byte[] salt=getSalt();
    //  String hashedString=   get_SHA_1_SecurePassword("sandy123", salt);
    //     System.out.println(hashedString);
        
      String originalString="amit123";

        MessageDigest digest = MessageDigest.getInstance("SHA");
        byte encodedHash[]= digest.digest(originalString.getBytes(StandardCharsets.UTF_8));

        StringBuffer hashedString=new StringBuffer();

        for (int i = 0; i < encodedHash.length; i++) {
            
          String x= Integer.toHexString(0xff & encodedHash[i]);
          
          if (x.length()==1) 
          {
            hashedString.append('0');    
          }
          hashedString.append(x);
        }

        String finalHashedString = hashedString.toString();

        System.out.println(finalHashedString);
    }

}