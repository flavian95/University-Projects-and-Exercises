#include <stdio.h>

int main()
{
    int n = 3;
    int *pointer;
    pointer = &n;

    printf("Nr : %d, at address of : %p", n, pointer);
}