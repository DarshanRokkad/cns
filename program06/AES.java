import java.util.*;
import javax.crypto.*;

public class AES {
    public static SecretKey generateKey(int n) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(n);
        return kg.generateKey();
    }

    public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String cipherText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to encrypt:");
        String plainText = scanner.nextLine();
        SecretKey secretKey = generateKey(128);
        String encryptedText = encrypt(plainText, secretKey);
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = decrypt(encryptedText, secretKey);
        System.out.println("Decrypted Text: " + decryptedText);
        scanner.close();

    }
}

/*
Output:
Enter text to encrypt:
darshan
Encrypted Text: UgKF+Z5Ovqiicg5Em+yXFg==
Decrypted Text: darshan
*/

// Note: Exception handling in main function is complusary