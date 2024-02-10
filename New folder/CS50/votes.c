#include <stdio.h>
#include <string.h>

int main()
{
    int n, i, j, maxCount = 0, count;
    char v[10][100];
    char mostFrequent[100] = {0};

    printf("Number of voters: ");
    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        printf("Vote: ");
        scanf("%s", v[i]);
    }

    for (i = 0; i < n; i++)
    {
        count = 1;

        for (j = i + 1; j < n; j++)
        {
            if (strcmp(v[i], v[j]) == 0)
            {
                count++;
            }
        }

        if (count > maxCount)
        {
            maxCount = count;
            strcpy(mostFrequent, v[i]);
        }
    }

    if (maxCount > 1)
    {
        printf("Most frequent: %s\n", mostFrequent);
    }
    else
    {
        printf("No name repeated.\n");
    }

    return 0;
}