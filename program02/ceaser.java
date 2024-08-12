import java.util.Scanner;
class ceaser {
    
    public static String encrypt(String s){
        String ans = "";
        for(int i = 0; i<s.length(); i++){
            char new_char = (char)(((((int)s.charAt(i) - 97) + 3) % 26) + 97);
            ans += new_char;
        }
        return ans;
    }
    
    public static String decrypt(String s){
        String ans = "";
        for(int i = 0; i<s.length(); i++){
            char new_char = (char)(((((int)s.charAt(i) - 97) + 23) % 26) + 97);
            ans += new_char;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the string:");
        String str = sc.nextLine();
        
        System.out.println("Original String is " + str);
        
        String encryptedString = encrypt(str);
        System.out.println("Encrypted String is " + encryptedString);
        
        String decryptedString = decrypt(encryptedString);
        System.out.println("Decrypted String is " + decryptedString);
    }
}


/*
Output:
Enter the string:
hello
Original String is hello
Encrypted String is khoor
Decrypted String is hello
*/

// Note : give input string only in small character