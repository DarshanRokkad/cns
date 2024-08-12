import java.security.MessageDigest;
import java.util.Scanner;
public class md5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message to be hashed: ");
        String text = sc.nextLine();

        MessageDigest d = MessageDigest.getInstance("MD5");
        d.update(text.getBytes("UTF-8"));
        byte[] hashBytes = d.digest();

        String hexString = "";
        for (byte hb : hashBytes) {
            String hex = Integer.toHexString(0xff & hb);
            if (hex.length() == 1) {
                hexString += '0';
            }
            hexString += hex;
        }
        System.out.println("MD5 Hash: " + hexString);
    }
}

/*
Output:
Enter the message to be hashed: hello
MD5 Hash: 5d41402abc4b2a76b9719d911017c592
*/

// Note: Change from program 9 to program 10 is just 'getInstance("MD5")'