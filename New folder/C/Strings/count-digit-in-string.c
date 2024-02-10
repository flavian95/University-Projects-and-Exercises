#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main()
{
    char s[100];
    int i, n, count = 0;

    scanf("%99s", s);
    scanf("%d", &n);

    for (i = 0; i <= strlen(s); i++)
    {
        if (isdigit(s[i]))
        {
            if (n == (s[i] - '0'))
            {
                count++;
            }
        }
    }

    printf("The number %d is found %d times\n", n, count);

    return 0;
}