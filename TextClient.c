#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include<string.h>
#include<unistd.h>
int main()
{
    int clientfd;
    struct sockaddr_in server_address;
    int server_socket;

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
    int length = strlen(message);
    if(send(server_socket, &length, sizeof(int), 0) < 0){
        printf("Sending length failed\n");
        exit(0);
    }
    if(send(server_socket, message, length, 0)<0){
        printf("message send failed\n");
        exit(0);
    }
    printf("Message sent to the server\n");
   
    close(server_socket);
    return 0;
}