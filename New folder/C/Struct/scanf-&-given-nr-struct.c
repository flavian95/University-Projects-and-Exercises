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

int main()
{
    student theStudent1 = reads();
    print(theStudent1);

    student student2 = {"John Doe", 85.5, 2, "Computer Science", 1};
    print(student2);

    return 0;
}

student reads()
{
    student student1;

    printf("Enter student name: \n");
    scanf(" %29[^\n]", student1.name);

    printf("Enter student average: \n");
    scanf("%f", &student1.average);

    printf("Enter student year: \n");
    scanf("%d", &student1.year);

    printf("Enter student specialization: \n");
    scanf(" %29[^\n]", student1.specialization);

    printf("Enter student group: \n");
    scanf("%d", &student1.group);

    return student1;
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
