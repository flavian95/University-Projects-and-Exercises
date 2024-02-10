#include <stdio.h>

int main()
{
    int nr, digit, count = 0, i, digitsArray[50], originalNr, foundEven = 0;

    scanf("%d", &nr);

    originalNr = nr;

    while (nr > 0)
    {
        digit = nr % 10;
        nr /= 10;

        digitsArray[count] = digit;
        count++;
    }

    printf("The number made up of his even numbers %d is ", originalNr);
    for (i = count - 1; i >= 0; i--)
    {
        if (digitsArray[i] % 2 == 0)
        {
            printf("%d", digitsArray[i]);
            foundEven = 1;
        }
    }

    if (!foundEven)
        printf("0");

    printf(".");

    return 0;
}
