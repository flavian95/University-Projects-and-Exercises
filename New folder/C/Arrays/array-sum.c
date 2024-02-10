#include <stdio.h>

int main()
{
    int limit, i, array[50], sum = 0;

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &array[i]);
        sum = sum + array[i];
    }

    printf("%d", sum);

    return 0;
}