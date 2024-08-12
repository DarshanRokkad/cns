import java.util.Scanner;
public class playfair {
        
    public static char[][] matrix = new char[5][5];

    public static boolean contains(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c)
                    return true;
            }
        }
        return false;
    }
    
    public static void generateMatrix(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "");
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        String keyStr = key + alphabet;
        
        int row = 0;
        int col = 0;
        for (int i = 0; i < keyStr.length(); i++) {
            char c = keyStr.charAt(i);
            if (!contains(c)) {
                matrix[row][col] = c;
                col++;
            }
            if (col == 5) {
                row++;
                col = 0;
            }
            if (row == 5) {
                break;
            }
        }
    }
    
    public static int[] findPosition(char c) {
        int[] pos = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }
        return pos;
    }
    
    public static String encrypt(String plaintext) {

        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", "");
        plaintext = plaintext.replaceAll("J", "I");

        String ciphertext = "";

        for (int i = 0; i < plaintext.length(); i += 2) {
            // select the digram and then find there position in the matrix
            char a = plaintext.charAt(i);
            char b = (i + 1 < plaintext.length()) ? plaintext.charAt(i + 1) : 'X';
            
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);
            int rowA = posA[0];
            int rowB = posB[0];
            int colA = posA[1];
            int colB = posB[1];

            char encryptedA, encryptedB;
            // same row
            if (rowA == rowB) {
                encryptedA = matrix[rowA][(colA + 1) % 5];
                encryptedB = matrix[rowB][(colB + 1) % 5];
            }
            // same column
            else if (colA == colB) {
                encryptedA = matrix[(rowA + 1) % 5][colA];
                encryptedB = matrix[(rowB + 1) % 5][colB];
            }
            // rectangle (swap)
            else {
                encryptedA = matrix[rowA][colB];
                encryptedB = matrix[rowB][colA];
            }

            ciphertext+=encryptedA;
            ciphertext+=encryptedB;
        }
        
        return ciphertext;
    }
    
    public static String decrypt(String ciphertext) {
        String plaintext = "";

        for (int i = 0; i < ciphertext.length(); i += 2) {
            char a = ciphertext.charAt(i);
            char b = ciphertext.charAt(i + 1);
            
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);
            int rowA = posA[0];
            int rowB = posB[0];
            int colA = posA[1];
            int colB = posB[1];

            char decryptedA, decryptedB;
            // same row
            if (rowA == rowB) {
                decryptedA = matrix[rowA][(colA + 4) % 5];
                decryptedB = matrix[rowB][(colB + 4) % 5];
            }
            // same coloumn
            else if (colA == colB) {
                decryptedA = matrix[(rowA + 4) % 5][colA];
                decryptedB = matrix[(rowB + 4) % 5][colB];
            }
            // in rectangle
            else {
                decryptedA = matrix[rowA][colB];
                decryptedB = matrix[rowB][colA];
            }

            plaintext+=decryptedA;
            plaintext+=decryptedB;
        }
        
        return plaintext;
    }
    
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        
        System.out.println("Enter the string:");
        String str = sc.nextLine();
        System.out.println("Enter the key:");
        String key = sc.nextLine();
        
        System.out.println("Original String is " + str);
        System.out.println("Key is " + key);
        
        generateMatrix(key);
        
        String encryptedString = encrypt(str);
        System.out.println("Encrypted String is " + encryptedString);
        
        String decryptedString = decrypt(encryptedString);
        System.out.println("Decrypted String is " + decryptedString);
    }
}


/* 
Output: 
Enter the string:
aditya
Enter the key:
hello
Original String is aditya
Key is hello
Encrypted String is LGNQZO
Decrypted String is ADITYA
*/

// Note: output will be in upper case letter only