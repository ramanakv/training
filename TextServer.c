#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <unistd.h>

int main()
{
  struct sockaddr_in address;

  int serverfd;
  int client_socket;
  // create socket by calling socket() function
  // first argument is type of IP - AF_NET for IPv4, AF_NET6 for IPv6
  // second argument type of transport(for TCP - SOCKSTREAM, for UDP - SOCK_DGRAM)
  // third argument is for IP protocol which is generally 0
  serverfd = socket(AF_INET, SOCK_STREAM, 0);
  if (serverfd < 0)
  {
    printf("Unable to create socket\n");
    exit(0);
  }
  // fill address structure
  address.sin_family = AF_INET;
  address.sin_addr.s_addr = INADDR_ANY;
  address.sin_port = htons(2345);

  // bind the serverfd with this address
  int x = bind(serverfd, (struct sockaddr *)&address, sizeof(address));

  if (x < 0)
  {
    printf("Unable to bind\n");
    exit(0);
  }
  // wait for client request . that is done with listen() function
  x = listen(serverfd, 3);
  if (x < 0)
  {
    printf("Unable to listen\n");
    exit(0);
  }
  printf("Server listening on port number 2345\n");
  // accept connection by calling accept() function which returns client socket id
  int len = sizeof(address);
  client_socket = accept(serverfd, (struct sockaddr *)&address, &len);
  

  if (client_socket < 0)
  {
    
    perror("client socket create failure ");
    exit(0);
  }

// perform input / output here

int length;
recv(client_socket,&length,sizeof(int),0);
char *msg = malloc((length+1) * sizeof(char));
recv(client_socket,msg, length,0);
msg[length] ='\0';
printf("Message received from client\n");
printf("%s\n",msg);

close(client_socket);
close(serverfd);
return 0;
}
