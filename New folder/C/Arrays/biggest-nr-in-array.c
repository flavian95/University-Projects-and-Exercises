#include <stdio.h>

float max(float v[], int n);

int main()
{
    int i, n;
    float v[10];

    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        scanf("%f", &v[i]);
    }

    for (i = 0; i < n; i++)
    {
        printf("%f ", v[i]);
    }
    printf("\n");

    float maxNr = max(v, n);

    printf("%f ", maxNr);
}

float max(float v[], int n)
{
    float max = 0;
    int i;

    for (i = 0; i < n; i++)
    {
        if (v[i] > max)
        {
            max = v[i];
        }
    }

    return max;
}