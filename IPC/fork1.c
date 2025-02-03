#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include<sys/wait.h>

int main()
{
    int x = 100;
    int id = fork();

    if (id == 0)
    {
        
        x++;
        printf("Child: Value of x: %d\n", x);
        printf("Child: PID %u\n",getpid());
        printf("Child: PPID: %u\n",getppid());
    }
    else
    {
        wait(NULL);
        printf("Parent: id returned by fork() %u\n",id);
        printf("Parent: Value of x: %d\n", x);
        printf("Parent: PID %u\n",getpid());
        printf("Parent: PPID: %u\n",getppid());
    }

    printf("Process completed\n");
    return 0;
}