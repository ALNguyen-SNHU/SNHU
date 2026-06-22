/*
Main.cpp: this is the control panel for the both 12 hour and 24 hour clocks. 
Start: Get user input for initial time. (We will choose to display both clocks after input entry).
Display the 4 option menu for user. Use switch and case. 1 = add hour, 2 = add minute, 3 = add second, 4 = exit.
Both clocks will be on separate files in the same directory.
12 hour clock: Use if statements to determine AM or PM.

IF the initial time includes A M or P M, take note that the initial time is in the 12 hour clock.
NOTE: This means the 12 hour format input will be 2 inputs. The first input will be the time, and the second input will be AM or PM. The 24 hour format will only have 1 input that is the time.
IF the initial time does not include A M or P M, OR the hour number is greater than 12, the initial time is in the 24 hour clock.
Clock format follows ISO 8601 standard: HH:MM:SS (MUST INCLUDE COLONS).
NOTE: Colons are the separators/de-limiters for the time format.

Name: Andrew L. Nguyen
Date: 03/23/2021
Time Started: 9:00 AM
*/

#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <iomanip>
// One of the clock files have been made: clock24Hour.cpp
#include "clock24Hour.h"
// The other clock file will be made: clock12Hour.cpp
#include "clock12Hour.h"

using namespace std;

int main() {
    int optionSelect;
    string initTime; 
    string meridian; // AM or PM for 12 hour clock format

    // These are for clock formatting purposes
    Clock12Hour* clock12 = nullptr;         // nullptr is a null pointer constant.
    Clock24Hour* clock24 = nullptr;         // declaring pointers to the clock classes.
    allClocks* clock = nullptr;             // base pointer for main menu loop


    cout << "STRICT FORMATTING POLICY [HH:MM:SS] [AM/PM]" << endl;
    cout << "Enter a 24 hour or 12 hour time format." << endl;
    cout << "Entering a time without a meridian will default to 24 hour formatting." << endl;
    cout << "Avoid putting a space between meridan characters. [i.e. avoid: a m, p m]" << endl;
    cout << "If the time you enter is invalid, time will default to 12:00:00 AM" << endl;
    cout << "Colons are required. Please enter a time: " << endl;
    cin >> initTime;



    // Peek at the next input — is it AM/PM or not?
    if (cin.peek() == ' ') {
    cin >> meridian;  // Get second input if it exists

    // Normalize meridian to uppercase (optional helper function or inline)
        for (char& c : meridian) c = toupper(c);
    } else {
        meridian = ""; // No meridian specified
    }
    


    // NOTE: PROGRAM HERE TENDS TO GET BUGGY. IF TAMPERED WITH, IT MAY CRASH.
    if (meridian == "AM" || meridian == "PM") {
        clock12 = new Clock12Hour(initTime, meridian);
    
        int h, m, s;
        char colon;
        std::stringstream ss(initTime);
        ss >> h >> colon >> m >> colon >> s;
    
        // Possible test case fix for: 13:00:00 AM
        if (ss.fail() || h < 1 || h > 12 || m < 0 || m > 59 || s < 0 || s > 59) {
            std::cout << "Invalid 12-hour input. Defaulting to 12:00:00 AM.\n";
            clock12 = new Clock12Hour("12:00:00", "AM");
            clock24 = new Clock24Hour("00:00:00");
            clock = clock12;
        } else {
            clock24 = new Clock24Hour(h, m, s, meridian); // OK here
            clock = clock12;
        }
    
    } else {
        // Parse 24-hour time
        int h, m, s;
        char colon;
        std::stringstream ss(initTime);
        ss >> h >> colon >> m >> colon >> s;
    
        // Possible test case fix for: 13:00:00 AM
        if (ss.fail() || h < 0 || h > 23 || m < 0 || m > 59 || s < 0 || s > 59) {
            std::cout << "Invalid 24-hour input. Defaulting to 12:00:00 AM.\n";
            clock24 = new Clock24Hour("00:00:00");
            clock12 = new Clock12Hour("12:00:00", "AM");
            clock = clock24;
        } else {
            // Create 24-hour clock
            clock24 = new Clock24Hour(initTime);
    
            // Convert to 12-hour time
            std::string meridian = (h >= 12) ? "PM" : "AM";
            int hour12 = h % 12;
            if (hour12 == 0) hour12 = 12;
    
            std::ostringstream new12Time;
            new12Time << std::setw(2) << std::setfill('0') << hour12 << ":"
                      << std::setw(2) << std::setfill('0') << m << ":"
                      << std::setw(2) << std::setfill('0') << s;
    
            clock12 = new Clock12Hour(new12Time.str(), meridian);
            clock = clock24;
        }
    }
    



    do {
        // clock->displayTime();
        // clock->displayMenu();

        // Show 12-hour and 24-hour clocks side-by-side
        std::vector<std::string> lines12 = clock12->getDisplayLines();
        std::vector<std::string> lines24 = clock24->getDisplayLines();

        for (size_t i = 0; i < lines12.size(); ++i) {
            std::cout << lines12[i] << "    " << lines24[i] << std::endl;
        }

        // Display menu once under both clocks
        clock->displayMenu();


        cout << "Select an option: " << endl;
        cin >> optionSelect;
        
        // Option select switch case
        switch (optionSelect) {
            case 1:
                // clock->addHour();
                clock12->addHour();
                clock24->addHour();
                break;
            case 2:
                clock12->addMinute();
                clock24->addMinute();
                break;
            case 3:
                clock12->addSecond();
                clock24->addSecond();
                break;
            case 4:
                char confirm;
                cout << "Are you sure you want to exit the program? (Y/N): ";
                cin >> confirm;
                confirm = toupper(confirm);
                
                if (confirm == 'Y') {
                    cout << "Program terminated. Have a nice day." << endl;
                    clock->killClock();     // delete the clock
                    break;
                } else {
                    cout << "Printing control panel options..." << endl;
                    optionSelect = 0;       // Reset the option select
                }
                break;
            default:
                cout << "Invalid operation. Retry entry." << endl;
                break;
        }
    }  while (optionSelect != 4);

    delete clock; // delete the clock
    return 0;
}