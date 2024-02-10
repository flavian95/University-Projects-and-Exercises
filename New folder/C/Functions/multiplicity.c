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

int main()
{
    int firstNr, secondNr;

    printf("Enter the values for firstNr and secondNr: ");
    scanf("%d %d", &firstNr, &secondNr);

    int result = ord_mult(firstNr, secondNr);

    printf("Multiplicity order of %d in %d is: %d\n", secondNr, firstNr, result);

    return 0;
}
