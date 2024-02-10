#include <stdio.h>

int main()
{
    int limit, i, array[50];
    float arithmeticMean, over5Sum = 0;

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &array[i]);

        if (array[i] >= 5)
        {
            over5Sum += array[i];
        }
    }

    arithmeticMean = over5Sum / limit;

    printf("The averrage is %.2f", arithmeticMean);
}