import java.util.Scanner;

public class DateParser {
   public static int getMonthAsInt(String monthString) {
      int monthInt;
      
      // Java switch/case statement                                                                
      switch (monthString) {
         case "January": 
            monthInt = 1; 
            break;
         case "February": 
            monthInt = 2; 
            break;
         case "March": 
            monthInt = 3; 
            break;
         case "April": 
            monthInt = 4; 
            break;
         case "May": 
            monthInt = 5; 
            break;
         case "June": 
            monthInt = 6; 
            break;
         case "July": 
            monthInt = 7; 
            break;
         case "August": 
            monthInt = 8; 
            break;
         case "September": 
            monthInt = 9; 
            break;
         case "October": 
            monthInt = 10; 
            break;
         case "November": 
            monthInt = 11; 
            break;
         case "December": 
            monthInt = 12; 
            break;
         default: 
            monthInt = 0;
      }
      
      return monthInt;  // Use this return value in the main() method
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      // TODO: Read dates from input, parse the dates to find the ones
      //       in the correct format, and output in m/d/yyyy format
      // boolean endBool = true; // This will be false if the user input is -1
      // String exit;      // .equals -1
      String input;     // User input dates
      
      while (true) {
         // read dates from input
         input = scnr.nextLine().trim();    // Read user input. Trim leading/trailing white spaces. Not the spaces between words.
         
         // Check if input exists to avoid NoSuchElementException
         if (input.equals("-1")) {
            break;
         }
         
         // Check if the input contains a valid format (e.g., March 1, 1990)
         if (!input.contains(",")) {
            continue;
         }

         // Split input into month, day, and year
         String [] dates = input.split(" ");    // array of dates
         if (parts.length != 3) {       // Check if the input has 3 string parts
            continue;   // Invalid format (Should be "Month Day, Year")
         }

         String month = dates[0];   // Get month string
         String day = dates[1].replace(",", ""); // Remove the comma from day string
         String year = dates[2];    // Get year string

         // Convert month name to integer (For the output format: m/d/yyyy, e.g., 3/1/1990)
         int monthInt = getMonthAsInt(month);
         if (monthInt == 0) {
            continue;   // Invalid month number. Skip to next date input
         }

         // Print the date in m/d/yyyy format
         System.out.println(monthInt + "/" + day + "/" + year);
      }

      scnr.close();
   }
}

/*
Description:
 * Complete main() to read dates from input, one date per line. Each date's format must be as follows: March 1, 1990. Any date not following that format is incorrect and should be ignored. Use the substring() method to parse the string and extract the date. The input ends with -1 on a line alone. Output each correct date as: 3/1/1990.

Ex: If the input is:

March 1, 1990
April 2 1995
7/15/20
December 13, 2003
-1
then the output is:

3/1/1990
12/13/2003
 */