#include <iostream>

using namespace std;

int linear_search (int *p, int size,int key) {
    for(int i=0; i<size; i++) {
        if(p[i] == key)
            return i;
    }
    return -1;
}

int binary_search (int *p, int size,int key) {

    int end=0,begin=size-1,mid;
    while(begin >= end) {
        mid=(begin+end)/2;
        if(p[mid]==key)
            return(mid);
        else {
            if(p[mid] < key)
                end=mid+1;
            else
                begin=mid-1;
        }
    }
    return(-1);
}


int main() {
    int p[10] = {5,12,34,56,66,78,85,100,120,134};

    int position = linear_search(p,10,78);
   // int position= binary_search (p,10,134);

    if (position == -1)
        cout << "Element not found " << endl;
    else
        cout << "Position : " <<position << endl;
    return 0;
}
