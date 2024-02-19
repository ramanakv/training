using namespace std;
#include <iostream>

class Stack {
    string  *Data;           // The actual Data array
    int CurrElemNum;    // The current number of elements
    const int MAX_NUM;       // Maximum number of elements

public:
    Stack(int MaxSize=500);
    ~Stack() {
        delete[] Data;
    }

    void push(const string &Item); // Adds Item to the top
    string pop(void);              // Returns Item from the top
};

Stack::Stack(int MaxSize) : MAX_NUM( MaxSize ) {  // Initialize the constant
    Data = new string[MAX_NUM];
    CurrElemNum = 0;
}

void Stack::push(const string &Item) {
    if (CurrElemNum == MAX_NUM)
        throw string("Stack is full");
    Data[CurrElemNum++] = Item;
}

string Stack::pop(void) {
    if(CurrElemNum == 0)
        throw string("Stack is empty");
    return Data[--CurrElemNum];
}

int main() {
    Stack stk(5);
    try {
        stk.push("Hyderabad");
        stk.push("Delhi");
        stk.push("Kanpur");
        cout  << stk.pop() << endl;
        cout << stk.pop() << endl;
        cout << stk.pop() << endl;
        cout << stk.pop() << endl;
    } catch(string msg) {
        cout << msg << endl;
    }
    return 0;
}
