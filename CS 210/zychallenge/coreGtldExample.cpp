#include <iostream>
#include <string>
#include <cctype>
using namespace std;                     

int main() {
   string inputName;
   string searchName;
   string coreGtld1;
   string coreGtld2;
   string coreGtld3;
   string coreGtld4;
   bool isCoreGtld;

   coreGtld1 = ".com";
   coreGtld2 = ".net";
   coreGtld3 = ".org";
   coreGtld4 = ".info";
   isCoreGtld = false;

   cout << endl << "Enter a top-level domain name: " << endl;
   cin >> inputName;
   searchName = inputName;
  
   // If the user entered a name without a leading period, add one
   if ((searchName.size() > 0) && (searchName.at(0) != '.')) {
      searchName = "." + inputName;
   }

   // Determine whether the user-entered name is a gTLD
   if (searchName == coreGtld1) {
      isCoreGtld = true;
   }
   else if (searchName == coreGtld2) {
      isCoreGtld = true;
   }
   else if (searchName == coreGtld3) {
      isCoreGtld = true;
   }
   else if (searchName == coreGtld4) {
      isCoreGtld = true;
   }
   else {
      isCoreGtld = false;
   }

   cout << "The name \"" << inputName + "\" ";
   if (isCoreGtld) {
      cout << "is a core gTLD." << endl;
   }
   else {
      cout << "is not a core gTLD." << endl;
   }

   return 0;
}