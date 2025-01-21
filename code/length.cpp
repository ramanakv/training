#include <iostream>
using namespace std;

class length
{
    int feet;
    int inches;

public:
    length(int f, int i) : feet(f + i/12), inches(i % 12)
    {
       // feet = feet + inches / 12;
       // inches = inches % 12;
    }
    void display() { cout << feet << " feet " << inches << " inches" << endl; }

    length operator+(length l);
    bool operator>(length l);
};

length length::operator+(length l)
{
    return length(feet + l.feet, inches + l.inches);
}

bool length::operator>(length l)
{
    int x = feet*12+inches;
    int y = l.feet*12+inches;
    return  x > y;
}
int main()
{
    length l1(12, 4);
    length l2(7, 9);
    l1.display();
    l2.display();

    length l3 = l1 + l2;

    l3.display();
    if (l1 > l2)
    {
        cout << "l1 is greater" << endl;
    }
    else{
        cout << "l2 is greater " << endl;
    }
}

