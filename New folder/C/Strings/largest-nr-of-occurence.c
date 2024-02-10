#include <stdio.h>
#include <string.h>
#include <ctype.h>

int countDistinctDigits(char s[100])
{
    int i, j, count = 0, maxCount = 0;

    for (i = 0; i < strlen(s); i++)
    {
        if (isdigit(s[i]))
        {
            count = 1; // Initialize count for the current digit
            // Check the consecutive characters to count the occurrences of the current digit
            for (j = i + 1; j < strlen(s); j++)
            {
                if (s[i] == s[j])
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
            // Update maxCount if the current count is greater
            if (count > maxCount)
            {
                maxCount = count;
            }
        }
    }

    return maxCount;
}

int main()
{
    char s[100];

    printf("Enter a string: ");
    scanf("%s", s);

    int result = countDistinctDigits(s);

    printf("The highest number of appearances is %d\n", result);

    return 0;
}
