#include <stdio.h>

float FahrenheitToC(float nr);
float CelsiusToF(float nr);

int main()
{
    int choice;
    float nr;

    scanf("%d %f", &choice, &nr);

    if (choice == 1)
    {
        float FahrenheitToCelsius = FahrenheitToC(nr);

        printf("Temperature in Celsius: %.2f", FahrenheitToCelsius);
    }

    if (choice == 2)
    {

        float CelsiusToFahrenheit = CelsiusToF(nr);

        printf("Temperature in Fahrenheit: %.2f", CelsiusToFahrenheit);
    }

    else
    {
        printf("Insert either 1 or 2");
    }
}

float FahrenheitToC(float nr)
{
    return ((float)nr - 32.0) * 5.0 / 9.0;
}

float CelsiusToF(float nr)
{
    return ((float)nr * 9.0 / 5.0) + 32.0;
}