#include <stdio.h>

int main()
{
    int num, i, sum, perfectCount = 0;

    while (1)
    {
        scanf("%d", &num);

        if (num == 0)
        {
            break;
        }

        sum = 0;

        for (i = 1; i < num; i++)
        {
            if (num % i == 0)
            {
                sum += i;
            }
        }

        if (num == sum)
        {
            perfectCount++;
        }
    }

    printf("there are %d perfect numbers\n", perfectCount);

    return 0;
}