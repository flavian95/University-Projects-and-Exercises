#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int main()
{
    char str[50];

    printf("Plaintext: ");

    fgets(str, sizeof(str), stdin);
    str[strcspn(str, "\n")] = 0;

    int num = atoi(str);

    if ((num > 0) || strlen(str) > 0)
    {
        srand(time(NULL));
        int randomNumber = (rand() % 26) + 1;

        printf("Ciphertext: ");

        for (int i = 0; i < strlen(str); i++)
        {
            int ascii = str[i] + randomNumber;
            char convertedChar = (char)ascii;

            printf("%c", convertedChar);

            if (i < strlen(str) - 1)
            {
                printf(" ");
            }
        }
        printf("\n");
    }

    else
    {
        printf("Error\n");

        return 1;
    }

    return 0;
}