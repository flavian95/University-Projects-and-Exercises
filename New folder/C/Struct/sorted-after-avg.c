#include <stdio.h>

typedef struct Student
{
    char name[30];
    float average;
    int year;
    char specialization[30];
    int group;
} student;

student reads();
void print(student x);
void bubbleSort(student arr[], int n);

int main()
{
    int numStudents;

    printf("Enter the number of students: ");
    scanf("%d", &numStudents);

    student studentArray[numStudents];

    for (int i = 0; i < numStudents; i++)
    {
        printf("\nEnter details for student %d:\n", i + 1);
        studentArray[i] = reads();
    }

    bubbleSort(studentArray, numStudents);

    for (int i = 0; i < numStudents; i++)
    {
        printf("\nDetails for student %d:\n", i + 1);
        print(studentArray[i]);
    }

    return 0;
}

student reads()
{
    student student;

    printf("Enter student name: \n");
    scanf(" %29[^\n]", student.name);

    printf("Enter student average: \n");
    scanf("%f", &student.average);

    printf("Enter student year: \n");
    scanf("%d", &student.year);

    printf("Enter student specialization: \n");
    scanf(" %29[^\n]", student.specialization);

    printf("Enter student group: \n");
    scanf("%d", &student.group);

    return student;
}

void print(student x)
{
    printf("\nStudent Details:\n");
    printf("Name: %s\n", x.name);
    printf("Average: %.2f\n", x.average);
    printf("Year: %d\n", x.year);
    printf("Specialization: %s\n", x.specialization);
    printf("Group: %d\n", x.group);
}

void bubbleSort(student arr[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (arr[j].average > arr[j + 1].average)
            {
                student temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
