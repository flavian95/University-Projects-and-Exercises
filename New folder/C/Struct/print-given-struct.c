#include <stdio.h>

typedef struct Student
{
    char name[30];
    float average;
    int year;
    char specialization[30];
    int group;
} student;

void print(student x);

int main()
{
    student student1 = {"John Doe", 85.5, 2, "Computer Science", 1};
    print(student1);

    return 0;
}

void print(student x)
{
    printf("Name: %s\n", x.name);
    printf("Average: %.2f\n", x.average);
    printf("Year: %d\n", x.year);
    printf("Specialization: %s\n", x.specialization);
    printf("Group: %d\n", x.group);
}
