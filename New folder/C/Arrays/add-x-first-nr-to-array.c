#include <stdio.h>

int main()
{
    int limit, i, array[50];

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d ", &array[i]);
    }

    for (i = 0; i < limit; i++)
    {
        printf("%d,", array[i]);
    }
    printf("\n");

    for (i = 0; i < limit; i++)
    {
        if (array[i] < 10)
        {
            printf("%d,", array[i] + 90);
        }

        if (array[i] >= 10)
        {
            printf("%d,", array[i] + 900);
        }
    }

    return 0;
}