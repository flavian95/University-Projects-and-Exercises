#include <stdio.h>

int main()
{
    int n, digit, smallestDigit = 9, position = -1;

    printf("Enter a positive integer: ");
    scanf("%d", &n);

    int digits[10];
    int index = 0;

    while (n > 0)
    {
        digit = n % 10;
        digits[index] = digit;
        index++;
        n /= 10;
    }

    for (int i = 0; i < index; i++)
    {
        if (digits[i] < smallestDigit)
        {
            smallestDigit = digits[i];
            position = i + 1;
        }
    }

    if (position != -1)
    {
        printf("Smallest digit: %d\n", smallestDigit);
        printf("Position in the number: %d\n", position);
    }
    else
    {
        printf("No digits found.\n");
    }

    return 0;
}
