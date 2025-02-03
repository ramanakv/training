#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>    // used for file open constants
#include <sys/stat.h> // for mkfifo()
#include <unistd.h>

// program to read one int from FIFO
int main()
{

    int fd = open("my_fifo", O_RDONLY);
    if (fd == -1)
    {
        printf("my_fifo is not available\n");
        exit(1);
    }
    int len;
    read(fd,&len, sizeof(int));
    char *msg = malloc((len+1)*sizeof(char));
    read(fd, msg, len);
    msg[len] ='\0';
    printf("Message from fifo %s\n", msg);
    return 0;
}