#include <iostream>
using namespace std;
class person
{
    string name;
    string address;

public:
    person(string n, string a) : name(n), address(a) {}
    virtual void showDetails() = 0;
    person() : name("Ramana"), address("Hyderabad") {}
    string getName() { return name; }
    string getAddress() { return address; }
};

class employee : public person
{
    int empid;
    float salary;

public:
    employee(int eid, string nm, string add, float sal) : person(nm, add), empid(eid), salary(sal)
    {
    }
    employee() : empid(222), salary(55555) {}
    void showDetails();
};

void employee::showDetails()
{ // overriding
    cout << "EmpId: " << empid << endl;
    cout << "Name: " << getName() << endl;
    cout << "Address: " << getAddress() << endl;
    cout << "Salary: " << salary << endl;
}

class student : public person
{
    int stdid;
    float marks;

public:
    student(int sid, string nm, string add, float mks) : person(nm, add), stdid(sid), marks(mks)
    {
    }

    void showDetails();
};

void student::showDetails()
{ // overriding
    cout << "Student Id: " << stdid << endl;
    cout << "Name: " << getName() << endl;
    cout << "Address: " << getAddress() << endl;
    cout << "Marks: " << marks << endl;
}

void show(person &pr)
{

    pr.showDetails();
}

int main()
{

    employee e(100, "Anil Kumar", "Hyderabad", 45000);
    student s(100, "Sridhar", "Pune", 98.5);

    show(e);

    cout << "==================================" << endl;

    show(s);

    person *ptr;

    // ptr = &p;
    // ptr->showDetails();  // function in person class
    // cout << "==========================" << endl;
    /*
       ptr = &e;
       ptr->showDetails();  // function in employee class

        cout << "==========================" << endl;

       ptr = &s;
       ptr->showDetails();  // function in employee class
   */
}