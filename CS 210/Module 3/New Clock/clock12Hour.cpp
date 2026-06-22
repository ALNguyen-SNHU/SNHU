#include <iostream>
#include <iomanip>
#include <sstream>
#include "clock12Hour.h"

using namespace std;

// Default constructor for the 12-hour clock is set to 12 AM (12:00:00)
Clock12Hour::Clock12Hour() {
    hour = 12;
    minute = 0;
    second = 0;
    meridian = "AM";
}

// Constructor that takes a 12-hour string (e.g. "3:22:01 PM")
// NOTE: This constructor is not used in the main.cpp file
// If it were to be used, it would convert 24 hour time to 12 hour time
Clock12Hour::Clock12Hour(const string& timeStr) {
    stringstream ss(timeStr);
    char colon;
    ss >> hour >> colon >> minute >> colon >> second >> meridian;

    // Normalize meridian to uppercase
    for (char& c : meridian) c = toupper(c);

    if (ss.fail() || hour < 1 || hour > 12 || minute < 0 || minute > 59 || second < 0 || second > 59
        || (meridian != "AM" && meridian != "PM")) {
        hour = 12;
        minute = 0;
        second = 0;
        meridian = "AM";
    }
}

// Adds an hour to the 12-hour clock. If the hour reaches 12, it wraps around to 1.
void Clock12Hour::addHour() {
    hour = (hour % 12) + 1;
    if (hour == 12) {
        meridian = (meridian == "AM") ? "PM" : "AM";
    }
}

// Adds an minute to the 12-hour clock. If the minute reaches 60, it wraps around to 0 and adds an hour.
void Clock12Hour::addMinute() {
    minute++;
    if (minute == 60) {
        minute = 0;
        addHour();
    }
}

// Adds a second to the 12-hour clock. If the second reaches 60, it wraps around to 0 and adds a minute.
void Clock12Hour::addSecond() {
    second++;
    if (second == 60) {
        second = 0;
        addMinute();
    }
}

// This is the display formatter for the 12-hour clock
// Vector strings represent each line of the clock with const preventing the function from modifying any class member variables
vector<string> Clock12Hour::getDisplayLines() const {
    vector<string> lines;           // Stores each line of the clock
    ostringstream timeStream;       // Used to format time string with leading zeros (3:00:00 = 03:00:00)

    // Fills the missing leading zeros in the time string. At this point, the variables are still integers.
    timeStream << setw(2) << setfill('0') << hour << ":"            // Hour is padded with 0 if less than 2 digits + ":", given to timeStream
               << setw(2) << setfill('0') << minute << ":"
               << setw(2) << setfill('0') << second << " " << meridian;

    // Display portion of the clock
    lines.push_back("**************************");                  // Pushes lines to vector
    lines.push_back("*     12-Hour Clock      *");
    lines.push_back("*     " + timeStream.str() + "        *");     // Time string with leading zeros as a string
    lines.push_back("**************************");

    return lines;
}

// Conversion constructor (24 hour format to 12 hour format)
Clock12Hour::Clock12Hour(const Clock24Hour& clock24) {
    int h = clock24.deliverH();
    minute = clock24.deliverM();
    second = clock24.deliverS();

    meridian = (h >= 12) ? "PM" : "AM";
    hour = h % 12;
    if (hour == 0) hour = 12;
}

