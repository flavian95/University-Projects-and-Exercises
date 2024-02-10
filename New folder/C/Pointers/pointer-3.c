#include <stdio.h>

int main()
{
    int x = 5;
    int *pi = &x;
    int y = *pi + 5;
    *pi = 7;

    printf("%i %p %i %i", x, pi, y, *pi);
}