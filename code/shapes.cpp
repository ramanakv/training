#include <iostream>

using namespace std;
// abstract class shape
class shape
{
public:
    virtual float calculateArea() = 0;
    virtual float calculatePeri() = 0;
};

// rectangle class
class rectangle : public shape
{
    float length;
    float width;

public:
    rectangle(float l, float w) : length(l), width(w) {}
    float calculateArea() { return length * width; }
    float calculatePeri() { return 2 * (length + width); }
};

// square class
class square : public shape
{
    float length;

public:
    square(float l) : length(l) {}
    float calculateArea() { return length * length; }
    float calculatePeri() { return 4 * length; }
};

// circle class
class circle : public shape
{
    const float PI = 3.1415926535897;
    float radius;

public:
    circle(float r) : radius(r) {}
    float calculateArea() { return PI * radius * radius; }
    float calculatePeri() { return 2 * PI * radius; }
};

void getDetails(shape &sh)
{
    cout << "Area: " << sh.calculateArea() << endl;
    cout << "Perimeter: " << sh.calculatePeri() << endl;
}

int main()
{
    rectangle r(12.4, 5.2);
    square s(10.2);
    circle c(10.2);

    cout << "Details of Rectangle" << endl;
    getDetails(r); // calls function of rectangle

    cout << "Details of square" << endl;
    getDetails(s); // calls function of square

    cout << "Details of circle" << endl;
    getDetails(c); // calls function of circle
}