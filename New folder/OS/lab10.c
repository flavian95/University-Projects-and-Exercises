#include <stdio.h>
#include <pthread.h>
#define NO_THREADS 10

void *thread_run(void *); /* the prototype of a thread function (both the input
and output argument type must be void *. This is the generic pointer type, which
can be cast to any other pointer type).
If you have more than one argument, define them in the structure and pass a pointer
to the structure as the input argument. */
int thread_counter = 0;
int main(int argc, char *argv[])
{
    pthread_t thread_id[NO_THREADS];
    int manual_id[NO_THREADS];
    int i;
    for (i = 0; i < NO_THREADS; i++)
    {
        manual_id[i] = i;
    }
    for (i = 0; i < NO_THREADS; i++)
    {
        pthread_create(thread_id + i, NULL, thread_run, (void *)(manual_id + i));
    }
    while (thread_counter == 0)
    {
        printf("I am the main thread. I have created %d threads. Launched: %d threads.\n", NO_THREADS, thread_counter);
    }
    for (i = 0; i < NO_THREADS; i++)
    {
        pthread_join(thread_id[i], NULL);
    }
    printf("Final counter value: %d\n", thread_counter);
    return 0;
}
void *thread_run(void *manual_id)
{
    printf("Thread ID: %d (manual), %ld (automatic).\n", *(int *)manual_id,
           pthread_self());
    thread_counter++;
}