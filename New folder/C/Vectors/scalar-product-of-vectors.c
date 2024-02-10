#include <stdio.h>
#include <stdlib.h>

int main()
{
    int limit, i, sum = 0, scalarProduct = 0;

    scanf("%d", &limit);

    int *firstVector = (int *)malloc(limit * sizeof(int));
    int *secondVector = (int *)malloc(limit * sizeof(int));

    if ((firstVector == NULL) || (secondVector == NULL))
    {
        printf("Memory allocation failed.\n");
        return 1;
    }

    for (i = 0; i < limit; i++)
    {
        scanf("%d ", &firstVector[i]);
    }

    for (i = 0; i < limit; i++)
    {
        scanf("%d ", &secondVector[i]);
    }

    for (i = 0; i < limit; i++)
    {
        sum = firstVector[i] * secondVector[i];
        scalarProduct += sum;
    }

    printf("The scalar product of vectors= %d", scalarProduct);

    free(firstVector);
    free(secondVector);

    return 0;
}