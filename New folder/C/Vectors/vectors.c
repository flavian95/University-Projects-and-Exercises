#include <stdio.h>
#include <stdlib.h>

int main()
{
    int limit, i;

    scanf("%d", &limit);

    // Allocate memory for the dynamic array
    int *vector = (int *)malloc(limit * sizeof(int));

    // Check if memory allocation was successful
    if (vector == NULL)
    {
        printf("Memory allocation failed.\n");
        return 1;
    }

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &vector[i]);
    }

    for (i = 0; i < limit; i++)
    {
        printf("%d ", vector[i]);
    }

    free(vector);

    return 0;
}
