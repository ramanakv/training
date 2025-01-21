#include <iostream>
using namespace std;

class Array
{
    int *p;  //12412
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
    Array(Array &a);
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

Array::Array(Array &a){
    this->size = a.size;
    p=new int[size];
    for(int i=0;i<size;i++){
        p[i] = a.p[i];
    }
}

int main()
{
    Array a(5);
    a.fill();
    a.show();

    Array b = a;

    a.show();
}
