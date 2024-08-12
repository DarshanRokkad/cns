import java.math.*;
import java.util.*;

public class rsa {

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else
            return gcd(b % a, a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the message to be encrypted:");
        int msg = sc.nextInt();

        System.out.println("Enter the first prime number (p):");
        int p = sc.nextInt();

        System.out.println("Enter the second prime number (q):");
        int q = sc.nextInt();

        int n = p * q;
        int phi = (p - 1) * (q - 1);
        System.out.println("the value of phi(n) = " + phi);

        int e;
        for (e = 2; e < phi; e++) {
            if (gcd(e, phi) == 1) {
                break;
            }
        }
        System.out.println("the value of e = " + e);

        int d = 0;
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * phi);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("the value of d = " + d);

        // encryption
        double cipherText = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is : " + cipherText);

        // decryption
        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(cipherText).toBigInteger();
        BigInteger plainText = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : " + plainText);
    }
}

/*
Output:

Enter the message to be encrypted:
25
Enter the first prime number (p):
7
Enter the second prime number (q):
11
the value of phi(n) = 60
the value of e = 7
the value of d = 43
Encrypted message is : 53.0
Decrypted message is : 25

*/

// Note: msg = 25, p = 7 and q = 11