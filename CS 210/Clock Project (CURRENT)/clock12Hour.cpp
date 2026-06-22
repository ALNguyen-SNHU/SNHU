/*
This is the 12 hour clock class cpp file.
*/

#include <iostream>
#include <iomanip>
#include <sstream>

// For formatting purpose, to get the clocks side by side, we need to include the following:
#include <vector>
#include <string>

#include "clock12Hour.h"

using namespace std;

// Clock 12 hour class
Clock12Hour::Clock12Hour() {    // Default constructor
    hour = 12;                  // Default time is 12:00:00 AM.
    minute = 0;
    second = 0;
    meridian = "AM";            // Default meridian is AM.
}

Clock12Hour::Clock12Hour(const std::string& timeStr, const std::string& mer) {   // 2nd argument is merdian.
    stringstream ss(timeStr);   // timeStr = (from main.cpp) initTime
    char colon;                 // colon is the separator for the time format.

    ss >> hour >> colon >> minute >> colon >> second;

    // If the input is not in the correct format, the default time will be used.
    if (ss.fail() || hour < 0 || hour > 12 || minute < 0 || minute > 59 || second < 0 || second > 59) {
        hour = 12;
        minute = 0;
        second = 0;
        meridian = "AM";
    } else {
        // The second input in main.cpp is AM or PM if the time is in the 12 hour clock format.
        meridian = mer;
        for (char& c : meridian) c = toupper(c);
        if (meridian != "AM" && meridian != "PM") {
            meridian = "AM"; // fallback
        }
    }
}

// Clock display function
void Clock12Hour::displayTime() const {
    cout << "**************************" << endl;
    cout << "*     12-Hour Clock      *" << endl;
    cout << "*     "
         << setw(2) << setfill('0') << hour << ":"
         << setw(2) << setfill('0') << minute << ":"
         << setw(2) << setfill('0') << second << " "
         << meridian << "           *" << endl;
    cout << "**************************" << endl;
}

// Requires <vector> and <string> for clock display formatting adjacent with each other.
std::vector<std::string> Clock12Hour::getDisplayLines() const {
    std::vector<std::string> lines;
    std::ostringstream timeStream;

    timeStream << std::setw(2) << std::setfill('0') << hour << ":"
               << std::setw(2) << std::setfill('0') << minute << ":"
               << std::setw(2) << std::setfill('0') << second << " " << meridian;

    lines.push_back("**************************");
    lines.push_back("*     12-Hour Clock      *");
    lines.push_back("*     " + timeStream.str() + "      *");
    lines.push_back("**************************");

    return lines;
}


void Clock12Hour::displayMenu() const {
    cout << "**************************" << endl;
    cout << "* 1 - Add One Hour       *" << endl;
    cout << "* 2 - Add One Minute     *" << endl;
    cout << "* 3 - Add One Second     *" << endl;
    cout << "* 4 - Exit Program       *" << endl;
    cout << "**************************" << endl;
}

void Clock12Hour::addHour() {               // Switch case 1
    hour = (hour % 12) + 1;                 // (12 % 12) + 1 = 1, (1 % 12) + 1 = 2, etc.
    if (hour == 12) {
        if (meridian == "AM") {
            meridian = "PM";
        } else {
            meridian = "AM";
        }
    }
}

void Clock12Hour::addMinute() {             // Switch case 2
    minute++;                               // Increment the minute.
    if (minute == 60) {
        minute = 0;
        addHour();                          // Add an hour if the minute is 60.
    }
}

void Clock12Hour::addSecond() {             // Switch case 3
    second++;
    if (second == 60) {
        second = 0;
        addMinute();
    }
}

void Clock12Hour::killClock() const {       // Switch case 4
    // Code stub
}