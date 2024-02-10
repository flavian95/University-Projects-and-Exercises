#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isVowel(char nr)
{
    nr = tolower(nr);
    return nr == 'a' || nr == 'e' || nr == 'i' || nr == 'o' || nr == 'u';
}

int countDistinctVowels(char s[100])
{
    int i, j;
    int count = 0, maxCount = 0;

    for (i = 0; i < strlen(s); i++)
    {
        if (isVowel(s[i]))
        {
            count = 1;
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

    int result = countDistinctVowels(s);

    printf("The highest number of appearances is %d\n", result);

    return 0;
}