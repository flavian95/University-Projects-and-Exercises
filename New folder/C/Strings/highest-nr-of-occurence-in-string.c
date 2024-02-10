#include <stdio.h>
#include <string.h>
#include <ctype.h>

int countDistinctDigits(const char *s)
{
    int count = 0;
    int maxCount = 0;

    for (int i = 0; i < strlen(s); i++)
    {
        if (isdigit(s[i]))
        {
            count = 1;
            while (isdigit(s[i]) && s[i] == s[i + 1])
            {
                count++;
                i++;
            }
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
    scanf("%99s", s);

    int result = countDistinctDigits(s);

    printf("The highest number of appearances is %d\n", result);

    return 0;
}
