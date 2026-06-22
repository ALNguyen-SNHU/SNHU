/*
This header file is similar to the clock24 but adjusted for the 12 hour formatted clock.

Name: Andrew L. Nguyen
Date: 03/23/2021
Time Started: 4:00 PM
*/

#ifndef CLOCK12HOUR_H
#define CLOCK12HOUR_H

#include "allClocks.h"  // This header file is needed to access the allClocks class and its functions.
#include <string>

class Clock12Hour : public allClocks {
private:
    int hour;       // The hour, minute, and second are declared as integers.
    int minute;
    int second;
    std::string meridian;   // Meridian (AM or PM) is needed for the 12 hour clock.

public:
    Clock12Hour(); // Default constructor
    Clock12Hour(const std::string& timeStr, const std::string& mer); // Adds meridian to the constructor.

    void addHour() override;            // Switch case 1
    void addMinute() override;          // Switch case 2
    void addSecond() override;          // Switch case 3
    void displayTime() const override;
    void displayMenu() const override;
    void killClock() const override;    // Switch case 4

    // Requires <vector> and <string> to be included in the header file.
    std::vector<std::string> getDisplayLines() const override;  // Clocks adjacent with each other.
};

#endif