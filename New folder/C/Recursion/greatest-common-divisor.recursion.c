#include <stdio.h>

int findGCDRecursive(int num1, int num2)
{
    if (num2 == 0)
    {
        return num1;
    }
    else
    {
        return findGCDRecursive(num2, num1 % num2);
    }
}

int main()
{
    int num1, num2;

    scanf("%d %d", &num1, &num2);

    int gcd = findGCDRecursive(num1, num2);

    printf("GCD of %d and %d is %d\n", num1, num2, gcd);

    return 0;
}
