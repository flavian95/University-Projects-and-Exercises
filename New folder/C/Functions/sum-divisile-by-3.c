#include <stdio.h>

int main()
{
    int limit, sum = 0, i;

    scanf("%d", &limit);

    for (i = 0; i <= limit; i++)
    {
        if (i % 3 == 0)
        {
            sum += i;
        }
    }

    printf("%d", sum);
}