#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isVowel(char ch)
{
    ch = tolower(ch);
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
}

int main()
{
    char ch;

    scanf("%c", &ch);

    int isVowelDisplay = isVowel(ch);

    if (!isalpha(ch))
    {
        printf("%c is not in the alphabet", ch);
    }

    else
    {
        if (isVowelDisplay)
        {
            printf("%c is a VOWEL.\n", ch);
        }

        else
        {
            printf("%c is a CONSONANT.\n", ch);
        }
    }

    return 0;
}
