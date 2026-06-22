#include <iostream>
using namespace std;

int main() {
   int numKidsA;
   int numKidsB;
   int numKidsC;
   int numFamilies;
   double avgKids;

   cin >> numKidsA;
   cin >> numKidsB;
   cin >> numKidsC;
   cin >> numFamilies;

   /* Your solution goes here  */
   avgKids = static_cast<double>(numKidsA + numKidsB + numKidsC) / static_cast<double>(numFamilies);    // Casting the integers to doubles to get a double result.

   cout << avgKids << endl;

   return 0;
}