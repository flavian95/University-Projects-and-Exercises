#include <stdio.h>

int main()
{
    int v[50], i, n, j, m;

    scanf("%d", &n);
    scanf("%d", &m);

    for (i = 0; n > 0; i++)
    {
        v[i] = n % m;
        n = n / m;
    }

    for (j = i - 1; j >= 0; j--)
    {
        printf("%d", v[j]);
    }

    return 0;
}