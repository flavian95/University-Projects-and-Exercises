#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isVowel(char c)
{
    c = tolower(c);
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

int countDistinctVowels(const char *s)
{
    int count = 0;
    int maxCount = 0;

    for (int i = 0; i < strlen(s); i++)
    {
        if (isVowel(s[i]))
        {
            count = 1;
            while (isVowel(s[i]) && s[i] == s[i + 1])
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

    int result = countDistinctVowels(s);

    printf("The highest number of appearances of a vowel is %d\n", result);

    return 0;
}
