import java.security.MessageDigest;
import java.util.Scanner;

public class sha {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message to be hashed: ");
        String text = sc.nextLine();
        
        MessageDigest d = MessageDigest.getInstance("SHA-512");
        d.update(text.getBytes("UTF-8"));
        byte[] hashBytes = d.digest();
        String hexString = "";
        for (byte hb : hashBytes) {
            String hex = Integer.toHexString(0xff & hb);
            if (hex.length() == 1) {
                hexString+='0';
            }
            hexString+=hex;
        }
        System.out.println("SHA-512 Hash: " + hexString); 
    }
}

/*
Output:
Enter the message to be hashed: hello
SHA-512 Hash: 9b71d224bd62f3785d96d46ad3ea3d73319bfbc2890caadae2dff72519673ca72323c3d99ba5c11d7c7acc6e14b8c5da0c4663475c2e5c3adef46f73bcdec043
*/

// Note: Exception handling is must or else it will give you error