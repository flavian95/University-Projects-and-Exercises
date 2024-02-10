#include <stdio.h>

int main()
{
    int limit, i, j;

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        for (j = 0; j < limit; j++)
        {
            // Calculate the minimum distance from the current position to the border
            int minDist = i < j ? i : j;
            minDist = minDist < limit - i - 1 ? minDist : limit - i - 1;
            minDist = minDist < limit - j - 1 ? minDist : limit - j - 1;

            // Print the value based on the minimum distance
            printf("%d ", limit - minDist);
        }
        printf("\n");
    }

    return 0;
}
