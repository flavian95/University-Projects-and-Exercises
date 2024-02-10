#include <stdio.h>

void displayPyramid(int N)
{
    for (int i = 0; i < N; i++)
    {
        for (int space = 0; space < N - i - 1; space++)
        {
            printf("  ");
        }

        for (int j = 0; j < 2 * i + 1; j++)
        {
            printf("# ");
        }

        printf("\n");
    }
}

int main()
{
    int N;

    printf("Enter the value of N: ");
    scanf("%d", &N);

    displayPyramid(N);

    return 0;
}