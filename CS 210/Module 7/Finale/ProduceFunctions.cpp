/*
This program is ProduceFunctions.cpp
It contains the function definitions for each function within the test cases in Main.cpp.

NOTE: I believe this program is dependent on ProduceTracking.cpp for testing.
A couple times I tried to run the tests in this file, but it would not work without ProduceTracking.cpp.
This is because the frequencyMap is declared in ProduceTracking.cpp and is used in this file.

[Name]: Andrew L. Nguyen
[Date]: 04/16/2024
[Time Started]: 6:50 PM
*/

#include <iostream>
#include <map>
#include <string>

using namespace std;

// Access the frequencyMap from ProduceTracking.cpp
extern map<string, int> frequencyMap; // Declare the frequencyMap from ProduceTracking.cpp

// Function to display the frequency of a specific item
void DisplayItemFrequency(const string& item) {
    auto it = frequencyMap.find(item);  // Search for the item in the map
    if (it != frequencyMap.end()) {     // If the item is found
        cout << item << " was purchased: " << it->second << " time(s)." << endl; // [item] was purchased [count] time(s)
    } else {
        cout << "Item not found." << endl; // If the item is not found, display an error message
    }
}

// Function to display the total frequency of all items
void DisplayFrequencyTotal() {
    for (const auto& pair : frequencyMap) {                 // Iterate through the map
        cout << pair.first << ": " << pair.second << endl;  // Display each item and its frequency
    }
}

// Function to display a histogram of item frequencies
void DisplayHistogram() {
    cout << "Histogram - Produce Purchases:" << endl;    // Histogram title
    for (const auto& pair : frequencyMap) {              // Iterate through the map
        cout << pair.first << ": ";                      // Display item name
        for (int i = 0; i < pair.second; ++i) {          // For each frequency, print a star
            cout << "*";                                 // Print a star for each count
        }
        cout << endl;                                    // New line after each item
    }
}

// UNCOMMENT FOR TESTING:
// #define TEST_PRODUCEFUNCTIONS

// #ifdef TEST_PRODUCEFUNCTIONS
// int main() {
//     cout << "Testing ProduceFunctions.cpp..." << endl;

//     // Test DisplayItemFrequency function
//     cout << "Test: All Produce Item Frequencies...\n"; 
//     DisplayFrequencyTotal(); // Call the function to display all item frequencies

//     // Test DisplayHistogram function
//     cout << "Test: Print Histogram...\n"; 
//     DisplayHistogram(); // Call the function to display histogram

//     // Test DisplayItemFrequency function with a specific item
//     cout << "Test: Specified Produce Item...\n"; 
//     DisplayItemFrequency("Zucchini");       // Specified Item: Zucchini
//     DisplayItemFrequency("Tomato");         // Specified Item: Tomato

//     cout << "Test: Specified Produce Item [NOT IN FILE]\n";
//     DisplayItemFrequency("Banana");         // Specified Item: Banana (not in file)

//     return 0;
// }
// #endif // TEST_PRODUCEFUNCTIONS

// NOTE: This file needs to be tested with ProduceTracking.cpp
// g++ ProduceTracking.cpp ProduceFunctions.cpp -o test_funcs