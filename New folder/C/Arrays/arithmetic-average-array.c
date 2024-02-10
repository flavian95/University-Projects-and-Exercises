#include <stdio.h>

void read_array(float v[], int n);

void display_array(float v[], int n);

float average(float v[], int n);

float v[100];

int main()
{
    float m;

    read_array(v, 10);
    display_array(v, 10);

    m = average(v, 10);
    printf("Arithmetic average = %.2f", m);

    return 0;
}

void read_array(float v[], int n)
{
    int i;

    for (i = 0; i < n; i++)
    {
        scanf("%f", &v[i]);
    }
}

void display_array(float v[], int n)
{
    int i;

    for (i = 0; i < n; i++)
    {
        printf("%.2f ", v[i]);
    }
    printf("\n");
}

float average(float v[], int n)
{
    int i;
    float avg = 0;

    for (i = 0; i < n; i++)
    {
        avg = avg + v[i];
    }
    avg = avg / n;

    return avg;
}