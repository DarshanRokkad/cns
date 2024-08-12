#include <stdio.h>
#include <string.h>

void matrixMultiply( int mat1[], int mat2[][3], int result[])
{
    for (int i = 0; i < 3; i++)
    {
        result[i] = 0;
        for (int j = 0; j < 3; j++)
        {
            result[i] += (mat1[j] * mat2[i][j]);
        }
        result[i] %= 26;
    }
}

int main()
{
    char plaintext[20];
    printf("Enter plain text (up to 3 capital characters): ");
    scanf("%s", plaintext);

    int encryptionKey[3][3] = {{17, 17, 5}, {21, 18, 21}, {2, 2, 19}};
    int decryptionKey[3][3] = {{4, 9, 15}, {15, 17, 6}, {24, 0, 17}};

    int plaintextNum[3], ciphertextNum[3], decryptedNum[3];
    for (int i = 0; i < 3; i++)
    {
        plaintextNum[i] = plaintext[i] - 'A';
    }

    matrixMultiply(plaintextNum, encryptionKey, ciphertextNum);
    matrixMultiply(ciphertextNum, decryptionKey, decryptedNum);

    printf("Encrypted Text: ");
    for (int i = 0; i < 3; i++)
    {
        printf("%c", ciphertextNum[i] + 'A');
    }

    printf("\nDecrypted Text: ");
    for (int i = 0; i < 3; i++)
    {
        printf("%c", decryptedNum[i] + 'A');
    }
    printf("\n");

    return 0;
}

/*
Output:
Enter plain text (up to 3 capital characters): HIL
Encrypted Text: YCF
Decrypted Text: HIL
*/

// Note: Give only 3 UPPER CASE Character as input