#include <iostream>
#include <string>
using namespace std;

class Business {
   public:
      void SetName(const string& businessName) {
         name = businessName;
      }

      void SetAddress(const string& businessAddress) {
         address = businessAddress;
      }

      string GetDescription() const {
         return name + " -- " + address;
      }

   protected:
      string name;
      string address;
};

class Restaurant : public Business {
   public:
      void SetRating(int restaurantRating) {
         rating = restaurantRating;
      }

      string GetDescription() const {
         return name + " -- " + address + 
            "\n  Rating: " + to_string(rating);
      }

   private:
      int rating;
};

int main() {
   Restaurant favoritePlace;
   favoritePlace.SetName("Friends Cafe");
   favoritePlace.SetAddress("500 W 2nd Ave");
   favoritePlace.SetRating(5);
   cout << favoritePlace.GetDescription() << endl;

   return 0;
}
