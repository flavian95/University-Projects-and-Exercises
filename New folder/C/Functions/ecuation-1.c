#include <stdio.h>

int main()
{
    int n, i;
    float sum = 1;

    scanf("%d", &n);

    for (i = 1; i <= n; i++)
    {
        sum = sum + 1.0 / sum;
    }

    printf("%f", sum);
}