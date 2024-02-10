#include <stdio.h>

int main()
{
    int limit, i, array[50], algorithmArray;

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

    printf("%d,", array[0]);

    for (i = 1; i < limit - 1; i++)
    {
        algorithmArray = ((array[i - 1] + array[i] + array[i + 1]) / 3);

        printf("%d,", algorithmArray);
    }

    printf("%d", array[limit - 1]);

    return 0;
}