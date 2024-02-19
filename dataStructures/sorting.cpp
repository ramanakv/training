#include <iostream>

using namespace std;

void BubbleSort(int *array, int size) {
    int i, j;

    for(i = 1; (i <= size); i++) {
        for (j=0; j < (size -1); j++) {
            if (array[j+1] < array[j]) {
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
}

void InsertionSort( int *num, int size) {
    int i, j, key;
    for(i = 1; i < size; i++) {
        key = num[i];
        for(j= i - 1; (j >= 0) && ( key < num[j]); j--) {
            num[j+1] = num[j];
        }
        num[j+1] = key;    //Put key into its proper location
    }
}

void merge(int* input, int low, int high) {
    int mid = (low + high) / 2;
    int i1 = 0;
    int i2 = low;
    int i3 = mid + 1;

    // Temp array
    int temp[high-low+1];

    // Merge in sorted form the 2 arrays
    while ( i2 <= mid && i3 <= high )
        if ( input[i2] < input[i3] )
            temp[i1++] = input[i2++];
        else
            temp[i1++] = input[i3++];

    // Merge the remaining elements in left array
    while ( i2 <= mid )
        temp[i1++] = input[i2++];

    // Merge the remaining elements in right array
    while ( i3 <= high )
        temp[i1++] = input[i3++];

    // Move from temp array to master array
    for ( int i = low; i <= high; i++ )
        input[i] = temp[i-low];
}

void mergesort(int *a,  int low, int high) {
    int pivot;
    if(low<high) {
        pivot = (low+high)/2;
        mergesort(a,low,pivot);
        mergesort(a,pivot+1,high);
        merge(a,low,high);
    }
}


int main() {
    int arr[] = {23,15,65,24,87,8,5,12,90,40};
    BubbleSort(arr,10);
//    InsertionSort(arr,10);
//   mergesort(arr,0,9);


    for(int i=0; i<10; i++)
        cout << arr[i] << " " ;
    cout << endl;

}
