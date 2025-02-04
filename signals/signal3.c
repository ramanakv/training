#include <stdio.h>
#include <signal.h>
#include <stdlib.h> // required for exit()
#include <unistd.h>

// program to which ignores  SIGINT 2 times and call for defaul action

int count = 0;

// handler function
void handle_sig(int sigid)
{
    if (sigid == SIGFPE)
    {
        printf("Divide by zero lead to FPE\n");
        exit(0);
    }
    else
    {
        signal(sigid, SIG_DFL);
    }
}
int main()
{
    signal(SIGFPE, handle_sig); // ignore interrupt signal
    int x =102;
    int y= 0;
    int result = x / y;
    printf("Program continues\n");
    return 0;
}