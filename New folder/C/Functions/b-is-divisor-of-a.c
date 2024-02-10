#include <stdio.h>

int main()
{
    int a, d;

    scanf("%d %d", &a, &d);

    if ((a == 0) || (d == 0))
    {
        printf("Impossible");
    }

    else
    {
        if (d % a == 0)
        {
            printf("%d is a divisor of %d", d, a);
        }

        else
        {
            printf("%d is not a divisor of %d", d, a);
        }
    }
}