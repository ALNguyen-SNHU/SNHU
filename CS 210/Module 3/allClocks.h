/*
In the case that multiple clocks are added, this header file represents all clocks being affected by main.cpp.
This header file is used to declare the allClocks class and its functions.
All of the clocks have these functions: displayTime, displayMenu, killClock, addHour, addMinute, and addSecond.

Name: Andrew L. Nguyen
Date: 03/23/2021
Time Started: 12:30 AM (I wanted a header file that would affect all clocks.)
*/

#ifndef ALLCLOCKS_H
#define ALLCLOCKS_H

#include <vector>
#include <string>

// The allClocks class is a virtual class that has 6 functions.
// The 6 functions are displayTime, displayMenu, killClock, addHour, addMinute, and addSecond.
// The functions are declared as virtual functions, and the class is declared as a virtual class.
class allClocks {
    public:
        virtual void displayTime() const = 0;
        virtual void displayMenu() const = 0;
        virtual void killClock() const = 0;
        virtual void addHour() = 0;
        virtual void addMinute() = 0;
        virtual void addSecond() = 0;

        virtual ~allClocks() {} // Virtual destructor: allows for the deletion of the object.

        // Requires <vector> and <string> to be included in the header file.
        virtual std::vector<std::string> getDisplayLines() const = 0;
};

#endif