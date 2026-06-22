/* 
this file will calculate the compound interest
For every month, it will calculate the interest and add it to the closing balance
Example: Month 1: Opening balance = 1.00, DepositAmounted Amount: 50.00, Total: 51.00, Interest = 0.21, Closing balance = 51.21
Example: Month 2: Opening balance = 51.21, DepositAmounted Amount: 50.00, Total: 101.21, Interest = 0.42, Closing balance = 101.63
NOTE: The time input is in years, NOT MONTHS. The program will convert the years to months for the calculation.

Name: Andrew L. Nguyen
Date: 04/04/2025
Time Started: 2:30 PM
*/

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

class InterestCalc {
private:
    int Months;                     // Number of months for the calculation
    double OpeningBalance;          // Initial starting balance
    double DepositAmount;           // The amount deposited each month (This amount does not change continuously adding that number to the balance)
    double InterestRate;            // Rate compounded monthly (opening balance + deposit amount) * ((interest rate / 100) / 12)
    double ClosingBalance;          // Final balance after all calculations for the months
    double Total;                   // Total amount after adding the deposit amount to the opening balance

public:
    // Default constructor for calculating compound interest
    InterestCalc(double t_OpeningBalance, double t_DepositAmount, double t_InterestRate, int t_Years) {
        // Making copies of the values passed in to the constructor for good practice
        OpeningBalance = t_OpeningBalance;
        DepositAmount = t_DepositAmount;
        InterestRate = t_InterestRate;
        Months = t_Years * 12;          // Convert years to months for calculation
        ClosingBalance = 0.0;
    }

    
    // Function to calculate and display compound interest monthly (spec-compliant)
    void calculateInterest() {
        double MonthlyRate = (InterestRate / 100.0) / 12.0;     // Formula to calculate monthly interest rate from the pdf spec
        double initial = OpeningBalance;
        double ClosingBal = 0.0;

        // Display header
        cout << fixed << setprecision(2);
        cout << endl;
        cout << "Years\tOpening Balance\tDeposit\t\tTotal\t\tInterest\tClosing Balance" << endl;
        cout << "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" << endl;
        cout << "-----------------------------------------------------------------------------------------" << endl;
        cout << "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" << endl;

        for (int years = 1; years <= Months / 12; ++years) {
            double YearlyInterest = 0.0;

            for (int i = 0; i < 12; ++i) {
                // Total = initial balance + monthly deposit amount
                Total = initial + DepositAmount;
                
                // Interest = total multiplied by (interest rate / 100) / 12
                double interest = Total * MonthlyRate;
                
                // Closing balance = total + interest
                ClosingBal = Total + interest;

                // Add interest to the yearly interest (0.21 + 0.42 + 0.63 + 0.84 + 1.05 + 1.26... + 13.91 + 14.17)
                YearlyInterest += interest;
                initial = ClosingBal;
            }
            
            // Initial indentation had issues. The formatting will still be slightly off, but it will be consistent with the columns.
            cout << setw(5) << years
                << setw(15) << "$" << OpeningBalance
                << setw(15) << "$" << DepositAmount
                << setw(15) << "$" << Total
                << setw(15) << "$" << YearlyInterest
                << setw(15) << "$" << initial << endl;


            OpeningBalance = ClosingBal; // now valid, since it's declared outside
        }

        ClosingBalance = initial;
    }
};

// Main test function
// int main() {
//     // Example from the PDF spec: $1.00, $50 depositAmount, 5% interest, 5 years
//     InterestCalc calc(1.00, 50.00, 5.0, 5);
//     calc.calculateInterest();

//     return 0;
// }

// So main doesn't need to know the internals of the InterestCalc class
void AirgeadCompoundReport(double t_OpeningBalance, double t_DepositAmount, double t_InterestRate, int t_Years) {       // Function to run the interest report (called in main.cpp)
    InterestCalc calc(t_OpeningBalance, t_DepositAmount, t_InterestRate, t_Years);
    calc.calculateInterest();
}
