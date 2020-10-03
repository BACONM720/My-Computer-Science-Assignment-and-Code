   
 
import java.util.ArrayList;
public class Booking {
    //instance variables for class Booking
       Trips selectedTrip;
       int numPassengers;
       double totalCost;
       public Booking(Trips Trip, int nP){
           selectedTrip = Trip;// set selected trip to the trip passed into booking
           numPassengers = nP;//initialise numPassengers
        }
    
       public Trips getTrip(){//get Method
          return selectedTrip;
        }
        
       public int get_num_passengers(){//get Method
          return numPassengers;
    
       }
       
       public double getTotalCost(){// get method for cost
           totalCost += selectedTrip.get_fare() * numPassengers;//calculate total cost by 
           //multiplying the fare of the selected trip by the number of passengers that were booked
           return totalCost;//return total cost
        } 
     
}
