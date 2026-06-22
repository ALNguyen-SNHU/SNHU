#include <iostream>
#include <vector>
using namespace std;

// The default input for this assignment was 5 10 4 39 12 2
// The default vector for this assignment was [10, 4, 39, 12, 2]
// The default output for this assignment was 39,12,10,4,2

/* Define your function here */
// This is hard to read.
void SortVector(vector<int>& myVec) {
   for (int i = 0; i < myVec.size(); ++i) {         // I start at the first element in the vector.
      int maxIndex = i;                             // set the maxIndex to the current element (10)
      for (int j = i + 1; j < myVec.size(); ++j) {  // I start at the NEXT element in the vector.
         if (myVec[j] > myVec[maxIndex]) {          // if the next element is greater than the current element (if 4 > 10 which is false)
            maxIndex = j;                           
         }
      }
      // outer loop: i = 0, assume maxIndex = 0 (value = 10)
    // inner loop: j = 1, compare 4 > 10 → false → stay in inner loop
    // inner loop: j = 2, compare 39 > 10 → true → maxIndex = 2
    // inner loop: j = 3, compare 12 > 39 → false
    // inner loop: j = 4, compare 2 > 39 → false
    // swap: index 0 and index 2 → myVec = {39, 4, 10, 12, 2}



    // swap: occurs after the inner loop is done
      int tempValue = myVec[i]; // hold onto this value
      myVec[i] = myVec[maxIndex];  // replace current myVec[i] with new trading spot
      myVec[maxIndex] = tempValue;      // add old myVec[i] value to old spot
   }
}

int main() {
   /* Type your code here */
   vector<int> myVec;
   int elementCount;
   
   cin >> elementCount;
   
   for (int i = 0; i < elementCount; ++i) {
      int vecValue;
      cin >> vecValue;
      myVec.push_back(vecValue);
   }
   
   SortVector(myVec);
   
   // add a comma in between each vector element
   for (int i = 0; i < myVec.size(); ++i) {
    cout << myVec[i] << ","; // DON'T ADD THE ENDL HERE PUT IT BELOW
   }
   cout << endl; // forgot this
   
   return 0;
}
