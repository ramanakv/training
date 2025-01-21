#include <iostream>
using namespace std;

class withdrawexception
{
    float amount;
    float balance;

public:
    withdrawexception(float b, float a) : balance(b), amount(a) {}

    void showMessage()
    {
        cout << "Cannot withdraw " << amount << " from balance: " << balance << endl;
    }
};

class account
{
private:
    int accountNo;
    string name;
    float balance;
    static string bankName;

public:
    account(int a, string b, float c) : accountNo(a), name(b), balance(c) {}
    void deposit(float amt);
    void withdraw(float amt);
    void showDetails();
    static void showbankName()
    {
        cout << bankName << endl;
    }
};

void account::deposit(float amt)
{
    if (amt < 100)
        throw string("Minimum deposit is Rs 100");
    balance = balance + amt;
}
void account::withdraw(float amt)
{
    if (amt > balance)
        throw withdrawexception(balance, amt); // return back to calling fuction with exception object

    balance = balance - amt;
}

void account::showDetails()
{
    cout << "Account No: " << this->accountNo << endl;
    cout << "Name: " << name << endl;
    cout << "Balance: " << balance << endl;
    cout << "Bank: " << bankName << endl;
}

string account::bankName = "HDFC Bank";

int main()
{

    account a(123, "Piyush", 4500);
    a.showDetails();
    try
    {
        a.withdraw(6000);
        cout << "==========After withdraw=========" << endl;
        a.showDetails();
    }
    catch (withdrawexception ex)
    {
        ex.showMessage();
    }
    try
    {
        a.deposit(25);
        cout << "===========After deposit========" << endl;
        a.showDetails();
    }
    catch (string s)
    {
        cout << s << endl;
    }
    a.showbankName();
    account::showbankName();
}