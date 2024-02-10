#include <stdio.h>

int productOfElements(int array[], int currentIndex, int limit)
{
    // Base case: if the currentIndex reaches the limit, return 1
    if (currentIndex == limit)
    {
        return 1;
    }

    // Recursive case: multiply the current element with the product of the rest of the elements
    return array[currentIndex] * productOfElements(array, currentIndex + 1, limit);
}

int main()
{
    int limit;

    printf("Enter the limit: ");
    scanf("%d", &limit);

    int array[50];

    printf("Enter %d elements:\n", limit);
    for (int i = 0; i < limit; i++)
    {
        scanf("%d", &array[i]);
    }

    // Call the recursive function to get the product of elements
    int product = productOfElements(array, 0, limit);

    // Display the result
    printf("Product of 1D-array elements is: %d\n", product);

    return 0;
}
