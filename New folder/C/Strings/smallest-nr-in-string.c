#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main()
{
    char s[100], min = 0;
    int i;

    scanf("%99s", s);

    for (i = 0; i < strlen(s); i++)
    {
        if (isdigit(s[i]))
        {
            min = s[i];
            break;
        }
    }

    for (i = 0; i < strlen(s); i++)
    {
        if (isdigit(s[i]) && min > s[i])
        {
            min = s[i];
        }
    }

    printf("The smallest digit is %c\n", min);

    return 0;
}
