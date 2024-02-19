using namespace std;
#include<iostream>
#include <string>

class Queue {
private :
    int *array;
    int front;
    int end;
    int count;
    int size;
public:
    Queue(int s) {
        array = new int[s];
        front=end =0;
        size=s;
        count=0;
    }

    void enque(int x) {
        if(count == size) {
            cout << "Queue is full" << endl;
            return ;
        }
        count++;
        array[end++] =x;
        if(end == size)
            end =0;
    }

    int deque() {
        if(count==0) {
            throw string("Queue is empty");
        }
        int val = array[front++];
        count--;
        if(front==size)
            front=0;
        return val;
    }


    ~Queue() {
        delete [] array;
    }
};

int main() {
    Queue  x(10);
    try {
        x.enque(24);
        x.enque(45);
        cout << x.deque()<< endl;
        cout << x.deque()<< endl;
        cout << x.deque()<< endl;
        x.enque(89);
        cout << x.deque()<< endl;
        cout << x.deque()<< endl;
    } catch(string s) {
        cout << s << endl;
    }
    return 0;
}
