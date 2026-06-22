
// This program uses getline to read every character and white space in a string.
// While U.S.A. is still within the string input and not string::npos, (string::npos meaning the end of the string),
// .find is used to find an instance of U.S.A. and store the index in usaIndex.
// .replace is used: (start index number, number of characters to replace, string to replace with)
// U.S.A. is 6 characters long, so it is replaced with USA.

#include <iostream>
#include <string>
using namespace std;

int main() {
   string userText;
   int usaIndex;

   cout << "Enter text: ";
   getline(cin, userText);

   // At least one occurrence exists
   while (userText.find("U.S.A.") != string::npos) {
      // Get index of first instance
      usaIndex = userText.find("U.S.A.");

      // U.S.A. is 6 long
      userText.replace(usaIndex, 6, "USA");
   }

   cout << "New text: " << userText<< endl;

   return 0;
}