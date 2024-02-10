#include <stdio.h>

int main()
{
    int firstNr, secondNr, i, j, firstArrayCount = 0, secondArrayCount = 0, max = 0;

    scanf("%d %d", &firstNr, &secondNr);

    int firstArray[firstNr];
    int secondArray[secondNr];

    for (i = 1; i <= firstNr; i++)
    {
        if (firstNr % i == 0)
        {
            firstArray[firstArrayCount] = i;
            firstArrayCount++;
        }
    }

    for (i = 1; i <= secondNr; i++)
    {
        if (secondNr % i == 0)
        {
            secondArray[secondArrayCount] = i;
            secondArrayCount++;
        }
    }

    for (i = 0; i < firstArrayCount; i++)
    {
        for (j = 0; j < secondArrayCount; j++)
        {
            if (firstArray[i] == secondArray[j])
            {

                if (max < firstArray[i])
                {
                    max = firstArray[i];
                }

                break;
            }
        }
    }

    printf("GCD of %d and %d is% d", firstNr, secondNr, max);

    return 0;
}