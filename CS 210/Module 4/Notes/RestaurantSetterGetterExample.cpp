/*
The idea behind setters and getters is setting is writing a value to a class member variable.
Getting is printing out the value after it has gone through some kind of processing. (AKA: The function that gets the value)
*/

#include <iostream>
#include <string>
using namespace std;

class Restaurant {
   public:
      void   SetName(string restaurantName); // Mutator
      void   SetRating(int userRating);      // Mutator
      string GetName() const;                // Accessor
      int    GetRating() const;              // Accessor
      void   Print() const;                  // Accessor

   private:
      string name;
      int rating;
};

void Restaurant::SetName(string restaurantName) {
   name = restaurantName;
}

void Restaurant::SetRating(int userRating) {
   rating = userRating;
}

string Restaurant::GetName() const {
   return name;
}

int Restaurant::GetRating() const {
   return rating;
}

void Restaurant::Print() const {
   cout << name << " -- " << rating << endl;
}

int main() {
   Restaurant myPlace;

   myPlace.SetName("Maria's Diner");
   myPlace.SetRating(5);

   cout << myPlace.GetName() << " is rated ";
   cout << myPlace.GetRating() << endl;

   return 0;
}