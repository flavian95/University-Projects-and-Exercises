#include <stdio.h>

int isTriangle(int a, int b, int c)
{
    return (a + b > c) && (b + c > a) && (a + c > b);
}

int main()
{
    int side1, side2, side3;

    scanf("%d %d %d", &side1, &side2, &side3);

    if (isTriangle(side1, side2, side3))
    {
        printf("The numbers can form a triangle.\n");
    }
    else
    {
        printf("The numbers cannot form a triangle.\n");
    }

    return 0;
}
