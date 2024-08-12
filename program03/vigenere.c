#include<stdio.h>
#include<string.h>
#include<ctype.h>

void encrypt(char* s, char* key, char* ciphertext){
    int n = strlen(s);
    int m = strlen(key);
    for(int i=0, j=0; i<n; i++, j++){
        if(j==m){
            j = 0;
        }
        int curr = toupper(s[i]) - 'A';
        int shift = toupper(key[j]) - 'A';
        char ch = ((curr + shift) % 26) + 'A';              // encrypted character
        ciphertext[i] = ch;
    }
}

void decrypt(char* s, char* key, char* plaintext){
    int n = strlen(s);
    int m = strlen(key);
    for(int i=0, j=0; i<n; i++, j++){
        if(j==m){
            j = 0;
        }
        int curr = toupper(s[i]) - 'A';
        int shift = toupper(key[j]) - 'A';
        char ch = ((curr - shift + 26) % 26) + 'A';         // decrypted character
        plaintext[i] = ch;
    }
}

int main() {
    
    char str[100], key [10];
    printf("Enter the string : ");
    scanf(" %s", &str);
    printf("Enter the key : ");
    scanf(" %s", &key);
    
    printf("\nOriginal String : %s\n", str);
    printf("Key : %s\n", key);
    
    char encryptedString[100], decryptedString[100];
    encrypt(str, key, encryptedString);
    printf("Encrypted String : %s\n", encryptedString);
    decrypt(encryptedString, key, decryptedString);
    printf("Decrypted String : %s\n", decryptedString);

    return 0;
}

/*
Output:
Enter the string : adityapandey
Enter the key : hello

Original String : adityapandey
Key : hello
Encrypted String : HHTEM4)4A7EB
Decrypted String : ADITYAPANDEY
*/

/*
Note:
1. Input string should be given without any space. 
2. Output will be in upper case only.
*/