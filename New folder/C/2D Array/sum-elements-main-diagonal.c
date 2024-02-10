#include <stdio.h>

int main()
{
    int array[50][50], limit, i, j, sum = 0;

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        for (j = 0; j < limit; j++)
        {
            scanf("%d", &array[i][j]);

            if (i == j)
            {
                sum += array[i][j];
            }
        }
    }

    printf("%d ", sum);

    return 0;
}
