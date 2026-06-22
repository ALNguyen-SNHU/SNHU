#include "clock24Hour.h"
#include <sstream>
#include <iomanip>
#include <vector>
#include <string>

using namespace std;

// Default constructor for the 24-hour clock is set to 12 AM (12:00:00)
Clock24Hour::Clock24Hour() {
    hour = 12;
    minute = 0;
    second = 0;
}

// Constructor for the 24-hour clock that takes a string in the format "HH:MM:SS"
// If the string is not in the correct format, the clock is set to 12 AM (12:00:00)
// The colons are required to input the time correctly
Clock24Hour::Clock24Hour(const string& timeStr) {
    stringstream ss(timeStr);
    char colon;
    ss >> hour >> colon >> minute >> colon >> second;       // HH:MM:SS

    if (ss.fail() || hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
        hour = 12;
        minute = 0;
        second = 0;
    }
}

// This function adds an hour to the 24 hour clock. If the hour reaches 24, it wraps around to 0.
void Clock24Hour::addHour() { hour = (hour + 1) % 24; }

// This function adds a minute to the 24 hour clock. If the minute reaches 60, it wraps around to 0 and adds an hour.
void Clock24Hour::addMinute() {
    minute++;
    if (minute == 60) {
        minute = 0;
        addHour();
    }
}

// This function adds a second to the 24 hour clock. If the second reaches 60, it wraps around to 0 and adds a minute.
void Clock24Hour::addSecond() {
    second++;
    if (second == 60) {
        second = 0;
        addMinute();
    }
}

// This is the display formatter for the 24-hour clock
vector<string> Clock24Hour::getDisplayLines() const {
    vector<string> lines;                       // Creates empty vector for strings
    ostringstream timeStream;

    timeStream << setw(2) << setfill('0') << hour << ":"        // Hour is padded with 0 if less than 2 digits + ":", given to timeStream
               << setw(2) << setfill('0') << minute << ":"
               << setw(2) << setfill('0') << second;

    lines.push_back("**************************");              // Pushes lines to vector
    lines.push_back("*     24-Hour Clock      *");
    lines.push_back("*     " + timeStream.str() + "           *");
    lines.push_back("**************************");

    return lines;
}

// Public getter functions allow usage by 12 hour clock for synchronization
int Clock24Hour::deliverH() const { return hour; }
int Clock24Hour::deliverM() const { return minute; }
int Clock24Hour::deliverS() const { return second; }
