#include <iostream>
using namespace std;

class account
{
private:
    int accountNo;
    string name;
    float balance;
    static string bankName;

public:
    friend void showName(account a);
    account(int a, string b, float c) : accountNo(a), name(b), balance(c) {}
    void deposit(float amt);
    void withdraw(float amt);
    void showDetails();
    static void showbankName(){
        cout << bankName << endl;
    }
};

void showName(account a)
{
    cout << a.name << endl;
}
void account::deposit(float amt)
{
    balance = balance + amt;
}
void account::withdraw(float amt)
{
    if (amt > balance)
    {
        cout << "Insufficient balance " << endl;
    }
    else
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

    a.withdraw(1000);

    a.showDetails();
    a.deposit(2000);
    a.showDetails();

    a.showDetails();

    account *ap = &a;
    ap->showDetails();

    showName(a);
    a.showbankName();
    account::showbankName();
}