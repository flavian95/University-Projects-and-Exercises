#include <stdio.h>

int main()
{
    int i, n, v[10], w[10], sum;

    printf("Enter array size: ");
    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        scanf("%d ", &v[i]);
    }

    for (i = 0; i < n; i++)
    {
        scanf("%d ", &w[i]);
    }

    for (i = 0; i < n; i++)
    {
        sum = v[i] * w[i];
    }

    printf("The scalar product of vectors: \n");
    for (i = 0; i < n; i++)
    {
        printf("%d ", sum[i]);
    }
}