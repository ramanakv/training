#include <iostream>
#include <thread>
#include <mutex>
using namespace std;

// compile the program with -pthread option

int number = 0;

mutex m;
void print_numbers(string name)
{
    this_thread::sleep_for(chrono::seconds(rand() % 11));
    
    if (m.try_lock())
    {
        for (int i = 1; i <= 5; i++)
        {
            number++;
            cout << "Number incremented by " << name << " " << number << endl;
        }
    }
    else
    {
        cout << "Lock could not be acquired by " << name << endl;
    }
}


int main()
{
    thread t1(print_numbers, "t1");
    thread t2(print_numbers, "t2");
    t1.join();
    t2.join();

    return 0;
}