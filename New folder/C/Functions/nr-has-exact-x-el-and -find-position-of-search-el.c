#include <stdio.h>

int main()
{
    int nr, searchNr, digit, originalNr, i, digitsArray[50], count = 0, index = 0, flag = 0;

    scanf("%d %d", &nr, &searchNr);

    originalNr = nr;

    while (nr > 0)
    {
        digit = nr % 10;
        nr /= 10;

        digitsArray[count] = digit;
        count++;
    }

    if (count != 4)
    {
        printf("The number 123 has not exaclty 4 digits.");
        flag = 1;
    }

    for (i = 0; i < count; i++)
    {
        if (digitsArray[i] == searchNr)
        {
            index = i;
            break;
        }
    }

    if ((index > 0) && (flag == 0))
    {

        printf("The first occurance of %d in the number %d is %d.", searchNr, originalNr, index);
    }

    if ((index == 0) && (flag == 0))
    {
        printf("The digit %d was not found in %d.", searchNr, originalNr);
    }
}