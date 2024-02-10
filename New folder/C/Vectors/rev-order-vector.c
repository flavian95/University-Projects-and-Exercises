#include <stdio.h>
#include <stdlib.h>

int main()
{
    int limit, i;

    scanf("%d", &limit);

    int *vector = (int *)malloc(limit * sizeof(int));

    if (vector == NULL)
    {
        printf("Memory allocation failed.\n");
        return 1;
    }

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &vector[i]);
    }

    for (i = limit - 1; i >= 0; i--)
    {
        printf("%d ", vector[i]);
    }

    free(vector);

    return 0;
}