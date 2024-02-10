#include <stdio.h>

void divisorsOfNr(int firstNr);
void perfectNr(int firstNr);
void isPrime(int firstNr);
int GCD(int firstNr, int secondNr);

int main()
{
    int firstNr, secondNr;

    scanf("%d %d", &firstNr, &secondNr);

    divisorsOfNr(firstNr);
    printf("\n");

    perfectNr(firstNr);
    printf("\n");

    isPrime(firstNr);
    printf("\n");

    int GreatestCD = GCD(firstNr, secondNr);
    printf("The GCD is %d ", GreatestCD);
}

int GCD(int firstNr, int secondNr)
{
    if (secondNr == 0)
    {
        return firstNr;
    }
    else
    {
        return GCD(secondNr, firstNr % secondNr);
    }
}

void isPrime(int firstNr)
{
    int i, primeSum = 0;

    for (i = 1; i < firstNr; i++)
    {
        if (firstNr % i == 0)
        {
            primeSum += i;
        }
    }

    if (primeSum == 1)
    {
        printf("The nr %d is a prime nr", firstNr);
    }

    else
    {
        printf("The nr %d is not a prime nr", firstNr);
    }
}

void perfectNr(int firstNr)
{
    int i, perfectNrSum = 0;

    for (i = 1; i < firstNr; i++)
    {
        if (firstNr % i == 0)
        {
            perfectNrSum += i;
        }
    }

    if (perfectNrSum == firstNr)
    {
        printf("The nr %d is a perfect nr", firstNr);
    }

    else
    {
        printf("The nr %d is not a perfect nr", firstNr);
    }
}

void divisorsOfNr(int firstNr)
{
    int i;

    printf("The divisors of the first nr are: ");
    for (i = 1; i <= firstNr; i++)
    {
        if (firstNr % i == 0)
        {
            printf("%d ", i);
        }
    }
}