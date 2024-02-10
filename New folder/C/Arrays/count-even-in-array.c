#include <stdio.h>

int main()
{
    int i, n, v[50], count = 0;

    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        scanf("%d", &v[i]);
    }

    for (i = 0; i < n; i++)
    {
        printf("%d ", v[i]);
    }
    printf("\n");

    for (i = 0; i < n; i++)
    {
        if (v[i] % 2 == 0)
        {
            count++;
        }
    }

    if (count == 0)
    {
        printf("There are no even number.");
    }
    else
    {
        printf("There are %d even numbers. ", count);
    }
}