#include <stdio.h>

int main()
{
    int limit, i, arrayNr[50];

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &arrayNr[i]);
    }

    for (i = limit - 1; i >= 0; i--)
    {
        printf("%d ", arrayNr[i]);
    }

    return 0;
}