#include <stdio.h>

int main()
{
    int array[100];
    int arraySize = 0; // Variable to keep track of the size of the array

    printf("Enter the elements of the array (up to the first 0):\n");
    int nr;

    while (scanf("%d", &nr) == 1 && nr != 0)
    {
        array[arraySize] = nr;
        arraySize++;
    }

    printf("Vector is:\n");
    for (int i = 0; i < arraySize; i++)
    {
        printf("%d ", array[i]);
    }

    printf("\n");

    // Calculate and display the maximum element of the array
    if (arraySize > 0)
    {
        int maxElement = array[0];
        for (int i = 1; i < arraySize; i++)
        {
            if (array[i] > maxElement)
            {
                maxElement = array[i];
            }
        }
        printf("The maximum element of the vector is: %d\n", maxElement);
    }
    else
    {
        printf("The vector is empty.\n");
    }

    return 0;
}
