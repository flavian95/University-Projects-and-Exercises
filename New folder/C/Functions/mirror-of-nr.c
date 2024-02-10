#include <stdio.h>

int main()
{
    int nr, digit, flag = 0;

    scanf("%d", &nr);

    if (nr < 0)
    {
        nr = nr * (-1);
    }

    if (nr == 0)
    {
        printf("The mirroring of %d is 0.", nr);
        flag = 1;
    }

    if (flag == 0)
    {

        printf("The mirroring of %d is ", nr);
        while (nr > 0)
        {
            digit = nr % 10;
            nr /= 10;

            printf("%d", digit);
        }
        printf(".");
    }
}