#include <stdio.h>

int main()
{
    int i, j, limit;

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        for (j = 0; j < limit; j++)
        {
            scanf("%d", &array[i][j]);
        }
    }

    return 0;
}