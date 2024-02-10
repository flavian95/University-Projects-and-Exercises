#include <stdio.h>

int main()
{
    int v[50], n, i, maxNr = 0;
    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        scanf("%d", &v[i]);

        if (v[i] % n == 0)
        {
            while (maxNr < v[i])
            {
                maxNr = v[i];
            }
        }
    }

    printf("The greatest number devided by %d is %d.", n, maxNr);
}