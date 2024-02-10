#include <stdio.h>
#include <math.h>

void displayMatrix(int N)
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            printf("%d ", abs(i - j));
        }
        printf("\n");
    }
}

int main()
{
    int N;

    printf("Enter the value of N: ");
    scanf("%d", &N);

    displayMatrix(N);

    return 0;
}
