#include <stdio.h>

int main()
{
    int limit, i, j, array[50];

    printf("Enter the limit: ");
    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &array[i]);
    }

    printf("The unique elements found in the array are: \n");
    for (i = 0; i < limit; i++)
    {
        int isUnique = 1;
        for (j = 0; j < limit; j++)
        {
            if (i != j && array[i] == array[j])
            {
                isUnique = 0;
                break;
            }
        }
        if (isUnique)
        {
            printf("%d ", array[i]);
        }
    }

    return 0;
}
