// This program shows how to use indexing to access individual characters in a string.
// The method is .at() and it is used to access individual characters in a string.

#include <iostream>
#include <string>
using namespace std;

int main() {
   string userWord;

   cout << "Enter a 5-letter word: ";
   cin  >> userWord;

   cout << "Scrambled: ";
   cout << userWord.at(3);
   cout << userWord.at(1);
   cout << userWord.at(4);
   cout << userWord.at(0);
   cout << userWord.at(2);
   cout << endl;

   return 0;
}