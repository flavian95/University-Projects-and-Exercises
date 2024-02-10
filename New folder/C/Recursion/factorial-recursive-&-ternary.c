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

    else
    {
        return limit * recFactorial(limit - 1);
    }
}

int recFactorialTernaryOp(int limit)
{
    return (limit == 0 || limit == 1) ? 1 : limit * recFactorial(limit - 1);
}

int main()
{
    int limit;

    printf("Input one natural number:\n");
    scanf("%d", &limit);

    int factorialNum = factorial(limit);
    int recursiveFactorial = recFactorial(limit);
    int recursiveFactorialOp = recFactorialTernaryOp(limit);

    printf("Factorial %d! = %d\n", limit, factorialNum);

    printf("Recursive factorial %d! = %d\n", limit, recursiveFactorial);

    printf("Recursive factorial op %d! = %d\n", limit, recursiveFactorialOp);
}