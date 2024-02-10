#include <stdio.h>

int multiplicity(int firstNr, int secondNr)
{
    int multiplicity = 0;

    while (firstNr % secondNr == 0)
    {
        firstNr /= secondNr;
        multiplicity++;
    }

    return multiplicity;
}

int isPrime(int secondNr)
{
    int i, primeSum = 0;

    for (i = 1; i < secondNr; i++)
    {
        if (secondNr % i == 0)
        {
            primeSum += i;
        }
    }

    if (primeSum == 1)
    {
        return 1;
    }

    else
    {
        return 0;
    }
}

int main()
{
    int firstNr, secondNr;

    printf("Enter the values for firstNr and secondNr: ");
    scanf("%d %d", &firstNr, &secondNr);

    int multiplicityNr = multiplicity(firstNr, secondNr);
    int primeNr = isPrime(secondNr);

    if (primeNr == 1)
    {
        printf("Multiplicity order of %d in %d is: %d", secondNr, firstNr, multiplicityNr);
    }
    if (primeNr == 0)
    {
        printf("%d is not a prime nr", secondNr);
    }

    return 0;
}