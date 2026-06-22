/*
ABCU Advising (Hash Table)
C++ All-in-one file
Matches the sample output wording/format and handles messy CSV (trailing commas/periods).

Name: Andrew L. Nguyen
Date: 2025-17-08
Time: 5:46 PM
Note: Partial Copilot Assistance
*/


#include <algorithm>        // Provides std::sort and other utilities (used to sort course list by course code)
#include <cctype>
#include <fstream>
#include <iostream>
#include <sstream>          // Provides std::stringstream (used for splitting lines into tokens)
#include <string>
#include <unordered_map>    // Provides hash table (key → Course mapping) for fast course lookup
#include <vector>

struct Course {
    std::string number;                   // e.g., CSCI200
    std::string title;                    // e.g., Data Structures
    std::vector<std::string> prereqs;     // e.g., {"CSCI101","MATH201"}
};



// String manipulation - helpers
// String manipulation - Removes whitespace from beginning and end of string. (" CSCI200 " = "CSCI200")
static std::string trim(const std::string& s) {
    size_t a = 0, b = s.size();
    while (a < b && std::isspace(static_cast<unsigned char>(s[a]))) ++a;
    while (b > a && std::isspace(static_cast<unsigned char>(s[b - 1]))) --b;
    return s.substr(a, b - a);
}
// String manipulation - Removes trailing periods and whitespace from string. ("Discrete Mathematics." = "Discrete Mathematics")
static std::string rstripPeriods(std::string s) {
    while (!s.empty() && (s.back() == '.' || std::isspace(static_cast<unsigned char>(s.back()))))
        s.pop_back();
    return s;
}
// String manipulation - Converts string to uppercase. ("csci200" = "CSCI200")
static std::string toUpper(std::string s) {
    for (char& c : s) c = static_cast<char>(std::toupper(static_cast<unsigned char>(c)));
    return s;
}
// String manipulation - Splits string into tokens by delimiter. ("CSCI200, Data Structures" = {"CSCI200", "Data Structures"})
static std::vector<std::string> split(const std::string& line, char delim) {
    std::vector<std::string> out;
    std::stringstream ss(line);
    std::string tok;
    while (std::getline(ss, tok, delim)) out.push_back(tok);
    return out;
}



// Load CSV into the hash table
static bool loadCourses(const std::string& filename,
                        std::unordered_map<std::string, Course>& table) {   // filename (CS 300 ABCU_Advising_Program_Input.csv), table (hash table)
    table.clear();                          // Empty old course data
    std::vector<std::string> rawLines;      // Store raw CSV lines

    // Open CSV file + Error handling for file not found or inaccessible
    std::ifstream fin(filename);
    if (!fin) {
        std::cout << "Error: Could not open file.\n";
        return false;
    }

    // Read CSV lines
    std::string line; size_t lineNo = 0;
    while (std::getline(fin, line)) {
        ++lineNo;
        line = trim(line);
        if (line.empty()) continue;

        // Tokenize the line + error handling for invalid format. (2 necessary tokens are course number and title)
        auto tokens = split(line, ',');        // simple CSV (no quotes)
        if (tokens.size() < 2) {
            std::cout << "Error (line " << lineNo << "): Course data format invalid\n";
            continue;
        }

        // Extract course information (num, title, prereqs)
        std::string num   = toUpper(trim(tokens[0]));
        std::string title = rstripPeriods(trim(tokens[1]));  // strip trailing period like "Discrete Mathematics."
        std::vector<std::string> prereqs;

        // Collect prerequisite course numbers
        for (size_t i = 2; i < tokens.size(); ++i) {
            std::string p = toUpper(trim(tokens[i]));
            if (!p.empty()) prereqs.push_back(p);            // ignore blanks from trailing commas
        }

        // Create course object. Inserts into hash table with key = course number
        Course c{num, title, std::move(prereqs)};
        table[num] = std::move(c);
        rawLines.push_back(line);
    }

    // If nothing was loaded
    if (table.empty()) {
        std::cout << "Warning: No valid courses found.\n";
        return false;
    }

    // Optional: prerequisite existence warnings (won't block running)
    for (const std::string& raw : rawLines) {
        // For each raw CSV line saved earlier, split it again into tokens
        auto toks = split(raw, ',');

        // Start at index 2 because:
        //   [0] = course number
        //   [1] = course title
        //   [2+] = prerequisites (if any)
        for (size_t i = 2; i < toks.size(); ++i) {
            
            // Clean up the prerequisite token (remove spaces, uppercase)
            std::string p = toUpper(trim(toks[i]));

            // Check if the prerequisite exists in the table
            if (!p.empty() && !table.count(p)) {
                std::cout << "Error: Missing prerequisite course " << p << "\n"; // Warn if prereq not found in table. (Will not crash program)
            }
        }
    }

    // Reaching this point means all courses were loaded successfully
    return true;
}



