#include <stdio.h>

int main()
{
    int limit, i, j;

    scanf("%d", &limit);

    int arr[limit][limit];

    printf("Enter the elements of the quadratic 2D array:\n");
    for (i = 0; i < limit; i++)
    {
        for (j = 0; j < limit; j++)
        {
            scanf("%d", &arr[i][j]);
        }
    }

    // Declare and initialize the 1D array to store maximum elements
    int maxElements[limit];

    // Determine the maximum element on each line and store in the 1D array
    for (i = 0; i < limit; i++)
    {
        int max = arr[i][0];
        for (j = 1; j < limit; j++)
        {
            if (arr[i][j] > max)
            {
                max = arr[i][j];
            }
        }
        maxElements[i] = max;
    }

    // Display the contents of the 1D array
    for (i = 0; i < limit; i++)
    {
        printf("%d ", maxElements[i]);
    }

    return 0;
}
