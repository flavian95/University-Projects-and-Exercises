#include <stdio.h>

int main()
{
    int limit, i, j, array[50], count = 0;

    printf("Enter the limit: ");
    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &array[i]);
    }

    printf("The non-duplicated items are: ");
    for (i = 0; i < limit; i++)
    {
        int isDuplicated = 0;
        for (j = 0; j < i; j++)
        {
            if (array[i] == array[j])
            {
                isDuplicated = 1;
                break;
            }
        }
        if (!isDuplicated)
        {
            printf("%d ", array[i]);
            count++;
        }
    }

    printf("\nThe total count of non-duplicated items is: %d\n", count);

    return 0;
}
