#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isVowel(char c)
{
    c = tolower(c);
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

void onlyVowels(char s[100], char n[100])
{
    int j = 0;

    for (int i = 0; i < strlen(s); i++)
    {
        if (isalpha(s[i]) && isVowel(s[i]))
        {
            n[j] = s[i];
            j++;
        }
    }

    n[j] = '\0';
}

int main()
{
    char s[100], vowels[100];

    printf("Enter a string: ");
    scanf("%99s", s);

    onlyVowels(s, vowels);

    printf("String with only vowels: %s\n", vowels);

    return 0;
}