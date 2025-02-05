#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <stdio.h>
#include <string.h>
#include<stdlib.h>

#define MSGSZ 128

/*
 * Declare the message structure.
 */

typedef struct msgbuf
{
    long mtype;
    char mtext[MSGSZ];
} message_buf;

int main()
{
    int msqid;

    key_t key;
    message_buf sbuf;
    size_t buf_length;

    /*
     * Generate unique key with ftok().
     * first argument any string which is same in every process
     * second argument is project id (same name can be used in different projects)
     */

    key = ftok("my_msgq", 1234);

    if ((msqid = msgget(key, IPC_CREAT | 0666)) < 0)
    {
        perror("msgget");
        exit(1);
    }
    printf("message q with key %u created\n", key);

    // create and send message type 1
     
    sbuf.mtype = 1;
    strcpy(sbuf.mtext, "This is type 1 message");
    buf_length = strlen(sbuf.mtext) + 1;

    if (msgsnd(msqid, &sbuf, buf_length, IPC_NOWAIT) < 0)
    {
        perror("msgsnd");
        exit(1);
    }
    printf("Message of type %ld : \"%s\" Sent\n", sbuf.mtype, sbuf.mtext);

    // create and send message type 2
     
    sbuf.mtype = 2;
    strcpy(sbuf.mtext, "This is type 2 message");
    buf_length = strlen(sbuf.mtext) + 1;

    if (msgsnd(msqid, &sbuf, buf_length, IPC_NOWAIT) < 0)
    {
        perror("msgsnd");
        exit(1);
    }
    printf("Message of type %ld : \"%s\" Sent\n", sbuf.mtype, sbuf.mtext);

    return 0;
}
