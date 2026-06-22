#ifndef CLOCK24HOUR_H   // Check for CLOCK24HOUR_H if not defined
#define CLOCK24HOUR_H   // Define CLOCK24HOUR_H

#include <string>
#include <vector>

class Clock24Hour {
private:
    // Stores string input as integers
    int hour;
    int minute;
    int second;
    // Meridian does not apply to 24-hour clock (AM/PM)

public:
    Clock24Hour();  // Default constructor
    Clock24Hour(const std::string& timeStr); // Constructor that takes 24-hour string (e.g. "15:22:01")

    // General clock functions
    void addHour();
    void addMinute();
    void addSecond();

    // Public getter functions initialized used by clock 12 for conversion and synchronization
    int deliverH() const;
    int deliverM() const;
    int deliverS() const;


    // This function displays the clock to the right of the 12-hour clock
    std::vector<std::string> getDisplayLines() const;
};

#endif
