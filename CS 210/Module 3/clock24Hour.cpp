/*
clock24Hour.cpp: this is the 24 hour clock class.
The 24 hour clock will be in a separate file from the 12 hour clock and main.cpp.
The 24 hour clock will have the following functions: displayTime, displayMenu, addHour, addMinute, addSecond, and exit.

Name: Andrew L. Nguyen
Date: 03/23/2021
Time Started: 9:30 AM
*/

#include <iostream> // You need to include iostream for input/output.
#include <string>   // You need to include string for string input/output. (Parsing initial time string.)
#include <vector>   // You need to include vector for clock display formatting adjacent with each other.
#include <fstream>  // You need to include fstream for file input/output. (clock24Hour.h)
#include <sstream>  // You need to include sstream for stringstream. (Parsing initial time string.)
#include <iomanip>  // You need to include iomanip for setw and setfill.
// We are using a header file to give main.cpp access to the 24 hour clock class.
#include "clock24Hour.h"

using namespace std;

// Clock 24 hour class
Clock24Hour::Clock24Hour() {    // Default constructor
    hour = 12;
    minute = 0;
    second = 0;
    // No AM or PM needed.
}
    
Clock24Hour::Clock24Hour(const string& timeStr) {   // string time input passed here
    stringstream ss(timeStr);   // timeStr = (from main.cpp) initTime
    char colon;                 // colon is the separator for the time format.

    ss >> hour >> colon >> minute >> colon >> second;   // Turns string into integers.
    // Confusion: How are the strings being turned into integers?
    // Hint: Look at the header file. The hour, minute, and second are being declared as integers.

    // If the input is not in the correct format, the default time will be used.
    if (ss.fail() || hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
        hour = 12;
        minute = 0;
        second = 0;
    }
}

Clock24Hour::Clock24Hour(int hour12, int minute12, int second12, const std::string& meridian) {
    minute = minute12;
    second = second12;

    if (meridian == "AM") {
        hour = (hour12 == 12) ? 0 : hour12;
    } else if (meridian == "PM") {
        hour = (hour12 == 12) ? 12 : hour12 + 12;
    } else {
        hour = 0; // fallback
    }
}

// Clock display function
void Clock24Hour::displayTime() const {
    cout << "**************************" << endl;
    cout << "*     24-Hour Clock      *" << endl;
    cout << "*     "
         << setw(2) << setfill('0') << hour << ":"      // You need to include iomanip for setw and setfill.
         << setw(2) << setfill('0') << minute << ":"
         << setw(2) << setfill('0') << second << "           *" << endl;
    cout << "**************************" << endl;
}

// Resolves a formatting issue with 2 clocks side by side.
// Requires <vector> and <string> for clock display formatting adjacent with each other.
std::vector<std::string> Clock24Hour::getDisplayLines() const {
    std::vector<std::string> lines;
    std::ostringstream timeStream;

    timeStream << std::setw(2) << std::setfill('0') << hour << ":"
               << std::setw(2) << std::setfill('0') << minute << ":"
               << std::setw(2) << std::setfill('0') << second;

    lines.push_back("**************************");
    lines.push_back("*     24-Hour Clock      *");
    lines.push_back("*     " + timeStream.str() + "           *");
    lines.push_back("**************************");

    return lines;
}

void Clock24Hour::displayMenu() const {
    cout << "**************************" << endl;
    cout << "* 1 - Add One Hour       *" << endl;
    cout << "* 2 - Add One Minute     *" << endl;
    cout << "* 3 - Add One Second     *" << endl;
    cout << "* 4 - Exit Program       *" << endl;
    cout << "**************************" << endl;
}

void Clock24Hour::addHour() {               // Switch case 1
    hour = (hour + 1) % 24;
}

void Clock24Hour::addMinute() {             // Switch case 2
    minute++;                               // Increment the minute.
    if (minute == 60) {
        minute = 0;
        addHour();                          // Add an hour if the minute is 60.
    }
}

void Clock24Hour::addSecond() {             // Switch case 3
    second++;
    if (second == 60) {
        second = 0;
        addMinute();
    }
}

void Clock24Hour::killClock() const {       // Switch case 4
    // Code stub
    // The code will still exit the program.
}

