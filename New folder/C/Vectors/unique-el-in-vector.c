#include <stdio.h>
#include <stdlib.h>

int main()
{
    int limit, i, j;

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

    printf("The unique elements found in the vector are: \n");
    for (i = 0; i < limit; i++)
    {
        int isUnique = 1;
        for (j = 0; j < limit; j++)
        {
            if (i != j && vector[i] == vector[j])
            {
                isUnique = 0;
                break;
            }
        }

        if (isUnique)
        {
            printf("%d ", vector[i]);
        }
    }

    free(vector);

    return 0;
}