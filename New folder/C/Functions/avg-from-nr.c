#include <stdio.h>

int main()
{
    float digit, sum = 0, count = 0, avg;
    int nr;

    scanf("%d", &nr);

    if (nr < 0)
    {
        nr = nr * (-1);
    }

    while (nr > 0)
    {

        digit = nr % 10;
        nr /= 10;
        count++;

        sum += digit;
        avg = sum / count;
    }

    printf("The average of the digits is %f.", avg);
}