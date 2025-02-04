#include <stdio.h>
#include<signal.h>

// program to which ignores  SIGINT. 
//Program will never terminate with contl-C

int main(){
    signal(SIGINT,SIG_IGN);  //ignore interrupt signal
    while(1){

    }
    return 0;
}