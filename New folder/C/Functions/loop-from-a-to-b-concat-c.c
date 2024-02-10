#include <stdio.h>

int main()
{
    int a, b, c, i, count = 0, composedNumber;

    scanf("%d %d %d", &a, &b, &c);

    a = a * 10;
    composedNumber = b * 10 + c;

    for (i = a; i <= composedNumber; i++)
    {
        count++;

        if (i % 10 <= c)
        {
            printf("%d ", i);
        }

        if (count % 10 <= 0)
        {
            printf("\n");
        }
    }
}