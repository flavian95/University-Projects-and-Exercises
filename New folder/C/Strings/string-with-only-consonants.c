#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isConsonant(char nr)
{
    return nr != 'a' && nr != 'e' && nr != 'i' && nr != 'o' && nr != 'u';
}

int onlyConsonants(char s[100])
{
    int i;

    for (i = 0; i < strlen(s); i++)
    {
        if ((isalpha(s[i])) && (isConsonant(s[i])))
        {
            printf("%c", s[i]);
        }
    }
}

int main()
{
    char s[100];

    printf("Enter a string: ");
    scanf("%s", s);

    int result = onlyConsonants(s);

    return 0;
}