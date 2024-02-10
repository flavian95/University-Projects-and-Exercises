#include <stdio.h>

int main()
{
    int n = 3;
    int *pi;
    pi = &n;

    printf("Number %i, at address %p, and the value stored is %i\n", n, pi, *pi);

    int d = 5;
    int *pd;
    pd = &d;

    printf("Number %i, at address %p, and the value stored is %i", d, pd, *pd);
}