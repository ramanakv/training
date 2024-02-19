#include <string>
#include <iostream>

using namespace std;

struct Node {
    string data;
    Node * next;
};

class LinkedList {

    Node * head;
    Node * tail;
    Node* MakeNode(string str);
public:

    LinkedList() {
        head = tail = NULL;
    }
    ~LinkedList();
    void AddFirst(string str);
    void AddLast(string str);
    string RemoveFirst();
    void PrintAll();
};


LinkedList::~LinkedList() {
    Node* tmp;
    while(head != NULL) {
        tmp=head;
        head = head->next;
        delete tmp;
    }
}

Node* LinkedList::MakeNode(string str) {
    Node* NewNode = new Node;
    NewNode->data = str;
    NewNode->next = NULL;
    return NewNode;
}

void  LinkedList::AddFirst(string str) {
    Node* NewNode = MakeNode(str);
    if (head == NULL) {
        head = NewNode;
        tail = NewNode;
    } else {
        NewNode->next = head;
        head = NewNode;
    }
}

void  LinkedList::AddLast(string str) {
    Node* NewNode = MakeNode(str);
    if (head == NULL) {
        head = NewNode;
        tail = NewNode;
    } else {
        tail->next = NewNode;
        tail = NewNode;
    }
}

string LinkedList::RemoveFirst() {
    if (head == NULL)
        throw string("Empty") ;
    Node * temp=head;
    string x = temp->data;
    head = head->next;
    delete temp;
    return x;
}


void LinkedList::PrintAll() {
    Node* p;
    if(head == NULL) {
        cout << "Nothing to print!! Lsit is empty" << endl;
        return;
    }

    for (p = head; p != NULL; p = p->next)
        cout << p->data << "\t";
    cout << endl;
}


