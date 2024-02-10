#include <stdio.h>

int main()
{
    int nr, reversedNumber = 0, digit;

    scanf("%d", &nr);

    while (nr > 0)
    {
        digit = nr % 10;
        reversedNumber = reversedNumber * 10 + digit;
        nr = nr / 10;

        printf("%d\n", reversedNumber);
    }

    return 0;
}