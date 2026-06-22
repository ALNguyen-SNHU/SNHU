/*
The previous clock project was a mess and could not be ran.
It was very cluttered. This one is much cleaner and organized.
Explanation are much simpler and the code is easier to read.
NOTE: This version only takes in 24-hour time but a second format can easily be implemented.

Name: Andrew L. Nguyen
Date: 03/25/2025
Time started: 12:00 PM
*/

#include <iostream>
#include <vector>
// Header Files:
#include "clock24Hour.h"
#include "clock12Hour.h"

using namespace std;

int main() {
    string timeString;  // Variable to store the user's input time
    int optionSelect;   // Variable to store the user's control panel selection

    cout << "Enter a time in 24-hour format (HH:MM:SS): " << endl;
    cout << "NOTE: Colons are required" << endl;
    cin >> timeString;  // Input the time in 24-hour format
    
    // Creates a 24-hour clock object with the input time
    Clock24Hour clock24(timeString);      // Creates a 24-hour clock object
    

    // Create 12 hour clock object
    // Clock12Hour clock12(timeString);   // Unused. Timestring not in 12 hour format


    // NOTE: The 24-hour clock object is passed to the 12-hour clock object
    // It is then converted to 12-hour time and displayed
    Clock12Hour clock12(clock24);    // Creates a 12-hour clock object


    // Control panel will always show up before and until the user selects option 4 to exit the program
    do {
        // Loop the display of the clock and control panel until the user selects option 4
        
        // 2 clocks give me vectors of strings to display
        vector<string> clock24Lines = clock24.getDisplayLines();
        vector<string> clock12Lines = clock12.getDisplayLines();

        // Format clocks side by side
        for (size_t i = 0; i < clock24Lines.size(); ++i) {                  // For every line in the 24 hour clock display
            cout << clock12Lines[i] << "    " << clock24Lines[i] << endl;   // Print 12 hour format i-th clock line in vector, add 4 spaces, then print 24 hour format i-th clock line
        }                                                                   // Result: *     12-Hour Clock      *    *     24-Hour Clock      *


        // Clock control panel
        // Display the menu below the clocks
        cout << "**************************" << endl;
        cout << "* 1 - Add One Hour       *" << endl;
        cout << "* 2 - Add One Minute     *" << endl;
        cout << "* 3 - Add One Second     *" << endl;
        cout << "* 4 - Exit Program       *" << endl;
        cout << "**************************" << endl;

        // Prompt the user to select an option
        cout << "Select an option: ";
        cin >> optionSelect;

        // Control panel functions for the clock (Switch cases)
        switch (optionSelect) {
            case 1:
                clock24.addHour();
                clock12.addHour();
                break;
            case 2:
                clock24.addMinute();
                clock12.addMinute();
                break;
            case 3:
                clock24.addSecond();
                clock12.addSecond();
                break;
            case 4:
                char confirm;   // Exiting choice confirmation (based on yes or no)

                cout << "Confirm Exit? (Y/n): " << endl;
                cin >> confirm;

                // Take user input and make it uppercase
                confirm = toupper(confirm);

                if (confirm == 'Y') {
                    cout << "Program Termination..." << endl;
                } else {
                    optionSelect = 0;   // Reset the optionSelect to 0 to continue the loop
                }

                break;
            default:
                cout << "Option not available. Try again." << endl;
        }
    } while (optionSelect != 4);

    return 0;
}
