#include <stdio.h>

int main()
{
    int w[2], v[50], i, n;

    printf("Enter the nr in the 1st array: ");
    for (i = 0; i < 2; i++)
    {
        scanf("%d", &w[i]);
    }

    printf("Enter the size of the 2nd array: ");
    scanf("%d", &n);

    printf("Enter the nr in the 2nd array: ");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &v[i]);
    }

    printf("%d %d\n", w[0], w[1]);

    for (i = w[1]; i >= w[0]; i--)
    {
        s[i] += i;
    }
    printf("\n");

    printf("%s\n", s);

    for (i = 0; i < n; i++)
    {
        printf("%d ", v[i]);
    }

    return 0;
}