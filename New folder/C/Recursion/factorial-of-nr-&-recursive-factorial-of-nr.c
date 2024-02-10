#include <stdio.h>

int factorial(int limit)
{
    int i, factorial = 1;

    for (i = 1; i < limit; i++)
    {
        factorial *= i;
    }

    return factorial;
}

int recFactorial(int limit)
{
    if (limit == 0 || limit == 1)
    {
        return 1;
    }

    // Recursive case: multiply the current number with the factorial of (limit - 1)
    else
    {
        return limit * recFactorial(limit - 1);
    }
}

int main()
{
    int limit;

    printf("Input one natural number:\n");
    scanf("%d", &limit);

    int factorialNum = factorial(limit);
    int recursiveFacorial = recFactorial(limit);

    printf("Factorial %d! = %d\n", limit, factorialNum);

    printf("Recursive factorial %d! = %d\n", limit, recursiveFacorial);
}