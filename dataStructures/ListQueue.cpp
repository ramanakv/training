
#include <iostream>
#include "LinkedList.h"
using namespace std;

class Queue {
    LinkedList list;
public :
    void enqueue(string val) {
        list.AddLast(val);
    }
    string deque() {
        return list.RemoveFirst();
    }

};



int main() {
    Queue  q;
    try {
        q.enqueue("Name 1");
        q.enqueue("Name 2");
        cout << q.deque() << endl;
        q.enqueue("Name 3");
        cout << q.deque() << endl;
        cout << q.deque() << endl;
        cout << q.deque() << endl;  // to check empty queue exception
    } catch(string msg) {
        cout <<  msg << endl;
    }

    return 0;
}
