#include <stdio.h>

int main()
{
    int v[50], i, n, count = 1, maxCount = 1;

    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        scanf("%d", &v[i]);
    }

    for (i = 0; i < n; i++)
    {
        printf("%d ", v[i]);
    }

    for (i = 0; i < n - 1; i++)
    {
        while (i < n - 1 && v[i] == v[i + 1])
        {
            count++;
            i++;
        }

        if (count > maxCount)
        {
            maxCount = count;
        }
    }

    printf("Maximum consecutive count: %d", maxCount);

    return 0;
}
