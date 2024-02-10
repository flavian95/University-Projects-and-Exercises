#include <stdio.h>

int main()
{
    int v[50][50], i, n, j;

    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            scanf("%d", &v[i][j]);
        }
    }

    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            printf("%d ", v[i][j]);
        }
        printf("\n");
    }

    for (i = 0; i < n; i++)
    {
        int max_in_row = v[i][0];

        for (j = 1; j < n; j++)
        {
            if (max_in_row < v[i][j])
            {
                max_in_row = v[i][j];
            }
        }

        printf("%d ", max_in_row);
    }

    return 0;
}