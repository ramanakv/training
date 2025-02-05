#include <iostream>
#include <thread>
using namespace std;

// compile the program with -pthread option

void print()
{
    
    for (int i = 1; i <= 10; i++)
    {
        cout << i << endl;

        this_thread::sleep_for(chrono::seconds(rand()%5));
    }
}



int main()
{
    thread t1(print);
    thread t2(print);
    cout << "Threads started" << endl;
    t1.join();
    t2.detach();

    return 0;
}