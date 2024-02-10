#include <stdio.h>
#include <stdbool.h>

void displayPositiveNrOfArray(int limit, int array[50]);
void printPositiveNrPosition(int limit, int array[50]);
void printOddNr(int limit, int array[50]);
void revOrderArray(int limit, int array[50]);
void arithmeticProgression(int limit, int array[50]);
void geometricProgression(int limit, int array[50]);
void printSecondArray(int limit, int secondArray[50]);
void scalarProduct2Vectors(int limit, int array[50], int secondArray[50]);
void arithemticMean(int limit, int array[50]);
void nrAppearanceMaxNr(int limit, int array[50]);
void lastIndexGivenNr(int limit, int array[50], int searchEl);

int main()
{
    int limit, i, array[50], secondArray[50], searchEl;

    printf("Insert the limit: ");
    scanf("%d", &limit);

    printf("Insert the nr in the first array: \n");
    for (i = 0; i < limit; i++)
    {
        scanf("%d", &array[i]);
    }

    printf("Insert the nr in the second array: \n");
    for (i = 0; i < limit; i++)
    {
        scanf("%d", &secondArray[i]);
    }

    printf("Insert the nr which last index will be shown: ");
    scanf("%d", &searchEl);

    printPositiveNrPosition(limit, array);
    displayPositiveNrOfArray(limit, array);
    printOddNr(limit, array);
    revOrderArray(limit, array);
    arithmeticProgression(limit, array);
    geometricProgression(limit, array);
    printSecondArray(limit, secondArray);
    scalarProduct2Vectors(limit, array, secondArray);
    arithemticMean(limit, array);
    nrAppearanceMaxNr(limit, array);
    lastIndexGivenNr(limit, array, searchEl);

    return 0;
}

void lastIndexGivenNr(int limit, int array[50], int searchEl)
{
    int i, lastIndex = 0;

    for (i = 0; i < limit; i++)
    {
        if (array[i] == searchEl)
        {
            lastIndex = i;
        }
    }

    printf("Last index of the given nr is: %d", lastIndex);
}

void nrAppearanceMaxNr(int limit, int array[50])
{
    int i, max = 0, maxNrCount = 0;

    for (i = 0; i < limit; i++)
    {
        if (max < array[i])
        {
            max = array[i];
        }
    }

    for (i = 0; i < limit; i++)
    {
        if (array[i] == max)
        {
            maxNrCount++;
        }
    }

    printf("The nr of appearaces of the max nr in the array: %d\n", maxNrCount);
}

void arithemticMean(int limit, int array[50])
{
    int i, arithmeticMeanCount = 0, sum = 0, arithmeticMean;

    for (i = 0; i < limit; i++)
    {
        sum += array[i];
        arithmeticMeanCount++;
    }

    arithmeticMean = sum / arithmeticMeanCount;

    printf("The arithmetic mean of the array is: %d\n", arithmeticMean);
}

void scalarProduct2Vectors(int limit, int array[50], int secondArray[50])
{
    int i, scalarProduct = 0;

    for (i = 0; i < limit; i++)
    {
        scalarProduct += array[i] * secondArray[i];
    }

    printf("The scalar product of the two arrays is: %d\n", scalarProduct);
}

void printSecondArray(int limit, int secondArray[50])
{
    int i;

    printf("The second array is: ");
    for (i = 0; i < limit; i++)
    {
        printf("%d ", secondArray[i]);
    }
    printf("\n");
}

void geometricProgression(int limit, int array[50])
{
    int i;
    bool isGeometric = true;

    if (limit <= 1)
    {
        printf("Insert a bigger limit to evaluate geometric progression.\n");
        return;
    }

    int commonDifference = (array[1] / array[0]);

    for (i = 1; i < limit - 1; i++)
    {
        if (((array[i + 1] / array[i])) != commonDifference)
        {
            isGeometric = false;
            break;
        }
    }

    if (isGeometric)
    {
        printf("Array is in a geometric progression.\n");
    }
    else
    {
        printf("Array is not in a geometric progression.\n");
    }
}

void arithmeticProgression(int limit, int array[50])
{
    int i;
    bool isArithmetic = true;

    if (limit <= 1)
    {
        printf("Insert a bigger limit to evaluate arithmetic progression.\n");
        return;
    }

    int commonDifference = array[1] - array[0];

    for (i = 1; i < limit - 1; i++)
    {
        if ((array[i + 1] - array[i]) != commonDifference)
        {
            isArithmetic = false;
            break;
        }
    }

    if (isArithmetic)
    {
        printf("Array is in an arithmetic progression.\n");
    }
    else
    {
        printf("Array is not in an arithmetic progression.\n");
    }
}

void revOrderArray(int limit, int array[50])
{
    int i;

    printf("The array in reverse order is: ");
    for (i = limit - 1; i >= 0; i--)
    {
        printf("%d ", array[i]);
    }
    printf("\n");
}

void printOddNr(int limit, int array[50])
{
    int i;

    printf("The odd nr in the array are: ");
    for (i = 0; i < limit; i++)
    {
        if (array[i] % 2 == 0)
        {
            printf("%d ", array[i]);
        }
    }
    printf("\n");
}

void printPositiveNrPosition(int limit, int array[50])
{
    int i;

    printf("The indexes of all positive nr are: ");
    for (i = 0; i < limit; i++)
    {
        if (array[i] > 0)
        {
            printf("%d ", i);
        }
    }
    printf("\n");
}

void displayPositiveNrOfArray(int limit, int array[50])
{
    int i;

    printf("The first array is: ");
    for (i = 0; i < limit; i++)
    {
        if (array[i] < 0)
        {
            array[i] *= (-1);
        }

        printf("%d ", array[i]);
    }
    printf("\n");
}