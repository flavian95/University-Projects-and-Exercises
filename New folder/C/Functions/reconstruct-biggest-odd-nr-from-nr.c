#include <stdio.h>

int main()
{
    int nr, digit;
    int digitsCount[10] = {0};

    printf("Enter a number: ");
    scanf("%d", &nr);

    while (nr > 0)
    {
        digit = nr % 10;
        digitsCount[digit]++;
        nr /= 10;
    }

    printf("Largest odd number: ");
    for (int i = 9; i >= 1; i -= 2)
    {
        while (digitsCount[i] > 0)
        {
            printf("%d", i);
            digitsCount[i]--;
        }
    }

    return 0;
}
