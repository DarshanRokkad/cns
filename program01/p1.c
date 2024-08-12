#include <stdio.h>
int main()
{
    char str[] = "Hello world";
    printf("Original string: %s\n", str);

    printf("\nPerforming bitwise AND with 127:\n");
    for (int i = 0; str[i] != '\0'; i++)
    {
        printf("%c ",(str[i] & 127));
    }

    printf("\nPerforming bitwise OR with 127:\n");
    for (int i = 0; str[i] != '\0'; i++)
    {
        printf("%c ", (str[i] | 127));
    }

    printf("\nPerforming bitwise XOR with 127:\n");
    for (int i = 0; str[i] != '\0'; i++)
    {
        printf("%c ", (str[i] ^ 127));
    }

    return 0;
}

/*
Output:

Original string: Hello world

Performing bitwise AND with 127:
H e l l o   w o r l d 
Performing bitwise OR with 127:

Performing bitwise XOR with 127:
‼  ‼ ‼ ► _ ►
*/

// Note: no output for 'or' gate