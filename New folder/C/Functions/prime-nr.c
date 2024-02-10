#include <stdio.h>
#include <math.h>

int isPrime(int nr)
{
    if (nr <= 1)
    {
        return 1;
    }
    if (nr == 2)
    {
        return 0;
    }
    for (int i = 2; i <= sqrt(nr); i++)
    {
        if (nr % i == 0)
        {
            return 1;
        }
    }
    return 0;
}

int main()
{
    int nr, isNrPrime;

    scanf("%d", &nr);

    isNrPrime = isPrime(nr);

    if (isNrPrime == 0)
    {
        printf("The number %d is prime.", nr);
    }

    else
    {
        printf("The number %d is not prime.", nr);
    }
    return 0;
}