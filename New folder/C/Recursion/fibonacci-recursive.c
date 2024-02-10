#include <stdio.h>

int fibonacci(int nr)
{
    if (nr <= 1)
    {
        return nr;
    }
    else
    {
        return fibonacci(nr - 1) + fibonacci(nr - 2);
    }
}

int main()
{
    int nr;

    scanf("%d", &nr);

    printf("Fibonacci of %d: ", nr);
    for (int i = 0; i < nr; i++)
    {
        printf("%d ", fibonacci(i));
    }

    return 0;
}
