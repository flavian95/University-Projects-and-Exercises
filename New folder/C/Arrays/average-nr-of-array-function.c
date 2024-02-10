#include <stdio.h>
#include <math.h>

void read_array(double arr[10], int n);

void display_array(double arr[10], int n);

double average(double arr[10], int n);

double arr[10] = {0};

int main()
{
    double m;
    int n;

    scanf("%d", &n);

    read_array(arr, n);
    m = average(arr, n);
    display_array(arr, n);

    printf("The avarage of array values = %.2f\n", m);
    return 0;
}

void read_array(double arr[10], int n)
{
    for (int i = 0; i < n; i++)
    {
        scanf("%lf", &arr[i]);
    }
}
void display_array(double arr[10], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%.2f ", arr[i]);
    }
    printf("\n");
}

double average(double arr[10], int n)
{
    double average, sum = 0;

    for (int i = 0; i < n; i++)
    {
        sum += arr[i];
    }
    average = (sum / n);

    return average;
}