#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> // required for fork()
#include <time.h>   // using time as seed to generate random numbers

// program to use two way communication
// creates 2 pipes ptoc (parent to child) and ctop (child to parent)
// parent writes array and child reads the array
// child generates sum of the array and write sum  which is read by parent

int main()
{
    int ptoc[2]; // ptoc[0] not required in parent. ptoc[1] not required in child
    int ctop[2]; // ctop[1] not required in parent. ctop[0] not required in child

    if (pipe(ctop) < 0)
    {
        printf("Pipe create error\n");
        exit(1);
    }
    pipe(ptoc);

    int id = fork();

    if (id == 0)
    {
        close(ptoc[1]);
        close(ctop[0]);
        int size;
        int sum = 0;
        read(ptoc[0], &size, sizeof(int));
        int *p = malloc(size);  // allocate storage for whole array
        read(ptoc[0], p, size); // read the whole array into p
        int elements = size / sizeof(int);
        printf("Array received by child: ");
        for (int i = 0; i < elements; i++)
        {
            printf("%d ", p[i]);
            sum = sum + p[i];
        }
        printf("\n");
        write(ctop[1], &sum, sizeof(int));
        
        close(ptoc[0]);
        close(ctop[1]);
    }
    else
    {
        close(ptoc[0]);
        close(ctop[1]);
        srand(time(NULL));

        int array[5];
        printf("Array sent by parent: ");
        for (int i = 0; i < 5; i++)
        {
            array[i] = rand() % 100;
            printf("%d ", array[i]);
        }
        printf("\n");

        int size = sizeof(array);
        int sum;
        write(ptoc[1], &size, sizeof(int));
        write(ptoc[1], array, size);
        read(ctop[0], &sum, sizeof(int));
        printf("Sum: %d\n", sum);
        close(ptoc[1]);
        close(ctop[1]);
    }

    return 0;
}