#include <stdio.h>
#include <signal.h>
#include<stdlib.h>  // required for exit()
#include <unistd.h>

// program to which ignores  SIGINT 2 times and call for defaul action

int count = 0;

// handler function
void handle_sig(int sigid)
{
    if (sigid == SIGINT)
    {
        count++;
        if (count < 3)
        {
            printf("program interupted but ignored\n");
            
        }
        else
        {
            printf("Exiting\n");
            kill(getpid(),SIGKILL);
        }
    }
    else
        signal(sigid, SIG_DFL);
}
int main()
{
    signal(SIGINT, handle_sig); // ignore interrupt signal
    while (1)
    {
    }
    return 0;
}