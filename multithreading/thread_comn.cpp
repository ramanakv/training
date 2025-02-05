#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>

using namespace std;

// Program where there is no communication between producer and consumer threads

// variable to store one message
string message = "";

mutex m;
condition_variable cv;

void read_message()
{
    for (int i = 1; i <= 6; i++)
    {
        unique_lock<mutex> ulock(m);
        if (message == "")
        {
            cv.wait(ulock);
        }
        cout << "Received " << message << endl;
        message = "";
        this_thread::sleep_for(chrono::seconds(rand() % 5));
        ulock.unlock();
        cv.notify_one();
    }
}

void write_message()
{
    for (int i = 1; i <= 6; i++)
    {
        unique_lock<mutex> ulock(m);

        if (message != "")
            cv.wait(ulock);

        message = string("Hello ") + to_string(i);
        cout << "Stored " << message << endl;

        this_thread::sleep_for(chrono::seconds(rand() % 5));
        ulock.unlock();
        cv.notify_one();
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