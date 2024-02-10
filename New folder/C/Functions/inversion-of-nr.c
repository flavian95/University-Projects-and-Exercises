#include <stdio.h>

int main()
{
    int n, invNr = 0, temp;

    scanf("%d", &n);

    if (n < 0)
    {
        n = -n;
    }

    temp = n;

    while (n > 0)
    {
        invNr = invNr * 10 + n % 10;
        n = n / 10;
    }

    printf("The mirroring of %d is %d.", temp, invNr);
}