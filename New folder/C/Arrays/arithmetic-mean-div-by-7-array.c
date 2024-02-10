#include <stdio.h>

int main()
{
    int limit, i, array[50], count = 0;
    float arithmeticMean, sumDivBy7 = 0;

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &array[i]);

        if (array[i] % 7 == 0)
        {
            sumDivBy7 += array[i];
            count++;
        }
    }

    printf("The numbers divided by 7 are %d\n", count);

    if (count > 0)
    {
        arithmeticMean = sumDivBy7 / count;

        printf("The mean of the number is %.2f\n", arithmeticMean);
    }

    else
    {
        printf("There is no number divisible by 7!");
    }
}