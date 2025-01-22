#include <iostream>
using namespace std;

int linear_search(int *p, int size, int number)
{
    for (int i = 0; i < size; i++)
    {
        if (number == p[i])
            return i;
    }
    return -1;
}

int binary_search(int *p, int size, int number)
{
    int begin = 0;
    int end = size - 1;
    while (begin <= end)
    {
        int mid = (begin + end) / 2;
        if (p[mid] == number)
            return mid;

        if (number < p[mid])
            end = mid - 1;
        else
            begin = mid + 1;
    }
    return -1;
}

int main()
{
    int array[10] = {12, 23, 44, 51, 77, 81, 93, 102, 117};

    // int pos = linear_search(array, 10, 69);

    int pos = binary_search(array, 10, 23);

    if (pos == -1)
        cout << "element not found" << endl;
    else
        cout << "element found at position " << pos << endl;
}