#include <stdio.h>
#include <string.h>
#include <ctype.h>

void onlyText(char s[100])
{
    int i;
    char returnString[100], returnStrCount = 0;

    for (i = 0; i < strlen(s); i++)
    {
        if (isalpha(s[i]))
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

    onlyText(s);

    return 0;
}
