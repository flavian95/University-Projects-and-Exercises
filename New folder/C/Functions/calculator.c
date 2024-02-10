#include <stdio.h>

int main()
{
    float a, b, result;
    char sign;

    printf("Enter two numbers and a sign (+, -, *, /): ");
    scanf("%f %f %c", &a, &b, &sign);

    switch (sign)
    {
    case '+':
        result = a + b;
        break;
    case '-':
        result = a - b;
        break;
    case '*':
        result = a * b;
        break;
    case '/':
        if (b != 0)
        {
            result = a / b;
        }
        else
        {
            printf("Error: Division by zero is not allowed.\n");
            return 1;
        }
        break;
    default:
        printf("Error: Invalid sign. Please use +, -, *, or /.\n");
        return 1;
    }

    printf("%f %c %f = %f\n", a, sign, b, result);

    return 0;
}
