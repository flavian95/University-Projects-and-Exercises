#include <stdio.h>

int main()
{
    int operationNumber, deposit, withdrawal, cash = 1000;

    scanf("%d", &operationNumber);

    if (operationNumber == 1)
    {
        printf("Your current balance is: $%d", cash);
    }

    if (operationNumber == 2)
    {
        scanf("%d", &withdrawal);
        cash = cash - withdrawal;
        printf("\n");
        printf("Please collect your cash\n");
        printf("Your current balance is: $%d", cash);
    }

    if (operationNumber == 3)
    {
        scanf("%d", &deposit);
        cash = cash + deposit;
        printf("Your balance is: $%d", cash);
    }

    if (operationNumber == 4)
    {
        printf("Thank you for using ATM");
    }

    if ((operationNumber != 1) && (operationNumber != 2) && (operationNumber != 3) && (operationNumber != 4))
    {
        printf("Select correct option");
    }
}