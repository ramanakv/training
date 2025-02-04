#include <stdio.h>
#include <stdlib.h>
#include <sys/shm.h> // required for shm functions
#include <unistd.h>

#define SHMSIZE 512
int main()
{

    // every SHM should have a key(key_t) which is used as identifier for the SHM
    key_t shmkey = 1234;

    // argument1 is key, argument2 is the size, argument3 is permission
    int id = shmget(shmkey, SHMSIZE, 0666); // returns positive int for success and -1 for failure
    if (id < 0)
    {
        perror("SHMGET failure");
        exit(1);
    }

    int *shmptr;
    // argument1 is id, argument 2 is area to be attached(ptr if using own area,
    // NULL for OS to create and attach)
    // last argument is FLAG values - typically 0
    shmptr = (int *)shmat(id, NULL, 0); // returns void pointer to shared memory
    printf("Array read from SHM: ");

    for (int i = 0; i < 5; i++)
    {
        printf("%d ", shmptr[i]);
    }
    printf("\n");
    // set first element to -1 indicating to the other process taht the data is taken
    shmptr[0] = -1;
    // detach te SHM
    shmdt(shmptr);

    return 0;
}