#ifndef CLOCK12HOUR_H   // Check for CLOCK12HOUR_H if not defined
#define CLOCK12HOUR_H   // Define CLOCK12HOUR_H

#include <string>
#include <vector>

// Include the 24-hour clock header file
#include "clock24Hour.h"

class Clock12Hour {
private:
    // Stores string input as integers
    int hour;
    int minute;
    int second;
    std::string meridian;  // "AM" or "PM"

public:
    Clock12Hour();  // Default constructor
    Clock12Hour(const std::string& timeStr); // Constructor with time input

    // general clock functions
    void addHour();
    void addMinute();
    void addSecond();

    // This function displays the clock to the left of the 24-hour clock
    std::vector<std::string> getDisplayLines() const;

    // Time sent from 24-hour clock to 12-hour clock for conversion and synchronization
    // May require implementation in the 24 hour clock file
    Clock12Hour(const Clock24Hour& clock24); // Conversion constructor

};

#endif
