/*
 * The whole purpose of saving this code is to show how to print an array forwards and backwards.
 * Make sure to add a main method with an array of integers and a for loop to print the array forwards.
 * 
 */

import java.util.Scanner;

public class CourseGradePrinter {
   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      final int NUM_VALS = 4;   // Number of values in array limited to 4
      int [] courseGrades = new int[NUM_VALS];  // Array of course grades limited to 4 values
      int i;

      for (i = 0; i < courseGrades.length; ++i) {
         courseGrades[i] = scnr.nextInt();
      }

      /* Your solution goes here  */
      // Print forwards
      for (int j = 0; j < courseGrades.length; ++j) { // Print then count up loop
         System.out.print(courseGrades[j] + " ");
      }
      System.out.println();   // New line
      
      // Print backwards
      for (int k = courseGrades.length - 1; k >= 0; k--) {   // Print then count down loop
         System.out.print(courseGrades[k] + " ");
      }
      
   }
}

// Main method with an array of integers and a for loop to print the array forwards
public static void main(String[] args) {
   int[] myArray = {1, 2, 3, 4};
   for (int i = 0; i < myArray.length; i++) {
      System.out.print(myArray[i] + " ");
   }
   System.out.println();
}