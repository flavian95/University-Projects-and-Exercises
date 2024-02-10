#include <stdio.h>

int findGCD(int num1, int num2)
{
    while (num2 != 0)
    {
        int temp = num2;
        num2 = num1 % num2;
        num1 = temp;
    }
    return num1;
}

int main()
{
    int firstNr, secondNr;

    scanf("%d %d", &firstNr, &secondNr);

    int GCD = findGCD(firstNr, secondNr);

    printf("GCD of %d and %d is %d\n", firstNr, secondNr, GCD);

    return 0;
}
