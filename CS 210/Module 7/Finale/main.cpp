/*
This program is main.cpp
It is the control panel for the Produce Tracking program.
It allows the user to select options to display item frequency, total frequency, or a histogram of produce purchases.
It uses functions from ProduceFunctions.cpp to perform these tasks.
It uses a map in ProduceTracking.cpp to create the frequency.dat file and load the data.

Name: Andrew L. Nguyen
Date: 04/16/2024
Time Started: 6:45 PM
*/

#include <iostream>
#include <string>

using namespace std;

// Declare DisplayItemFrequency, DisplayFrequencyTotal, and DisplayHistogram functions
void DisplayItemFrequency(const string& item);
void DisplayFrequencyTotal();
void DisplayHistogram();

// Optional: may need frequencyMap accessed here, extern map<string, int> frequencyMap;

int main() {
    int selection;
    string produceItem;

    // The map is loaded and frequency.dat is created by ProduceTracking.cpp

    // Display main control panel/menu FIRST. Then, prompt user for input.
    do {
        cout << "[PRODUCE TRACKING]" << endl;
        cout << "1. Display item frequency" << endl;
        cout << "2. Display frequency total" << endl;
        cout << "3. Display histogram" << endl;
        cout << "4. Exit" << endl;
        cout << "Please select an option (1-4): ";
        cin >> selection;

        // Use switch-case buttons to handle user input
        switch (selection) {
            case 1:
                cout << "Enter the produce item: ";
                cin >> produceItem;
                DisplayItemFrequency(produceItem); // Call function to display item frequency
                break;
            case 2:
                DisplayFrequencyTotal(); // Call function to display frequency total
                break;
            case 3:
                DisplayHistogram(); // Call function to display histogram
                break;
            case 4:
                cout << "Tracker Terminated." << endl; // Exit message
                break;
            default:
                cout << "Invalid selection. Please try again." << endl; // Error handling for invalid input
        }
    } while (selection != 4); // Loop until the user chooses to exit
    
    return 0;
}