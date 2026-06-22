// HOW TO READ A NESTED FOR LOOP:

// PROGRAM:
// #include <iostream>
// using namespace std;
// int row;
// int col;

// for(row = 2; row <= 3; row = row + 1) {      // Outer loop
//    for(col = 0; col <= 1; col = col + 1) {   // Inner loop
//       cout << row << col << " ";             // Output (row << col << whitespace)
//    }
// }



// ANSWER: 20 21 30 31

// 1. The outer loop hasn't failed yet. Read the inner loop.
// 2. The inner loop hasn't failed yet. Read the cout statement.
// 3. Output: row = 2, col = 0. + "(whitespace)" .

// 4. The inner loop hasn't failed yet. Read the cout statement.
// 5. Output: row = 2, col = 1. + "(whitespace)" .

// 6. The inner loop has failed. Increment the outer loop.
// 7. The outer loop hasn't failed yet. GO BACK and read the inner loop. (NOTE: The inner loop is reset to 0)
// 8. The inner loop hasn't failed yet. Read the cout statement.
// 9. Output: row = 3, col = 0. + "(whitespace)" .

// 10. The inner loop hasn't failed yet. Read the cout statement.
// 11. Output: row = 3, col = 1. + "(whitespace)" .

// 12. The inner loop has failed. Increment the outer loop.
// (NOTE: NO OUTPUT BEYOND THIS POINT)
// 13. The outer loop has failed. End the program.