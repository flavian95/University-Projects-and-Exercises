#include <stdio.h>

int main()
{
    int nr, digit = 0, count = 0;

    scanf("%d", &nr);

    while (nr > 0)
    {
        digit = nr % 10;
        nr /= 10;

        if (digit % 3 == 0)
        {
            count++;
        }
    }

    printf("The number contains %d digits that divide by 3.", count);
}