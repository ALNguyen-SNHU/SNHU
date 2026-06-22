// This program uses modulo to determine if a number is odd or even

#include <iostream>
using namespace std;

int main() {
   int userNum;
   int divRemainder;

   cout << "Enter a number: ";
   cin  >> userNum;

   divRemainder = userNum % 2;

   if (divRemainder == 0) {
       cout << userNum << " is even." << endl;
   }
   else {
       cout << userNum << " is odd." << endl;
   }

   return 0;
}