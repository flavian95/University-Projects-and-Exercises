#include <stdio.h>

int main()
{
    int limit, wagonTypeLimit, wagons[10], i, count = 0;

    scanf("%d %d", &limit, &wagonTypeLimit);

    for (i = 0; i < limit; i++)
    {
        scanf("%d", &wagons[i]);
    }

    for (i = 0; i < limit; i++)
    {
        count = 1; // Reset the count for each wagon

        // Check for consecutive wagons of the same type
        while (i < limit - 1 && wagons[i] == wagons[i + 1])
        {
            count++;
            i++;
        }

        // Display the message if more than k consecutive wagons of the same type
        if (count > wagonTypeLimit)
        {
            printf("%d wagons of class %d starting at %d\n", count, wagons[i], i - count + 2);
        }
    }

    return 0;
}
