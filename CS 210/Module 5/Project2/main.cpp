/*
This file is the control panel (main.cpp). It calls compound.cpp for user input and report for the report.
It first runs the displayInputScreen function to get the user input.
The user input is passed to the runInterestReport function which calculates the compound interest and displays the report.

Name: Andrew L. Nguyen
Date: 04/02/2025
Time Started: 11:35 AM
*/

#include <iostream>
using namespace std;

// Function prototypes (from the other .cpp files)
// Instantiate and create path from BankMenuInput function and pass to AirgeadCompoundReport function
// Using references to pass the same variables to the other function without making copies.
void BankMenuInput(double& t_InitialDeposit, double& t_MonthlyDeposit, double& t_AnnualInterest, int& t_NumYears);
void AirgeadCompoundReport(double t_OpeningBalance, double t_DepositAmount, double t_InterestRate, int t_Years);

// Begin display, input, and report functions
int main() {
    double initialDeposit;
    double monthlyDeposit;
    double annualInterest;
    int numYears;

    // User input function
    BankMenuInput(initialDeposit, monthlyDeposit, annualInterest, numYears);

    // Compound interest function
    AirgeadCompoundReport(initialDeposit, monthlyDeposit, annualInterest, numYears);

    return 0;
}

