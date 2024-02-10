#include <stdio.h>

int display(int n);

int main()
{
    int n;
    scanf("%d", &n);

    int displayNr = display(n);

    printf("%d", displayNr);
}

int display(int n)
{
    int i;

    for (i = 0; i < n; i++)
    {
        printf("%d ", i);
    }

    return i;
}