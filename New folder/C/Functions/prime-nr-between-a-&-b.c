#include <stdio.h>
#include <math.h>

int isPrime(int n)
{
    if (n <= 1)
    {
        return 0;
    }
    if (n == 2)
    {
        return 1;
    }
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (n % i == 0)
        {
            return 0;
        }
    }
    return 1;
}

int main()
{
    int a, b, i;

    scanf("%d", &a);
    scanf("%d", &b);

    if (a > b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    int foundPrime = 0;
    for (i = a; i <= b; i++)
    {
        if (isPrime(i))
        {
            printf("%d ", i);
            foundPrime = 1;
        }
    }

    if (!foundPrime)
    {
        printf("No prime numbers found in the range.\n");
    }

    return 0;
}