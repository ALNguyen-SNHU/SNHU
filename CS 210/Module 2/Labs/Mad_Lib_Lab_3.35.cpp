#include <iostream>
#include <string>
using namespace std;

int main() {
    string noun;    // apple, banana, carrot, shoe if you so desire.
    int number;     // amount

    cout << "Enter a noun and number i.e. apples 4" << endl; // Couldn't tell if the program was running without this.

    cin >> noun >> number;  // The program takes in the noun and number input.
    
    while (noun != "quit") {  // Reminder: The program repeats until the noun input is quit. The number is then disregarded.
        cout << "Eating " << number << " " <<  noun << " a day keeps you happy and healthy."<<endl;
        cin >> noun >> number;
    }

   // cout << "Eating " << number << " " <<  noun << " a day keeps you happy and healthy."<<endl;

   return 0;
}

// This logic works too:
// while (true) {
      
//     cin >> noun >> number;
    
//     if (noun == "quit") {
//        break;
//     }
    
//     cout << "Eating " << number << " " <<  noun << " a day keeps you happy and healthy."<<endl;
//  } 