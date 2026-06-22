/*
* I'm writing more comments to have a better understanding of everything again
* Test this with .csv file movies.csv
*/
import java.util.Scanner;        // Scanner to take in user input
import java.io.FileInputStream;  // May not end up being used. Used to read binary files.
import java.io.IOException;      // Files can be missing or unreadable
import java.io.File;             // Needed for scanner to read the files
import java.util.LinkedHashMap;   // Maintain insertion order for movie data
import java.util.Map;            // Map interface for key-value movie storage
import java.util.ArrayList;      // Store showtimes in arrays
import java.util.List;           // Interface for showtime storage

public class LabProgram {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);

      /* Type your code here. */
      // Prompt user for filename and read
      String filename = scnr.nextLine().trim();   // Remove extra spaces
      scnr.close();  // Close scanner after reading input
      
      // LinkedHashMap to store movie data
      // Key: title, Value: data object (this means: rating and showtimes)
      LinkedHashMap<String, MovieData> movieMap = new LinkedHashMap<>();
      
      // Try opening the CSV file
      try {
         File file = new File(filename);  // Create File object with the provided file from the user
         Scanner fileScanner = new Scanner(file);  // Scanner to read lines in file
         
         // Read each line from csv file using while loop
         while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();    // Read and trim extra white space trailing
            
            // Skip empty lines if it does not contain valid movie data
            if (line.isEmpty()) continue; // Skip these lines to prevent processing errors
            
            // Split line using comma (it's a csv file. They use commas to split data)
            String[] data = line.split(",");
            
            // CSV needs 3 elements: showtime, title, rating
            // Skip if this is not the case
            if (data.length != 3) continue;
            
            // Extract showtime, title, and rating from each row
            String showtime = data[0].trim();
            String title = data[1].trim();
            String rating = data[2].trim();
            
            // If the movie title does not exist in the map, add it
            movieMap.putIfAbsent(title, new MovieData(rating));  // Create new movie if missing
            
            // Append the showtime to the existing list of showtimes for this movie
            movieMap.get(title).addShowtime(showtime);
         }

         fileScanner.close(); // Close file scanner
      } 
      catch (IOException e) {
         // If file does not exist
         System.out.println("File not found: " + filename);
         return; // Exit program
      }

      // Print formatted output
      for (Map.Entry<String, MovieData> entry : movieMap.entrySet()) {
         String title = entry.getKey();
         MovieData movieData = entry.getValue();

         // Format title, truncate if longer than 44 characters
         String formattedTitle = String.format("%-44s", title.length() > 44 ? title.substring(0, 44) : title);
         // Format rating right-aligned
         String formattedRating = String.format("%5s", movieData.getRating());

         System.out.println(formattedTitle + " | " + formattedRating + " | " + movieData.getShowtimes());
      }
   }
}

// movie data class
// Setters and getters
class MovieData {
   private String rating;
   private List<String> showtimes;
   
   public MovieData(String rating) {
      this.rating = rating;
      this.showtimes = new ArrayList<>();
   }
   
   public void addShowtime(String showtime) {
      showtimes.add(showtime);
   }
   
   public String getRating() {
      return rating;
   }
   
   public String getShowtimes() {
      return String.join(" ", showtimes);
   }
}
