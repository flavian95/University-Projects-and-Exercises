#include <stdio.h>

int main()
{
    int i, n, v[50], w[50], z[50];

    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        scanf("%d ", &v[i]);
    }

    for (i = 0; i < n; i++)
    {
        scanf("%d", &w[i]);
    }

    for (i = 0; i < n; i++)
    {
        z[i] = v[i] + w[i];
        printf("%d ", z[i]);
    }
    printf("\n");

    return 0;
}