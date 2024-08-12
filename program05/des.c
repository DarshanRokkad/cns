#include<stdio.h>

// Initial permutation (IP) table
int IP[] = {2, 6, 3, 1, 4, 8, 5, 7};

// Inverse initial permutation (IP^-1) table
int IP_inverse[] = {4, 1, 3, 5, 7, 2, 8, 6};

// S-boxes
int S[4][4] = {
    {1, 0, 3, 2},
    {3, 2, 1, 0},
    {0, 2, 1, 3},
    {3, 1, 3, 2}
};

// Function to perform initial permutation and inverse initial permutation
int permutation(int num, int arr[]) {
    int result = 0;
    for (int i = 0; i < 8; i++) {
        result |= ((num >> (8 - arr[i])) & 1) << (7 - i);
    }
    return result;
}

int s_box_substitution(int value, int s_box[4][4]) {
    int row = ((value & 0b1000) >> 2) | (value & 0b0001);
    int col = (value & 0b0110) >> 1;
    return s_box[row][col];
}

int main() {
    int plaintext = 0b11010110;
    printf("Plain Text: %x\n", plaintext);

    int cipher_text = permutation(plaintext, IP);
    printf("Cipher Text: %x\n", cipher_text);

    // Example of S-box substitution
    int s_box_value = 0b1101; // Example value
    int s_box_result = s_box_substitution(s_box_value, S);
    printf("S-box result: %x\n", s_box_result);

    int decrypted_text = permutation(cipher_text, IP_inverse);
    printf("Decrypted Text: %x\n", decrypted_text);

    return 0;
}

/*
Output:
Plain Text: d6
Cipher Text: d9
S-box result: 3
Decrypted Text: d6
*/

// Note: Code is hard Coded i.e no user input