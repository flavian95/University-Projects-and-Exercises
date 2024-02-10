#include <stdio.h>
#include <string.h>
#include <ctype.h>

void countGivenNr(char s[100], char searchNr);
int isVowel(char nr);
void vowelCount(char s[100]);
void letterCount(char s[100]);

int main()
{
    char s[100], searchNr;

    printf("Insert a string: ");
    scanf("%s", s);

    printf("Insert the character which count in the string will be returned: ");
    scanf(" %c", &searchNr);

    countGivenNr(s, searchNr);
    vowelCount(s);
    letterCount(s);
}

void letterCount(char s[100])
{
    int letterCount = 0, i;

    for (i = 0; i < strlen(s); i++)
    {
        if (isalpha(s[i]))
        {
            letterCount++;
        }
    }

    printf("The nr of letters in the string is: %d\n", letterCount);
}

int isVowel(char nr)
{
    return nr == 'a' || nr == 'e' || nr == 'i' || nr == 'o' || nr == 'u';
}

void vowelCount(char s[100])
{
    int vowelCount = 0, i;

    for (i = 0; i < strlen(s); i++)
    {
        if (isVowel(s[i]))
        {
            vowelCount++;
        }
    }

    printf("The nr of vowels in the string is: %d\n", vowelCount);
}

void countGivenNr(char s[100], char searchNr)
{
    int count = 0, i;

    for (i = 0; i < strlen(s); i++)
    {
        if (s[i] == searchNr)
        {
            count++;
        }
    }

    printf("The count of the given character in the string is %d\n", count);
}