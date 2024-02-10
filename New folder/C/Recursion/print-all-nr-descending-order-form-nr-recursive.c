#include <stdio.h>

void descOrder(int nr)
{
    int i;

    for (i = nr; i >= 0; i--)
    {
        printf("%d ", i);
    }
}

void descOrderRecursive(int nr)
{
    if (nr == 0)
    {
        printf("%d ", nr);
    }

    else
    {
        printf("%d ", nr);
        descOrderRecursive(nr - 1);
    }
}

int main()
{
    int nr;

    scanf("%d", &nr);

    descOrderRecursive(nr);
}