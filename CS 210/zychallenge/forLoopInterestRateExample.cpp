// This program shows an example of how a for loop is used in c++. Exactly the same as Java.
// The program calculates the annual savings for 10 years based on an initial savings amount and an interest rate.

#include <iostream>
using namespace std;

int main() {
   double initialSavings;  // User-entered initial savings
   double interestRate;    // Interest rate
   double currSavings;     // Current savings with interest
   int i;                  // Loop variable

   cout << "Enter initial savings: ";
   cin  >> initialSavings;

   cout << "Enter interest rate: ";
   cin  >> interestRate;

   cout << endl << "Annual savings for 10 years: " << endl;

   currSavings = initialSavings;
   for (i = 0; i < 10; ++i) {
      cout << "$" << currSavings << endl;
      currSavings = currSavings + (currSavings * interestRate);
   }

   return 0;
}