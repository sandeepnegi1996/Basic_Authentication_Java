package passwordHashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashedPassword {

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
}
