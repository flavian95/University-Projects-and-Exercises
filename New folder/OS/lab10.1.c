#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <errno.h>

int main(int argc, char *argv[])
{
    pid_t id1, id2, id3, id4;
    id1 = fork();
    id2 = fork();
    id3 = fork();
    id4 = fork();

    pid_t cpid;
    while ((cpid = wait(NULL)) != -1 || errno != ECHILD)
    {
        printf("I am process %d. Child process %d has just finished execution.\n", getpid(), cpid);
    }
    printf("I am process %d. All my children have finished execution. My parent is %d.\n id1 = %d id2 = %d id3 = %d id4 = %d\n", getpid(), getppid(), id1, id2, id3, id4);
    return 0;
}