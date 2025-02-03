#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>    // used for file open constants
#include <sys/stat.h> // for mkfifo()
#include <unistd.h>

// program to create FIFO and write one int
int main()
{
    if (mkfifo("my_fifo", 0777) == -1)
    {
        printf("Named pipe already exists\n");
    }

    int fd = open("my_fifo", O_WRONLY);
    if (fd == -1)
    {
        printf("my_fifo is not available\n");
        exit(1);
    }
    int x = 65;
    write(fd, &x, sizeof(int)); // blocks here till some other process opens for read
    printf("Wrote 65 to fifo my_fifo");
    return 0;
}