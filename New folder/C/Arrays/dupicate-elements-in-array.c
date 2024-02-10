#include <stdio.h>

int main()
{
    int limit, i, j, array[50], count = 0;

    printf("Enter the limit of the array: ");
    scanf("%d", &limit);

    printf("Array elements: ");
    for (i = 0; i < limit; i++)
    {
        scanf("%d ", &array[i]);
    }

    for (i = 0; i < limit - 1; i++)
    {
        for (j = i + 1; j < limit; j++)
        {
            if (array[i] == array[j])
            {
                array[j] = -1;
                count++;
                break;
            }
        }
    }

    printf("The total number of duplicate elements found in the array is: %d\n", count);

    return 0;
}
