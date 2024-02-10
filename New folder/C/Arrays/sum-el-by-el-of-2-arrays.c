#include <stdio.h>

int main()
{
    int limit, sumLimit, i, sum = 0, firstArray[50], secondArray[50];

    scanf("%d %d", &limit, &sumLimit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d ", &firstArray[i]);
    }

    for (i = 0; i < limit; i++)
    {
        scanf("%d ", &secondArray[i]);
    }

    for (i = 0; i < sumLimit; i++)
    {
        sum = firstArray[i] + secondArray[i];
        printf("%d ", sum);
    }

    return 0;
}