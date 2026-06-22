/*
This is ProduceTracking.cpp
It is responsible for loading the produce data from a file and creating a backup of the data in frequency.dat.
A map is used to store the produce names and their frequencies.
A map is like a Python dictionary, allowing for easy access and manipulation of key-value pairs.
A test has been provided at the bottom to verify the functionality of the code.
This file can be tested independently of the main program.

[Name]: Andrew L. Nguyen
[Date]: 04/16/2024
[Time Started]: 6:30 PM
*/

#include <iostream>
#include <fstream>  // For file input/output
#include <map>      // Like a python dictionary for c++
#include <string>

using namespace std;

// Declare global frequencyMap
map<string, int> frequencyMap; // Map to store produce names and their frequencies

class ProduceTracker {
    private:
        // Declare private frequencyMap variable
        // map<string, int> frequencyMap; // Map to store produce names and their frequencies

        void LoadData() {
            ifstream inputFile("CS210_Project_Three_Input_File.txt");  // Open file to read
            string item;    // Each produce item read from the file as a string

            if (!inputFile) {  // If the file cannot be found or opened
                cerr << "Error: Unable to find/open input file." << endl;
                return;
            }

            // Read each produce type from the file and count its frequency
            while (inputFile >> item) {
                ++frequencyMap[item];  // Instance of item found, increment its count
            }

            inputFile.close();  // Always close the file after reading
        }

        // Create frequency.dat file as a backup of the data
        void BackUpToFile() {
            ofstream outputFile("frequency.dat");   // Open file to write

            if (!outputFile) {
                cerr << "Error: Unable to create/open output file." << endl;
                return;
            }

            for (const auto& pair : frequencyMap) {  // Iterate through the map/dictionary
                outputFile << pair.first << " " << pair.second << endl;  // pair.first: produce name, pair.second: count
            }

            // Close output file
            outputFile.close();  // Always close the file after writing
        }
    
    public:
    // Constructor for ProduceTracker
        ProduceTracker() {
            LoadData();     // Load input file data
            BackUpToFile(); // Create frequency.dat backup
        }
};

// Struct for running automatically when the program starts
struct Initializer {
    Initializer() {
        ProduceTracker tracker;     // Runs loading and backup functions
    }
};

// Trigger for initializer/constructor to run when the program starts
static Initializer initializer;

// UNCOMMENT FOR TESTING:

// // Uncomment this to test independently:
// #define TEST_PRODUCETRACKING

// #ifdef TEST_PRODUCETRACKING
// int main() {
//     cout << "Testing ProduceTracking.cpp..." << endl;

//     for (const auto& pair : frequencyMap) {
//         cout << pair.first << ": " << pair.second << endl;
//     }

//     return 0;
// }
// #endif

// NOTE: This file can be tested alone
// g++ ProduceTracking.cpp -o track_test