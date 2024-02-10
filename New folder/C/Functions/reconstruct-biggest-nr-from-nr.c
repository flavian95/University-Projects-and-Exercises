#include <stdio.h>

int main()
{
    int nr, digit;
    int digitsCount[10] = {0}; // Array to store the count of each digit

    printf("Enter a number: ");
    scanf("%d", &nr);

    // Count the occurrences of each digit
    while (nr > 0)
    {
        digit = nr % 10;
        digitsCount[digit]++;
        nr /= 10;
    }

    // Reconstruct the largest number by iterating in reverse order
    for (int i = 9; i >= 0; i--)
    {
        while (digitsCount[i] > 0)
        {
            printf("%d", i);
            digitsCount[i]--;
        }
    }

    return 0;
}
