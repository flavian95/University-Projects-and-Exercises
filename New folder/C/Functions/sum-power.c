#include <stdio.h>

int sumPower(int limit)
{
    int i, sum = 0;

    for (i = 0; i <= limit; i++)
    {
        if (i % 2 == 0)
        {
            sum = sum - (i * i);
        }
        else
        {
            sum = sum + (i * i);
        }
    }

    return sum;
}

int main()
{
    int limit;

    scanf("%d", &limit);

    int sumNr = sumPower(limit);

    printf("%d", sumNr);
}