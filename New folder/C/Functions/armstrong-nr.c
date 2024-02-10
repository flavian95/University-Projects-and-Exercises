#include <stdio.h>
#include <math.h>

int isArmstrongNumber(int n);

int main()
{
    int n;

    scanf("%d", &n);

    if (isArmstrongNumber(n))
    {
        printf("%d is an Armstrong number.\n", n);
    }
    else
    {
        printf("%d is not an Armstrong number.\n", n);
    }

    return 0;
}

int isArmstrongNumber(int n)
{
    int originalN = n, numDigits = 0, digit, s = 0;

    while (originalN != 0)
    {
        originalN /= 10;
        numDigits++;
    }

    originalN = n;

    while (originalN > 0)
    {
        digit = originalN % 10;
        s += pow(digit, numDigits);
        originalN /= 10;
    }

    return n == s;
}