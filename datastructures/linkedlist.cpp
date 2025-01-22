#include <iostream>
using namespace std;
class Node
{
public:
    string name;
    Node *next;
};

class LinkedList
{
    Node *head;
    Node *tail;
    Node *makeNode(string name);

public:
    LinkedList() : head(NULL), tail(NULL) {}
    ~LinkedList();
    void addFirst(string name);
    void addLast(string name);
    string deleteFirst();
    void displayNames();
};

Node *LinkedList::makeNode(string name)
{
    Node *newNode = new Node;
    newNode->name = name;
    newNode->next = NULL;
    return newNode;
}
LinkedList::~LinkedList()
{
    Node *p;
    while (head != NULL)
    {
        p = head;
        head = head->next;
        cout << "Node with name " << p->name << " released " << endl;
        delete p;
    }
}
void LinkedList::addFirst(string name)
{
    Node *newNode = makeNode(name);
    if (head == NULL)
    {
        head = tail = newNode;
    }
    else
    {
        newNode->next = head;
        head = newNode;
    }
}
void LinkedList::addLast(string name)
{
    Node *newNode = makeNode(name);

    if (head == NULL)
    {
        head = tail = newNode;
    }
    else
    {
        tail->next = newNode;
        tail = newNode;
    }
}
string LinkedList::deleteFirst()
{
    if (head == NULL)
    {
        throw string("List is empty");
    }
    Node *tmp = head;

    head = head->next;
    string name = tmp->name;
    delete tmp;

    return name;
}

void LinkedList::displayNames()
{

    for (Node *p = head; p != NULL; p = p->next)
        cout << p->name << endl;
}

int main()
{
    LinkedList list;
    list.addLast("Suresh");
    list.addLast("Abhishek");
    list.addLast("Akrati");
    list.addLast("Alok  Jain");
    list.addFirst("Nidhi");
    list.displayNames();

    string name = list.deleteFirst();
    cout << "Deleted " << name << endl;
}