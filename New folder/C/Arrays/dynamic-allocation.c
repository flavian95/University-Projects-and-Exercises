#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int n, i;
    scanf("%d", &n);

    int size = n / 2;
    int *arr1 = malloc(size * sizeof(int));
    int *arr2 = malloc(size * sizeof(int));

    if (arr1 == NULL || arr2 == NULL)
    {
        printf("Memory allocation failed.\n");
        return 1;
    }

    int str_size = size * 12 + 1;
    char *arr_str1 = malloc(str_size * sizeof(char));
    char *arr_str2 = malloc(str_size * sizeof(char));

    if (arr_str1 == NULL)
    {
        printf("String memory allocation failed.\n");
        free(arr1);
        return 1;
    }

    if (arr_str2 == NULL)
    {
        printf("String memory allocation failed.\n");
        free(arr2);
        return 1;
    }

    strcpy(arr_str1, "a = [");
    strcpy(arr_str2, "b = [");

    for (i = 0; i < size; i++)
    {

        arr1[i] = 2 * (i + 1);
        char temp1[12];
        sprintf(temp1, "%d", arr1[i]);
        strcat(arr_str1, temp1);

        if (i < size - 1)
        {
            strcat(arr_str1, ", ");
        }

        arr2[i] = 2 * (i + 1);
        char temp2[12];
        sprintf(temp2, "%d", arr2[i]);
        strcat(arr_str2, temp2);

        if (i < size - 1)
        {
            strcat(arr_str2, ", ");
        }
    }

    strcat(arr_str1, "];\n");
    strcat(arr_str2, "];\n");

    printf("%s ", arr_str1);
    printf("%s ", arr_str2);

    free(arr1);
    free(arr_str1);

    free(arr2);
    free(arr_str2);

    return 0;
}