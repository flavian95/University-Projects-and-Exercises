#include <stdio.h>

int main()
{
    int nr, digit, max = 0, originalNr;

    scanf("%d", &nr);

    originalNr = nr;

    if (nr < 0)
    {
        nr = nr * (-1);
    }

    while (nr > 0)
    {
        digit = nr % 10;
        nr /= 10;

        if (max < digit)
        {
            max = digit;
        }
    }

    printf("The number %d has %d greatest digit.", originalNr, max);
}