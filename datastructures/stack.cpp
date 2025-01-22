#include <iostream>
using namespace std;

class stack
{
    const int SIZE;
    string *p;
    int index;

public:
    stack(int size = 10);
    void push(string name);
    string pop();
    ~stack()
    {
        delete[] p;
    }
};

stack::stack(int size) : SIZE(size), index(-1)
{
    p = new string[SIZE];
}

void stack::push(string name)
{
    if (index == SIZE - 1)
        throw string("Stack is full! ") + name + string(" cannot be pushed");
    p[++index] = name;
}

string stack::pop()
{
    if (index == -1)
        throw string("Stack is empty");
    return p[index--];
}

int main()
{

    stack stk(5);
    try
    {
        stk.push("Ramana");
        stk.push("Sudhir");
        stk.push("Kishore");
        stk.push("Alok");
        stk.push("John");
        stk.push("Lima");
    }
    catch (string s)
    {
        cout << s << endl;
    }

    try
    {
        while (true)
        {
            cout << stk.pop() << endl;
        }
    }
    catch (string s)
    {
        cout << s << endl;
    }
}