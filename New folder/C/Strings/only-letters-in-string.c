#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main()
{
    char s[100], n[100];

    printf("Enter a string: ");
    scanf("%99s", s);

    int j = 0;

    for (int i = 0; i < strlen(s); i++)
    {
        if (isalpha(s[i]))
        {
            n[j] = s[i];
            j++;
        }
    }

    n[j] = '\0';

    printf("String with only letters: %s\n", n);

    return 0;
}