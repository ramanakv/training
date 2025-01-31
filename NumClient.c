#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <string.h>
#include <unistd.h>
// client program to send int array to the server and get sum from server
int main()
{
    int clientfd;
    struct sockaddr_in server_address;
    int server_socket;
    int array[] = {1,2,3,4,5,6,7,8,9,10}; // 10 elements

    char *message = "Hello server";
    server_socket = socket(AF_INET, SOCK_STREAM, 0);
    if (server_socket < 0)
    {
        printf("Unable to create socket\n");
        exit(0);
    }

    server_address.sin_family = AF_INET;

    server_address.sin_port = htons(2345);
    // use inet_pton() to translate string address to binary and place in the structure
    int x = inet_pton(AF_INET, "127.0.0.1", &server_address.sin_addr);
    if (x < 0)
    {
        printf("invalid address\n");
        exit(0);
    }

    int status = connect(server_socket, (struct sockaddr *)&server_address, sizeof(server_address));
    if (status < 0)
    {
        printf("connect failed\n");
        exit(0);
    }
    // perform input / output here
    int length = 10;
    write(server_socket, &length, sizeof(int));
    write(server_socket, array, length*sizeof(int) );
    printf("Array sent to the server\n");

    int sum;
    read(server_socket, &sum, sizeof(int));
    printf("Sum of numbers received from server: %d\n", sum);
    close(server_socket);
    return 0;
}