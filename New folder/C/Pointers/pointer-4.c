#include <stdio.h>

int main()
{
    int x = 5;
    int *pi = &x;

    printf("%p\n", pi);
    printf("%x\n", pi);
    printf("%d\n", pi);

    *pi = 10;

    printf("%d\t %d\t %p", x, *pi, pi);
}