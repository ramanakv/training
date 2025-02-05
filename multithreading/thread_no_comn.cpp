#include <iostream>
#include <thread>
#include <mutex>
using namespace std;

// Program where there is no communication between producer and consumer threads

// variable to store one message
string message = "";

mutex m;
void read_message()
{
    for (int i = 1; i <= 6; i++)
    {
        m.lock();
        cout << "Received " << message << endl;
        m.unlock();
        this_thread::sleep_for(chrono::seconds(rand() % 5));
    }
}

void write_message()
{
    for (int i = 1; i <= 6; i++)
    {
        m.lock();
        message = string("Hello ") + to_string(i);
        cout << "Stored " << message << endl;
        m.unlock();
        this_thread::sleep_for(chrono::seconds(rand() % 5));
    }
}

int main()
{
    thread producer(write_message);
    thread consumer(read_message);
    producer.join();
    consumer.join();

    return 0;
}