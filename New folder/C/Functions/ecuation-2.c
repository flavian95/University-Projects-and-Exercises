#include <stdio.h>

int digits_sum(int n);

int main()
{
    int n, originalN;

    scanf("%d", &n);

    originalN = n;

    int digitSum = digits_sum(n);

    printf("Sum of digits %d = %d", originalN, digitSum);
}

int digits_sum(int n)
{
    int sum = 0;

    while (n != 0)
    {
        sum = sum + n % 10;
        n = n / 10;
    }

    return sum;
}