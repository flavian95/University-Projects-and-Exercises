#include <stdio.h>

typedef struct Student
{
    char name[30];
    float average;
    int year;
    char specialization[30];
    int group;
} student;

student reads()
{
    student newStudent;

    printf("Enter student name: \n");
    scanf(" %29[^\n]", newStudent.name);

    printf("Enter student average: \n");
    scanf("%f", &newStudent.average);

    printf("Enter student year: \n");
    scanf("%d", &newStudent.year);

    printf("Enter student specialization: \n");
    scanf(" %29[^\n]", newStudent.specialization);

    printf("Enter student group: \n");
    scanf("%d", &newStudent.group);

    return newStudent;
}

int main()
{
    student myStudent = reads();

    printf("\nStudent Details:\n");
    printf("Name: %s\n", myStudent.name);
    printf("Average: %.2f\n", myStudent.average);
    printf("Year: %d\n", myStudent.year);
    printf("Specialization: %s\n", myStudent.specialization);
    printf("Group: %d\n", myStudent.group);

    return 0;
}
