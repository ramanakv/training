#include <iostream>
using namespace std;

class Array
{
    int *p;
    int size;

public:
    ~Array()
    {
        delete[] p;
        cout << "Memory released" << endl;
    }
    Array(int s) : size(s)
    {
        p = new int[size];
    }
    void fill();
    void show();
};

void Array::fill()
{
    cout << "Enter " << size << " Numbers ";
    for (int i = 0; i < size; i++)
    {
        cin >> p[i];
    }
}
void Array::show()
{
    for (int i = 0; i < size; i++)
    {
        cout << p[i] << " ";
    }
    cout << endl;
}

int main()
{
    Array a(5);
    a.fill();
    a.show();
}
