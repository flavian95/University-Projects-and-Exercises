#include <stdio.h>

int main()
{
    int limit, i, array[50], j, indexSumNr;

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &array[i]);
    }

    scanf("%d", &indexSumNr);

    for (i = 0; i < limit; i++)
    {
        printf("%d  ", array[i]);
    }

    printf("\nThe indices of the values that sum up to %d\n", indexSumNr);

    for (i = 0; i < limit; i++)
    {
        for (j = i + 1; j < limit; j++)
        {
            if ((array[j] + array[i]) == indexSumNr)
            {
                printf("%d %d", i, j);
                break;
            }
        }
    }
}