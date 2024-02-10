#include <stdio.h>

int main()
{
    int nr, occurenceNr, originalNr, digit = 0, count = 0;

    scanf("%d %d", &nr, &occurenceNr);

    originalNr = nr;

    while (nr > 0)
    {
        digit = nr % 10;
        nr /= 10;

        if (digit == occurenceNr)
        {
            count++;
        }
    }

    printf("Number of occurances  %d into %d is %d", occurenceNr, originalNr, count);
}