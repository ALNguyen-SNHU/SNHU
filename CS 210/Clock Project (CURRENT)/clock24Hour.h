/*
clock24Hour.h: this is the 24 hour clock class header file.
What is the point of this header file?
The header file is used to declare the 24 hour clock class and its functions. 
This allows other files to access and use the class and its functions without needing to redefine them. 
It helps with organization and modularity in the code.
Note: This was learned. Java does not have header files. This file is similar to a default constructor in Java before it takes in parameters and makes calculations.
Note: This header files allows the main.cpp file to access the 24 hour clock class and its functions.
*/

#ifndef CLOCK24HOUR_H
#define CLOCK24HOUR_H

#include "allClocks.h"  // This header file is needed to access the allClocks class and its functions.
#include <string>
#include <vector>

class Clock24Hour : public allClocks {
private:
    int hour;       // The hour, minute, and second are declared as integers.
    int minute;
    int second;
    // Meridian (AM or PM) is not needed for the 24 hour clock.

public:
    Clock24Hour(); // Default constructor
    Clock24Hour(const std::string& timeStr); // Constructor with time input

    void addHour() override;
    void addMinute() override;
    void addSecond() override;
    void displayTime() const override;
    void displayMenu() const override;
    void killClock() const override;

    // Requires <vector> and <string> to be included in the header file.
    std::vector<std::string> getDisplayLines() const override;

    // I think this is for clock conversion purposes.
    Clock24Hour(int hour12, int minute12, int second12, const std::string& meridian);

};

#endif