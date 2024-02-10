#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main()
{
    char s[100], temp = 0;
    int i;

    scanf("%99s", s);

    for (i = 0; i <= strlen(s); i++)
    {
        if (isdigit(s[i]))
        {
            if (temp < s[i])
            {
                temp = s[i];
            }
        }
    }

    printf("%The greatest digit is %c\n", temp);

    return 0;
}
