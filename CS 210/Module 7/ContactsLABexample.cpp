#include <iostream>
#include <string>

using namespace std;

class ContactNode {
public:
   /* Declare member functions here */
   ContactNode(string name = "", string phone = "", ContactNode* next = nullptr) {
        contactName = name;
        contactPhoneNumber = phone;
        nextNodePtr = next;
    }
   
   // Setters (Mutators)
   /* Process:
   [person1] -> [person3]
   person1->InsertAfter(person2);
   [person1] -> [person2] -> [person3]
   */
   void InsertAfter(ContactNode* nodePtr) {
        ContactNode* temp = nextNodePtr;
        nextNodePtr = nodePtr;
        nodePtr->nextNodePtr = temp;
    }
   
   // Print contact
   /*
   ContactNode* person = new ContactNode("Alex Morgan", "555-123-4567");
   
   person->PrintContactNode();
   */
    void PrintContactNode() const {
        cout << "Name: " << contactName << endl;
        cout << "Phone number: " << contactPhoneNumber << endl;
    }
   
   // Getters (Acessors)
    string GetName() const {
        return contactName;
    }

    string GetPhoneNumber() const {
        return contactPhoneNumber;
    }

    ContactNode* GetNext() const {
        return nextNodePtr;
    }
   
private:
    string contactName;
    string contactPhoneNumber;
    ContactNode* nextNodePtr;
};

/* Define member functions here */

int main() {
   /* Type your code here. */
   // Main Section Explainations
   /*
   Alex Morgan, 555-111-2222
   Jamie Lee, 555-222-3333
   Taylor Swift, 555-333-4444
   */
   string name1, phone1;
   string name2, phone2;
   string name3, phone3;

   getline(cin, name1);
   getline(cin, phone1);
   getline(cin, name2);
   getline(cin, phone2);
   getline(cin, name3);
   getline(cin, phone3);

   /* Creates 3 linked list nodes using the name/phone values.
   Each node is created on the heap, meaning you must delete them later.
   
   [person1]  "Alex Morgan"  -> nullptr
   [person2]  "Jamie Lee"    -> nullptr
   [person3]  "Taylor Swift" -> nullptr
   */
   ContactNode* person1 = new ContactNode(name1, phone1);
   ContactNode* person2 = new ContactNode(name2, phone2);
   ContactNode* person3 = new ContactNode(name3, phone3);

   /* We connect the nodes so that it becomes one linked list.
   
   Before linking:
   [person1] -> nullptr
   [person2] -> nullptr
   [person3] -> nullptr
   
   After linking:
   [person1] -> [person2] -> [person3] -> nullptr
   */
   person1->InsertAfter(person2);
   person2->InsertAfter(person3);
   
   // Output initial details
   /*
   Person 1: Alex Morgan, 555-111-2222
   Person 2: Jamie Lee, 555-222-3333
   Person 3: Taylor Swift, 555-333-4444
   */
   cout << "Person 1: " << person1->GetName() << ", " << person1->GetPhoneNumber() << endl;
   cout << "Person 2: " << person2->GetName() << ", " << person2->GetPhoneNumber() << endl;
   cout << "Person 3: " << person3->GetName() << ", " << person3->GetPhoneNumber() << endl;

    // Output contact list
    /*
    CONTACT LIST

   Name: Alex Morgan
   Phone number: 555-111-2222

   Name: Jamie Lee
   Phone number: 555-222-3333

   Name: Taylor Swift
   Phone number: 555-333-4444

    */
    cout << "\nCONTACT LIST" << endl;
    ContactNode* current = person1;
    while (current != nullptr) {
        // cout << endl;
        current->PrintContactNode();
        current = current->GetNext();
        cout << endl;
    }

    // Free memory
    delete person1;
    delete person2;
    delete person3;
   
   return 0;
}
