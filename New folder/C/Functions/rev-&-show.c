#include <stdio.h>

int main()
{
    int num, originalNum, digit, reversedNum = 0, multiplier = 1;

    printf("Enter an integer: ");
    scanf("%d", &num);

    originalNum = num;

    // Count the number of digits to determine the multiplier
    while (num > 0)
    {
        num /= 10;
        multiplier *= 10;
    }

    num = originalNum; // Reset num to the original value

    printf("Transformed numbers:\n");

    while (1)
    {
        digit = num % 10;
        reversedNum = digit * multiplier / 10 + num / 10;

        printf("%d\n", reversedNum);

        if (reversedNum == originalNum)
        {
            printf("STOP\n");
            break;
        }

        num = reversedNum;
    }

    return 0;
}
