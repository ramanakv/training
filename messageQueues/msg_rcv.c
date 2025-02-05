#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <stdio.h>
#include<stdlib.h>

#define MSGSZ     128

/*
 * Declare the message structure.
 */

typedef struct msgbuf {
    long    mtype;
    char    mtext[MSGSZ];
} message_buf;


int main()
{
    int msqid;
    key_t key;
    message_buf  rbuf;

    /*
     * Generate unique key with ftok(). 
     * first argument any string which is same in every process
     * second argument is project id (same name can be used in different projects)
     */

    key = ftok("my_msgq",1234);

    /*
     * Get the message queue id for the given key, which was created by
     * the server.
     */
    if ((msqid = msgget(key, 0666)) < 0) {
        perror("msgget");
        exit(1);
    }

    
    /*
     * Receive message type 2.
     * last argument is flag. can be IPC_NOWAIT
     */
    if (msgrcv(msqid, &rbuf, MSGSZ, 2, 0) < 0) {
        perror("msgrcv");
        exit(1);
    }

    // Print the message
    printf("%s\n", rbuf.mtext);

    // destroy the message queue
    msgctl(msqid,IPC_RMID,NULL);
    
    return 0;
}