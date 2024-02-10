#include <stdio.h>

int countDigitFrequency(int number, int digit)
{
    int count = 0;

    if (number < 0)
    {
        number = -number;
    }

    if (number == 0)
    {
        count = 1;
    }

    while (number > 0)
    {
        if (number % 10 == digit)
        {
            count++;
        }
        number /= 10;
    }

    return count;
}

int main()
{
    int number, digit;

    scanf("%d", &number);
    scanf("%d", &digit);

    int frequency = countDigitFrequency(number, digit);
    printf("The number %d have %d digits of %d.\n", number, frequency, digit);

    return 0;
}