// print one course
static void printCourse(const std::unordered_map<std::string, Course>& table,
                        const std::string& queryRaw) {              // LOLOLOLOLOLOL

    // Trim whitespace + convert to uppercase
    std::string key = toUpper(trim(queryRaw));
    auto it = table.find(key);                  // Look up course by key
    if (it == table.end()) {                    // If not found
        std::cout << "Course not found\n";      // Inform user course doesn't exist
        return;
    }

    // Get reference to course object
    const Course& c = it->second;
    std::cout << c.number << ", " << c.title << "\n";     // Prints (course number, title)

    // Print none if no prerequisites exist
    if (c.prereqs.empty()) {
        std::cout << "Prerequisites: None\n";
        return;
    }

    // Join prereqs with ", "
    std::cout << "Prerequisites: ";
    for (size_t i = 0; i < c.prereqs.size(); ++i) {         // Loop through prerequisites in list
        std::cout << c.prereqs[i];                          // Print each prerequisite
        if (i + 1 < c.prereqs.size()) std::cout << ", ";    // Print comma if not last
    }
    std::cout << "\n";                                      // Move to next line when all prereqs have been printed
}



// print sorted courses by course code
static void printAllSorted(const std::unordered_map<std::string, Course>& table) {
    
    // Check if no courses exist
    if (table.empty()) {
        std::cout << "No data loaded.\n";
        return;
    }

    // Collect all course number (keys) from hash table
    std::vector<std::string> keys;
    keys.reserve(table.size());         // Reserve space, avoid reallocations
    for (const auto& kv : table) keys.push_back(kv.first);
    std::sort(keys.begin(), keys.end());            // alphanumeric by course code

    std::cout << "Here is a sample schedule:\n\n";

    // Print each course in the schedule
    for (const std::string& k : keys) {
        const Course& c = table.at(k);
        std::cout << c.number << ", " << c.title << "\n";
    }
}



// CONTROL PANEL
int main() {
    std::unordered_map<std::string, Course> table;
    bool loaded = false;

    std::cout << "Welcome to the course planner.\n";

    while (true) {
        std::cout << "1. Load Data Structure.\n";
        std::cout << "2. Print Course List.\n";
        std::cout << "3. Print Course.\n";
        std::cout << "9. Exit\n";
        std::cout << "What would you like to do? ";

        std::string choice;
        std::getline(std::cin, choice);

        if (choice == "1") {
            std::cout << "Enter data filename: ";
            std::string filename;
            std::getline(std::cin, filename);
            loaded = loadCourses(filename, table);
            if (loaded) std::cout << "Courses loaded successfully.\n";

        } else if (choice == "2") {
            if (!loaded || table.empty()) {
                std::cout << "Load data first (option 1).\n";
            } else {
                printAllSorted(table);
            }

        } else if (choice == "3") {
            if (!loaded || table.empty()) {
                std::cout << "Load data first (option 1).\n";
            } else {
                std::cout << "What course do you want to know about? ";
                std::string q; std::getline(std::cin, q);
                printCourse(table, q);
            }

        } else if (choice == "9") {
            std::cout << "Thank you for using the course planner!\n";
            break;

        } else {
            std::cout << choice << " is not a valid option.\n";
        }
    }
    return 0;
}
