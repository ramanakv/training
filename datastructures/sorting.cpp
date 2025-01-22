#include <iostream>
using namespace std;

void bubble_sort(int *p, const int size)
{

    for (int i = 1; i <= size; i++)
    {
        for (int j = 0; j < (size - i); j++)
        {
            if (p[j] > p[j + 1])
            {
                int temp = p[j];
                p[j] = p[j + 1];
                p[j + 1] = temp;
            }
        }
    }
}

void insert_sort(int *p, const int size)
{
    int temp;

    for (int i = 1; i < size; i++)
    {
        temp = p[i];
        int j;
        for (j = i - 1; j >= 0 && temp < p[j]; j--)
            p[j + 1] = p[j];

        p[j + 1] = temp;

        for (int k = 0; k < size; k++)
            cout << p[k] << "  ";
        cout << endl;
    }
}

void merge(int *p, int low, int high)
{
    int mid = (low + high) / 2;
    int i1 = low;
    int i2 = mid + 1;
    int i = 0;
    int temp[high - low + 1];

    // compare and move as long as both arrays have elements
    while (i1 <= mid && i2 <= high)
    {
        if (p[i1] < p[i2])
            temp[i++] = p[i1++];
        else
            temp[i++] = p[i2++];
    }
    // do we have elements in first array??
    while (i1 <= mid)
        temp[i++] = p[i1++];
    // do we have elements in second array ??
    while (i2 <= high)
        temp[i++] = p[i2++];

    // copy temp array into original array
    i = 0;
    for (int j = low; j <= high; j++,i++)
        p[j] = temp[i];
}

void merge_sort(int *p, int low, int high)
{

    int mid = (low + high) / 2;
    if (low < high)
    {
        merge_sort(p, low, mid);
        merge_sort(p, mid + 1, high);
        merge(p, low, high);
    }
}

int main()
{

    int array[10] = {21, 56, 16, 87, 4, 33,82,105,77,49};
    // bubble_sort(array, 6);
    //  insert_sort(array, 6);

    merge_sort(array, 0, 9);

    for (int i = 0; i < 10; i++)
        cout << array[i] << "  ";
    cout << endl;
}