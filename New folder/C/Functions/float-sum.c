#include <stdio.h>

int main()
{
    float nr, sum = 0, i;

    scanf("%f", &nr);

    for (i = 0; i <= nr; i++)
    {
        sum += i / (i + 1);
    }

    printf("%.2f ", sum);
}