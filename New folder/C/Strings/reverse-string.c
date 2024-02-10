#include <stdio.h>
#include <string.h>

void revString(char s[100])
{
    int i;

    for (i = strlen(s); i >= 0; i--)
    {
        printf("%c", s[i]);
    }
}

int main()
{
    char s[100];

    scanf("%s", s);

    revString(s);
}