/*
* Docstring: This is a simple "Hello World!" program in C++.
* NOTE: My files will contain docstrings at the top of the file to explain the purpose of the code.
* The docstring is also used to identify the author of the code
* My code also tends to go HEAVY on the explanation side using comments to explain the purpose of each section of code.
* This can change if needed later.

* Author: Andrew L. Nguyen
* Date Started: 3/10/2021
* Time Started: 9:00 AM
*/

#include <iostream> // Include the input/output stream library

// The std namespace is a collection of functions and objects that are part of the C++ standard library.
// Why it is needed: Needed to avoid naming conflicts with other libraries.
// What does it do?: It allows you to use functions and objects from the standard library without having to prefix them with "std::".
using namespace std; // Use the standard namespace

int main() { // main function

    cout << "Hello World!" << endl; // Output: "Hello World!" newline and flush the buffer

    return 0; // Return 0: execution of the program
} // End of program

/*
Side note: I went through the painstaking difficulty of installing mingw-w64 on my Windows 10 machine using chocolatey to be able to compile C++ code using visual studio.
*/