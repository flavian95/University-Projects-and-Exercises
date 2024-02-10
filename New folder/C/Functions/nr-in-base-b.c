#include <stdio.h>

void decToBinary(int nr, int originalNr, int baseNr);

int main()
{
    int decimalNumber, originalNr, baseNr;

    scanf("%d %d", &decimalNumber, &baseNr);
    originalNr = decimalNumber;

    decToBinary(decimalNumber, originalNr, baseNr);

    return 0;
}

void decToBinary(int nr, int originalNr, int baseNr)
{

    if (nr == 0)
    {
        printf("Number is: 0\n");
        return;
    }

    int base[50];
    int i = 0;

    while (nr > 0)
    {
        base[i] = nr % baseNr;
        nr = nr / baseNr;
        i++;
    }

    printf("The number %d in base 2 is ", originalNr);
    for (int j = i - 1; j >= 0; j--)
    {
        printf("%d", base[j]);
    }

    printf("\n");
}