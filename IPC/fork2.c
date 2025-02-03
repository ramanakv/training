#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>   // required for fork()
#include <sys/wait.h> // required for wait()

int main()
{
    int n, i;
    int id = fork();

    if (id == 0)
        n = 1;
    else
        n = 6;

    if (id != 0)
        wait(NULL);

    for (i = n; i < n + 5; i++)
    {
        printf("%d ", i);
       fflush(stdout);
        sleep(1);
    }
    if (id != 0)
        printf("\n");
    return 0;
}