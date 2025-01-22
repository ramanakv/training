#include <iostream>
using namespace std;

class queue
{
    const int SIZE;
    string *p;
    int front, back;
    int count;

public:
    queue(int size = 10);
    void enque(string name);
    string deque();
    ~queue()
    {
        delete[] p;
    }
};

queue::queue(int size) : SIZE(size), front(0), back(0), count(0)
{
    p = new string[SIZE];
}

void queue::enque(string name)
{
    if (count == SIZE)
        throw "Fail to add " + name + ". Queue is full";
    count++;
    p[back++] = name;
    if (back == SIZE)
        back = 0;
}

string queue::deque()
{
    if (count == 0)
        throw string("Queue is empty");
    count--;
    string name = p[front++];
    if (front == SIZE)
        front = 0;
    return name;
}

int main()
{

    queue que(5);
    try
    {
        que.enque("Ramana");
        que.enque("Sudhir");
        que.enque("Kishore");
        que.enque("Alok");
        que.enque("John");
        que.enque("Lima");
    }
    catch (string s)
    {
        cout << s << endl;
    }

    try
    {
        while (true)
        {
            cout << que.deque() << endl;
        }
    }
    catch (string s)
    {
        cout << s << endl;
    }
}