#include <stdio.h>

int add(int a, int b)
{
    // Base case: If b is 0, return a
    if (b == 0)
    {
        return a;
    }
    else
    {
        // Recursive case: add 1 to a and decrement b
        return add(a + 1, b - 1);
    }
}

int main()
{
    int result = add(3, 5);
    printf("Result: %d\n", result);

    return 0;
}
