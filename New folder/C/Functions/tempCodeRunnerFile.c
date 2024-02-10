#include <stdio.h>

int main()
{
    int n;
    float sum = 0, i;

    scanf("%d", &n);

    for (i = 0; i <= n; i++)
    {
        sum = sum + i +( 1 + 1/i);
    }

    printf("%f", sum);
}