#include <stdio.h>
#include <string.h>
#include <ctype.h>

void greatestNrFromString(char s[100])
{
    char max = 0;
    int i;

    for (i = 0; i < strlen(s); i++)
    {
        if (isdigit(s[i]) && max < s[i])
        {
            max = s[i];
        }
    }

    printf("%c", max);
}

int main()
{
    char s[100];
    int i;

    scanf("%s", s);

    greatestNrFromString(s);
}