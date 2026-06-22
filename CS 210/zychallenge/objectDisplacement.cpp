#include <iomanip>
#include <iostream>
using namespace std;

int main() {

   /* Your code goes here */
   double objectDisplacement;    // The output from fromula
   double objectVelocity, timeMoved;   // Your input numbers
   
   cin >> objectVelocity >> timeMoved; // Declaring and initializing in one line. Testing this out for myself.
   
   objectDisplacement = objectVelocity * timeMoved;
   
   cout << fixed << setprecision(4) << "Object displacement is " << objectDisplacement << endl;

   return 0;
} 
//  The code above is a simple program that calculates the displacement of an object. The program takes two inputs from the user, the velocity of the object and the time it has been moving. The program then calculates the displacement of the object using the formula: 
//  Displacement = Velocity * Time 
//  The program then outputs the displacement of the object. 
//  The program uses the  iomanip  library to set the precision of the output to 4 decimal places. 
//  The program uses the  fixed  manipulator to display the output in fixed-point notation. 
//  The program uses the  setprecision  manipulator to set the precision of the output to 4 decimal places. 
//  The program uses the  endl  manipulator to insert a newline character at the end of the output. 
//  The program uses the  cin  object to read input from the user. 
//  The program uses the  cout  object to write output to the console. 
//  The program uses the  <<  operator to insert data into the output stream. 
//  The program uses the  >>  operator to extract data from the input stream. 
//  The program uses the  double  data type to store floating-point numbers. 
//  The program uses the  int  data type to store integer numbers. 
//  The program uses the  main  function as the entry point of the program. 
//  The program returns 0 at the end of the  main  function to indicate successful execution. 
//  The program uses the  using namespace std;  directive to avoid having to prefix standard library functions and objects with  std:: . 
//  The program uses comments to explain the purpose of each section of code. 
//  The program uses whitespace and indentation to make the code more readable. 
//  The program uses meaningful variable names to make the code more understandable. 
//  The program uses the  double  data type to store floating-point numbers. 
//  The program uses the  cin  object to read input from the user. 
//  The program uses the  cout  object to write output to the console. 
//  The program uses the  <<  operator to insert data into the output stream. 
//  The program uses the  >>  operator to extract data from the input stream. 
//  The program uses the  fixed  manipulator to display the output in fixed-point notation. 
//  The program uses the  setprecision  manipulator to set the precision of the output to 4 decimal places. 
//  The program uses the  endl  manipulator to insert a newline character at the end of the output.