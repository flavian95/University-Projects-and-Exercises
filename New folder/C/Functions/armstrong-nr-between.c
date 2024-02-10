#include <stdio.h>
#include <math.h>

int isArmstrongNumber(int n);

int main()
{
    int a, b;

    scanf("%d %d", &a, &b);

    printf("Armstrong numbers between %d and %d are:\n", a, b);

    for (int i = a + 1; i <= b; i++)
    {
        if (isArmstrongNumber(i))
        {
            printf("%d is an Armstrong number.\n", i);
        }
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