// This program is the same as the switchCaseExample.cpp program, but it uses characters instead of integers.
// The program uses the fallthrough feature of the switch statement to handle both uppercase and lowercase letters.

#include <iostream>
using namespace std;

int main() {
   char origLetter;

   cin >> origLetter;

   /* Your solution goes here  */
      switch (origLetter) {
      case 'a':
      case 'A':
         cout << "Alpha" << endl;
         break;
      
      case 'b':
      case 'B':
         cout << "Beta" << endl;
         break;
      
      default:
         cout << "Unknown" << endl;
         break;
   }

   return 0;
}