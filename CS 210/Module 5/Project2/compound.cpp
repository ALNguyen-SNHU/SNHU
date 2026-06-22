/*
Although this program is called compound.cpp, the InterestCalc class is what calculates the compound interest.
This file handles the user input and displays the results which are passed to the InterestCalc class for compound interest calculation.
Press Q to quit or Enter to continue after the input screen.

Name: Andrew L. Nguyen
Date: 04/02/2025
Time Started: 11:35 AM
*/

#include <iostream>
#include <iomanip>
#include <string>
#include <limits>           // For numeric_limits<streamsize>::max() (This is used to ignore the rest of the line until a newline character is found. This clears the input buffer. (Example: 50abc will be cleared to 50.))

using namespace std;

// This function fills the passed-in references with user input
void BankMenuInput(double& t_InitialDeposit, double& t_MonthlyDeposit, double& t_AnnualInterest, int& t_NumYears) {
    // Display header
    cout << "**********************************" << endl;
    cout << "********** Data Input ************" << endl;

    // Validate Initial Deposit
    while (true) {                                                  // Loop until valid input is received
        cout << "Initial Deposit Amount: $";
        cin >> t_InitialDeposit;                                    // Initial deposit amount (opening balance)

        if (cin.fail() || t_InitialDeposit <= 0) {                  // Check for invalid input (non-numeric or negative)
            cout << "Enter a valid positive USD amount (i.e. $21.99).\n";
            cin.clear();                                            // Clear the error flag on cin. (The error flag is when cin fails to read a value. This is set when the user enters a non-numeric value.)
            cin.ignore(numeric_limits<streamsize>::max(), '\n');    // Ignore the rest of the line until a newline character is found. This clears the input buffer. (Example: 50abc will be cleared to 50.)
        } else {
            break;
        }
    }

    // The same while loop format applies to the rest of the inputs as well.
    // Applying numeric_limits<streamsize>::max() to all inputs.

    // Validate Monthly Deposit
    while (true) {
        cout << "Monthly Deposit: $";
        cin >> t_MonthlyDeposit;

        if (cin.fail() || t_MonthlyDeposit < 0) {
            cout << "Enter a valid positive USD amount (i.e. $50.00)\n";
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        } else {
            break;
        }
    }

    // Validate Annual Interest
    while (true) {
        cout << "Annual Interest: %";
        cin >> t_AnnualInterest;

        if (cin.fail() || t_AnnualInterest < 0) {
            cout << "Enter a integer number to represent annual interest rate percentage.\n";
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        } else {
            break;
        }
    }

    // Validate Number of Years
    while (true) {
        cout << "Number of years: ";
        cin >> t_NumYears;

        if (cin.fail() || t_NumYears <= 0) {
            cout << "Please enter a valid time. (Integer)\n";
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        } else {
            break;
        }
    }

    // Pause message with Q/Enter handling
    cout << "Press Q to quit or Enter to continue...";
    cin.ignore();
    char select = cin.get();
    if (select == 'q' || select == 'Q') {
        cout << "\nQuitting program..." << endl;
        exit(0);
    }

    cout << "\nContinuing...\n" << endl;
}


