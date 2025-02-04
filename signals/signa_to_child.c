#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

// function declaration
void sighup();
void sigint();
void sigquit();

void main()
{
    int pid;

    /* get child process */
    if ((pid = fork()) < 0) {
        perror("fork");
        exit(1);
    }

    /* child */
    if (pid == 0) { 
        signal(SIGHUP, sighup);
        signal(SIGINT, sigint);
        signal(SIGQUIT, sigquit);
        for (;;)
          
            /* loop forever */
            ; 
    }

    /* parent */
    else 
      
    /* pid holds id of child */
    { 
        write(STDOUT_FILENO, "\nPARENT: sending SIGHUP\n\n", 25);
        kill(pid, SIGHUP);

        /* pause for 3 secs */
        sleep(3); 
        write(STDOUT_FILENO, "\nPARENT: sending SIGINT\n\n", 25);
        kill(pid, SIGINT);

        /* pause for 3 secs */
        sleep(3); 
        write(STDOUT_FILENO, "\nPARENT: sending SIGQUIT\n\n", 26);
        kill(pid, SIGQUIT);
        sleep(3);
    }
}

// sighup() function definition
void sighup()
{
  
    /* reset signal */
    signal(SIGHUP, sighup); 
    write(STDOUT_FILENO, "CHILD: I have received a SIGHUP\n", 31);
}

// sigint() function definition
void sigint()
{
    
    /* reset signal */
    signal(SIGINT, sigint); 
    write(STDOUT_FILENO, "CHILD: I have received a SIGINT\n", 32);
}

// sigquit() function definition
void sigquit()
{
    write(STDOUT_FILENO, "My DADDY has Killed me!!!\n", 26);
    exit(0);
}
