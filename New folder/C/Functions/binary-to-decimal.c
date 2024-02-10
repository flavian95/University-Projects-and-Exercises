#include <stdio.h>

int binaryToDecimal(int binaryNumber);

int main()
{
    int binaryNumber;

    printf("Enter a binary number: ");
    scanf("%d", &binaryNumber);

    int decimalEquivalent = binaryToDecimal(binaryNumber);

    printf("The decimal equivalent of %d in base 2 is: %d\n", binaryNumber, decimalEquivalent);

    return 0;
}

int binaryToDecimal(int binaryNumber)
{
    int decimalNumber = 0, base = 1, remainder;

    while (binaryNumber > 0)
    {
        remainder = binaryNumber % 10;
        decimalNumber = decimalNumber + remainder * base;
        binaryNumber = binaryNumber / 10;
        base = base * 2;
    }

    return decimalNumber;
}
