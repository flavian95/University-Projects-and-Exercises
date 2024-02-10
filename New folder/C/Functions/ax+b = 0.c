#include <stdio.h>

int main()
{
    float a, b, x;

    scanf("%f %f", &a, &b);

    x = (-b) / a;

    if ((a == 0) && (b == 0))
    {
        printf("Any number is a solution.");
    }

    else
    {
        if (a == 0)
        {
            printf("No solutions.");
        }

        else
        {

            printf("The unique solution is %f", x);
        }
    }
}