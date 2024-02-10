#include <stdio.h>

int main()
{
    int i, j, n, flag = 0;

    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            if (n % 2 == 0)
            {
                if (flag == 0)
                {
                    printf("0 ");
                }
                else
                {
                    printf("1 ");
                }
                flag = 1 - flag;
            }
            else
            {
                if (flag == 0)
                {
                    printf("0 ");
                    flag = 1;
                }
                else
                {
                    printf("1 ");
                    flag = 0;
                }
            }
        }
        printf("\n");

        if (n % 2 == 0)
        {
            flag = 1 - flag;
        }
    }

    return 0;
}