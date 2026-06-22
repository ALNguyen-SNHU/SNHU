// for (i = 0; i < (vctrVals.size() / 2); ++i) {
//     tmpVal = vctrVals.at(i); // These statements swap
//     vctrVals.at(i) = vctrVals.at(vctrVals.size() - 1 - i);
//     vctrVals.at(vctrVals.size() - 1 - i) = tmpVal;

// i < (vctrVals.size) / 2 example explanation:
// vector = [1, 2, 3, 4, 5]
// The size of the vector is 5, so 5 / 2 = 2.5, which is 2 because this is integer division.
// This means that indexes 0 and 1 are targets to be swapped because i doesn't go past 2.

// tmpVal = vctrVals.at(i) example explanation:
// vector = [1, 2, 3, 4, 5]
// tempVal saves the first value of the vector, which is 1.
// The second line:
// vctrVals.at(i) = vctrVals.at(vctrVals.size() - 1 - i);
// NOTE: size is 5 so vector index is 0 to 4.
// vctrVals.at(0) = size of the vector (5) - 1 = last vector entry (4) - i (0) = 4. Summary: vctrVals.at(0) = vctrVals.at(4).