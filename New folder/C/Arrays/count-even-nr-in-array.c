#include <stdio.h>

int nr_even(int limit);

int main()
{
    int limit;

    scanf("%d", &limit);

    int arrayCount = nr_even(limit);

    printf("Array have %d even values", arrayCount);

    return 0;
}

int nr_even(int limit)
{
    int i, count = 0, array[50];

    for (i = 0; i < limit; i++)
    {
        scanf("%d ", &array[i]);
    }

    for (i = 0; i < limit; i++)
    {
        if (array[i] % 2 == 0)
        {
            count++;
        }
    }

    return count;
}