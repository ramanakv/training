#include <iostream>
#include <thread>
using namespace std;

// compile the program with -pthread option
void print_numbers()
{
    for (int i = 1; i <= 10; i++)
    {
        cout << i << endl;
        this_thread::sleep_for(chrono::seconds(rand()%5));
    }
}

void print_cities(){
   string cities[] = {"Hyderabad","Chenni","Pune","Kolkatta","Mumbai","Bengaluru"};
   for (int i = 0; i < 6; i++)
    {
        cout << cities[i] << endl;
        this_thread::sleep_for(chrono::seconds(rand()%5));
    }
}
int main()
{
    thread t1(print_numbers);
    thread t2(print_cities);
    cout << "Threads started" << endl;
    t1.join();
    t2.detach();

    return 0;
}