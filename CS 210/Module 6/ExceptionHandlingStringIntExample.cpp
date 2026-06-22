#include <iostream>
#include <string>
#include <limits> // for numeric_limits

using namespace std;

int main() {
    string inputName;
    int age;

    // Enable cin to throw on failbit
    cin.exceptions(ios::failbit);

    try {
        while (cin >> inputName && inputName != "-1") {
            try {
                cin >> age;
                cout << inputName << " " << (age + 1) << endl;
            } catch (ios_base::failure&) {
                // Disable exceptions to recover from failure
                cin.exceptions(ios::goodbit);
                cin.clear(); // clear failbit
                string dummy;
                cin >> dummy; // consume bad input
                cout << inputName << " 0" << endl;
                cin.ignore(numeric_limits<streamsize>::max(), '\n'); // discard rest of line
                cin.exceptions(ios::failbit); // re-enable exceptions
            }
        }
    } catch (ios_base::failure&) {
        // Graceful exit on stream failure (e.g. EOF)
    }

    return 0;
}
