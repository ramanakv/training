#include <iostream>
using namespace std;
class employee
{
public:
    int empId;
    string name;

    void setdata(int i, string n);
    void show();
    employee() : empId(0), name("unknown") {}
    employee(int eid, string nm) : empId(eid), name(nm) {}
};

void employee::setdata(int eid, string nm)
{
    empId = eid;
    name = nm;
}

void employee::show()
{
    cout << "EmpId: " << empId << endl;
    cout << "Name: " << name << endl;
}

int main()
{

    employee a, b(111, "Alok"), c;
    // a.setdata(123, "Kumar");

    a.show();
    b.show();
    c.show();
}