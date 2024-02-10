#include <stdio.h>

int main()
{
    int limit, i, array1[50], array2[50];

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d ", &array1[i]);
    }

    for (i = 0; i < limit; i++)
    {
        scanf("%d ", &array2[i]);
    }

    printf("The arrays summ: ");
    for (i = 0; i < limit; i++)
    {
        printf("%d ", array1[i] + array2[i]);
    }

    return 0;
}