#include <stdio.h>

void displayPattern(int N)
{
    for (int i = 0; i < N; i++)
    {
        for (int space = 0; space < N - i - 1; space++)
        {
            printf("  ");
        }

        for (int j = 0; j <= i; j++)
        {
            // Calculate the ASCII value for the letter ('A' + j)
            char letter = 'A' + j;
            printf("%c ", letter);
        }

        // Print letters for the current row in reverse order (excluding the first letter)
        for (int j = i - 1; j >= 0; j--)
        {
            // Calculate the ASCII value for the letter ('A' + j)
            char letter = 'A' + j;
            printf("%c ", letter);
        }

        printf("\n");
    }
}

int main()
{
    int N;

    printf("Enter the value of N: ");
    scanf("%d", &N);

    displayPattern(N);

    return 0;
}
