#include <stdio.h>

int main()
{
    int array[50], limit, i, sum = 1;

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &array[i]);

        sum *= array[i];
    }

    printf("Product 1D-array elements is: %d", sum);
}