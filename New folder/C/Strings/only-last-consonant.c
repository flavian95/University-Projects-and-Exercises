#include <stdio.h>
#include <ctype.h>
#include <string.h>

int isConsonant(int nr)
{
    return nr != 'a' && nr != 'e' && nr != 'i' && nr != 'o' && nr != 'u';
}

int main()
{
    char s[100], lastConsonant;
    int i;

    scanf("%s", s);

    for (i = 0; i < strlen(s); i++)
    {
        if (isalpha(s[i]) && isConsonant(s[i]))
        {
            lastConsonant = s[i];
        }
    }

    printf("%c", lastConsonant);
}