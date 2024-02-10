#include <stdio.h>

int main()
{
    int nr, i, sum = 1;

    scanf("%d", &nr);

    for (i = 1; i <= nr; i++)
    {
        if (nr % i == 0)
        {
            sum *= i;
        }
    }

    printf("%d ", sum);
}