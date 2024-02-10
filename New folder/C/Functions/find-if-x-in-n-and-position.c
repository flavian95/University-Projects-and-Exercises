#include <stdio.h>

int main()
{
    int i, n, digit, x, flag = 0, count = 0, m;

    printf("Insert first nr: ");
    scanf("%d", &n);

    m = n;

    printf("Insert second nr: ");
    scanf("%d", &x);

    for (i = 0; i <= n && flag != 1; i++)
    {
        digit = n % 10;
        n = n / 10;

        if (digit == x)
        {
            flag = 1;
        }
        count++;
    }

    if (flag == 1)
    {
        printf("The nr %d at position %d is present in the nr %d", x, count, m);
    }

    else
    {
        printf("The nr %d is not present in %d", x, m);
    }
}