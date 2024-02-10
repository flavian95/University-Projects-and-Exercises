#include <stdio.h>
#include <math.h>

int main()
{
    float a, b, arithMean, geoMean, harMean;

    scanf("%f %f", &a, &b);

    arithMean = (a + b) / 2;
    geoMean = sqrt(a * b);
    harMean = (2 * (a * b)) / (a + b);

    printf("Arithmetic mean: %f\n", arithMean);
    printf("Geometric mean: %f\n", geoMean);
    printf("Harmonic mean: %f\n", harMean);
}