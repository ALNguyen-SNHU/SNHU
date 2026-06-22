/*
 * Calculator.cpp
 *
 *  Date: [03/16/2025]
 *  Author: [Andrew L. Nguyen]
 *  Time Started: 4:00 PM
 */

 #include <iostream>
 #include <cctype> // Required for toupper()

 using namespace std;
 
 int main() {   // return type was originally void meaning returning nothing. Replaced with return type: int
     // char statement[100];   is completely unused
     double op1, op2;  // Needs to be able to handle both integers and decimals. Changed int to double
     char operation;
     char answer = 'Y'; // Single quotes not double quotes for characters. Spacing is important. | Forgot ;
     
     while (toupper(answer) == 'Y') {    // Spacing is importance between answer, ==, and 'Y' | handles both upper and lower case
         cout << "Enter expression" <<endl;
         cin >> op1 >> operation >> op2;    // The operands are swapped. op1 then op2. This caused 3 / 0 to be 0 / 3
         
         // They're missing their brackets
         if (operation == '+') {     // char uses single quotes, not double quotes
             cout << op1 << " + " << op2 << " = " << op1 + op2 << endl;     // NOTE: << and >> are called stream insertions. One is pointing the wrong way.
        }

         else if (operation == '-') {
             cout << op1 << " - " << op2 << " = " << op1 - op2 << endl;     //  Stream insertion is pointing the wrong way.
        }
        
        // These arithmetic operations are mix matched
         else if (operation == '*') {
             cout << op1 << " * " << op2 << " = " << op1 * op2 << endl;      // Missing ; | multiplication is done here not division. Switched out / to *
        }

        // NOTE: Attempt to divide by zero results in inf type values.
         else if (operation == '/') {
             cout << op1 << " / " << op2 << " = " << op1 / op2 << endl;      // division is done here not multiplication. Switched out * to /
         }

         cout << "Do you wish to evaluate another expression? " << endl;
         cin >> answer;
     }
     // cout << "[END OF PROGRAM]" << endl;
     cout << "Program Finished." << endl;
    
    return 0;   // Missing the return statement
 }
 