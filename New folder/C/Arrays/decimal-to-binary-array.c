#include <stdio.h>

int main()
{
    int v[50], i, n, j;

    scanf("%d", &n);

    for (i = 0; n > 0; i++)
    {
        v[i] = n % 2;
        n = n / 2;
    }

    printf("Binary representation: ");
    for (j = i - 1; j >= 0; j--)
    {
        printf("%d", v[j]);
    }

    return 0;
}
