#include <stdio.h>

int main()
{
    int nr, digit, i, addedNrtoEnd;
    int digitsCount[10];

    printf("Enter an integer: ");
    scanf("%d", &nr);

    i = 0;
    while (nr > 0)
    {
        digit = nr % 10;
        digitsCount[i] = digit;
        i++;
        nr /= 10;
    }

    for (int j = i - 1; j >= 0; j--)
    {
        printf("%d ", digitsCount[j] + 90);
    }
    printf("\n");

    return 0;
}
