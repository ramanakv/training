#include <string>
#include <iostream>

#include "LinkedList.h"
using namespace std;

class stack {
    LinkedList list;
public :
    void push(string val) {
        list.AddFirst(val);
    }
    string pop() {
        return list.RemoveFirst();
    }

};



int main() {
    stack stk;
    try {
        stk.push("Name 1");
        stk.push("Name 2");
        cout << stk.pop() << endl;
        stk.push("Name 3");
        cout << stk.pop() << endl;
        cout << stk.pop() << endl;
        cout << stk.pop() << endl;  // to check empty stack exception
    } catch(string msg) {
        cout <<  msg << endl;
    }

    return 0;
}
