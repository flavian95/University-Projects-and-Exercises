#include <stdio.h>

int main()
{
    int nr, search, digit, count = 0, originalNr;

    scanf("%d %d", &nr, &search);

    originalNr = nr;

    if (nr < 0)
    {
        nr = nr * (-1);
    }

    if (nr == 0)
    {
        count = 1;
    }

    while (nr > 0)
    {
        digit = nr % 10;
        nr /= 10;

        if (digit == search)
        {
            count++;
        }
    }

    printf("The number %d have %d digits of %d.", originalNr, count, search);
}