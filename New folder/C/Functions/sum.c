#include <stdio.h>

int sum(int nr)
{
    int i, sum = 0;

    for (i = 0; i <= nr; i++)
    {
        sum += i;
    }

    return sum;
}

int main()
{
    int nr, theSum;

    scanf("%d", &nr);

    theSum = sum(nr);

    printf("The sum is %i\n", theSum);
}