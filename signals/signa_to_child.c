#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

// signal handling functions
void sighup()
{
    signal(SIGHUP, sighup); // reset signal
    printf("CHILD: I have received a SIGHUP\n");
}
void sigint()
{
    signal(SIGINT, sigint); // reset signal
    printf("CHILD: I have received a SIGINT\n");
}
void sigquit()
{
    printf("My DADDY has Killed me!!!\n");
    exit(0);
}

void main()
{
    int pid;

    signal(SIGHUP, sighup);
    signal(SIGINT, sigint);
    signal(SIGQUIT, sigquit);

    if ((pid = fork()) < 0)
    {
        perror("fork");
        exit(1);
    }

    /* child */
    if (pid == 0)
    {
        while (1){ }
    }

    else

    /* pid holds id of child */
    {
        printf("PARENT: sending SIGHUP\n");
        kill(pid, SIGHUP);

        sleep(3);
        printf("PARENT: sending SIGINT\n");
        kill(pid, SIGINT);

        sleep(3);
        printf("PARENT: sending SIGQUIT\n");
        kill(pid, SIGQUIT);
        
        sleep(3);
    }
}



