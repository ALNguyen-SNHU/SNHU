/*
This program reads from a file "FahrenheitTemperature.txt" that contains city names and their corresponding temperatures in Fahrenheit.
It converts the temperatures to Celsius and writes the results to a new file "CelsiusTemperature.txt".

Name: Andrew Nguyen
Date: 4/3/2025
Time started: 10:30 AM
*/

#include <iostream>
#include <fstream>      // Includes both ifstream and ofstream classes for file handling
#include <string>

using namespace std;

int main() {
    ifstream tempFahrenheitFile("FahrenheitTemperature.txt");    // Input file for reading Fahrenheit temperatures and conversion to Celsius
    string cityName;                                             // Variable to store city name 
    int temperatureF;                                            // Variable to store Fahrenheit temperature

    // File error handling in the case the file is not found
    if (!tempFahrenheitFile) {
        cerr << "Error opening file." << endl;
        return 1;       // Error code 1 indicates file opening failure
    }

    ofstream tempCelsiusFile("CelsiusTemperature.txt");      // Output file stream for writing Celsius temperatures

    // Check if output file has been created successfully
    if (!tempCelsiusFile) {
        cerr << "Error creating output file" << endl;
        return 1;       // Error code 1 indicates output file creation failure
    }

    // Read city names and temperatures from the Fahrenheit file
    while (tempFahrenheitFile >> cityName >> temperatureF) {
        // Convert Fahrenheit to Celsius using the formula: C = (F - 32) * 5/9
        double temperatureC = (temperatureF - 32) * 5.0 / 9.0;
        
        // Write the name of the city and the converted temperature to the output file
        tempCelsiusFile << cityName << " " << temperatureC << endl;
    }

    // Close the file streams
    tempFahrenheitFile.close();                                 // Close the input file stream
    tempCelsiusFile.close();                               // Close the output file stream
}