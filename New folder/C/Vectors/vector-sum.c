#include <stdio.h>
#include <stdlib.h>

int main()
{
    int limit, i, sum = 0;

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
        sum += vector[i];
    }

    printf("Sum is: %d", sum);

    free(vector);

    return 0;
}