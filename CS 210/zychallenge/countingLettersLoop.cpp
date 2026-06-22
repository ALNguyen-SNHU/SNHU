// This program using the .isalpha() method within a for loop to determine letters in a word without counting digits, spaces, or punctuation.
// The program uses .at() within .isalpha() to access individual characters in a string then add to the counter.

#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main() {
   string inputWord;
   int numLetters;
   unsigned int i;

   cout << "Enter a word: ";
   cin  >> inputWord;

   numLetters = 0;
   for (i = 0; i < inputWord.size(); ++i) {
      if (isalpha(inputWord.at(i))) {
         numLetters += 1;
      }
   }

   cout << "Number of letters: " << numLetters << endl;

   return 0;
}