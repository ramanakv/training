#include <stdio.h>
#include <stdlib.h>
#include <sys/shm.h> // required for shm functions
#include <unistd.h>
#include<string.h>

#define SHMSIZE 512
int main()
{

    // every SHM should have a key(key_t) which is used as identifier for the SHM
    key_t shmkey = 1234;

    // argument1 is key, argument2 is the size, argument3 is permission and flags
    int id = shmget(shmkey, SHMSIZE, IPC_CREAT | 0666); // returns positive int for success and -1 for failure
    if (id < 0)
    {
        perror("SHMGET failure");
        exit(1);
    }

    char *shmptr;
    // argument1 is id, argument 2 is area to be attached(ptr if using own area,
    // NULL for OS to create and attach)
    // last argument is FLAG values - typically 0
    shmptr = (char *)shmat(id, NULL, 0); // returns void pointer to shared memory

   strcpy(shmptr, "Today is warm day");
    // we will wait for other process to read the array and place -1 in the first element
    printf("Stored message in SHM: %s\n",shmptr);
    printf("Waiting for other process to read data\n");
    while (shmptr[0] != '\0')
        sleep(2);

    // detach te SHM
    shmdt(shmptr);

    // destroy the SHM
    shmctl(id, IPC_RMID, 0);

    return 0;
}