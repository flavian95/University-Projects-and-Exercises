#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isVowel(char nr)
{
    return nr == 'a' || nr == 'e' || nr == 'i' || nr == 'o' || nr == 'u';
}

void onlyVowel(char s[100])
{
    int i;
    char returnString[100], returnStrCount = 0;

    for (i = 0; i < strlen(s); i++)
    {
        if (isVowel(s[i]))
        {
            returnString[returnStrCount] = s[i];
            returnStrCount++;
        }
    }

    for (i = 0; i < returnStrCount; i++)
    {
        printf("%c", returnString[i]);
    }
}

int main()
{
    char s[100];

    printf("Enter a string: ");
    scanf("%99[^\n]", s);

    onlyVowel(s);

    return 0;
}