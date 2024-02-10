#include <stdio.h>

int appearanceCount(int nr, int searchNr);
int digitsSum(int nr);
int maxDigit(int nr);
void palindromeNr(int nr);

int main()
{
    int nr, searchNr;

    printf("Insert a nr: ");
    scanf("%d", &nr);

    printf("Insert a nr which appearance count willl be calculated: ");
    scanf("%d", &searchNr);

    printf("Sum of the digits: %d\n", digitsSum(nr));
    printf("Appearance count of given nr: %d\n", appearanceCount(nr, searchNr));

    printf("The max digit in nr is: %d\n", maxDigit(nr));
    palindromeNr(nr);
}

void palindromeNr(int nr)
{
    int digit, digitsCount = 0, i, j;
    int digitsArray[nr];

    while (nr > 0)
    {
        digit = nr % 10;
        nr /= 10;

        digitsArray[digitsCount] = digit;
        digitsCount++;
    }

    for (i = 0, j = digitsCount - 1; i < j; i++, j--)
    {
        if (digitsArray[i] != digitsArray[j])
        {
            printf("Not a palindrome\n");
            return;
        }
    }

    printf("Palindrome\n");
}

int maxDigit(int nr)
{
    int digit, max = 0;

    while (nr > 0)
    {
        digit = nr % 10;
        nr /= 10;

        if (max < digit)
        {
            max = digit;
        }
    }

    return max;
}

int appearanceCount(int nr, int searchNr)
{
    int digit, searchCount = 0;

    while (nr > 0)
    {
        digit = nr % 10;
        nr /= 10;

        if (searchNr == digit)
        {
            searchCount++;
        }
    }

    return searchCount;
}

int digitsSum(int nr)
{
    int digit, sum = 0;

    while (nr > 0)
    {
        digit = nr % 10;
        nr /= 10;

        sum += digit;
    }

    return sum;
}