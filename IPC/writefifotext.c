#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>    // used for file open constants
#include <sys/stat.h> // for mkfifo()
#include <unistd.h>
#include <string.h>

// program to create FIFO and write one int
int main()
{
  //assumed a FIFO with name my_fifo existing

    int fd = open("my_fifo", O_WRONLY);
    if (fd == -1)
    {
        printf("my_fifo is not available\n");
        exit(1);
    }
    char message[100] = "Hello from writefifotext";
    int len = strlen(message);
    write(fd,&len,sizeof(int));
    write(fd, message, len); // blocks here till some other process opens for read

    printf("Message added to fifo my_fifo\n");
    return 0;
}