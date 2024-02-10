#include <stdio.h>
#include <string.h>
#include <ctype.h>

void minNrInString(char s[100])
{
    char min = '9';
    int i;

    for (i = 0; i < strlen(s); i++)
    {
        if ((isdigit(s[i]) && (s[i] < min)))
        {
            min = s[i];
        }
    }

    printf("%c", min);
}

int main()
{
    char s[100];

    scanf("%s", s);

    minNrInString(s);
}