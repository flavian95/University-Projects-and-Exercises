#include <stdio.h>

void decToBinary(int nr, int originalNr);

int main()
{
    int decimalNumber, originalNr;

    scanf("%d", &decimalNumber);
    originalNr = decimalNumber;

    decToBinary(decimalNumber, originalNr);

    return 0;
}

void decToBinary(int nr, int originalNr)
{

    if (nr == 0)
    {
        printf("Binary: 0\n");
        return;
    }

    int binary[32];
    int i = 0;

    while (nr > 0)
    {
        binary[i] = nr % 2;
        nr = nr / 2;
        i++;
    }

    printf("The number %d in base 2 is ", originalNr);
    for (int j = i - 1; j >= 0; j--)
    {
        printf("%d", binary[j]);
    }

    printf("\n");
}
