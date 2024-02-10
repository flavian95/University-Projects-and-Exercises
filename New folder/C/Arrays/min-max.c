#include <stdio.h>

int main()
{
    int limit, i;
    float array[50], min = 0, max = 0;

    scanf("%d", &limit);

    for (i = 0; i < limit; i++)
    {
        scanf("%f ", &array[i]);

        if (min > array[i])
        {
            min = array[i];
        }

        if (max < array[i])
        {
            max = array[i];
        }
    }

    printf("Those %d numbers are between [%f, %f].", limit, min, max);
}