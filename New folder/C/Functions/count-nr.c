#include <stdio.h>

int main()
{
    int i, nr, count = 0;

    scanf("%d", &nr);

    while (nr != 0)
    {
        count++;
        nr = nr / 10;
    }

    printf("The number has %d digits\n", count);

    return 0;
}
