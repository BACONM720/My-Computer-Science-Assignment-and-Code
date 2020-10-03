
 
public class Trips 
{
    // simple class that contains all the information of our Trips
    //variables that have the information of Trips class that one would associate with a Trip
    int totalPassengers;
    String startingLocation;
    String destination;
    String dateOfDeparture;
    String timeOfDeparture;
    String dateOfArrival;
    String timeOfArrival;
    double fare;
    long id;
   public Trips(//pass all variables into Trips and then initialise the variables 
   String sl ,
   String dest,
   String dOd,
   String tOd,
   String dOa,
   String tOa,
   double f,
   int tP,
   long ID )
    {
     startingLocation  = sl;
    destination = dest;
    dateOfDeparture = dOd;
     timeOfDeparture = tOd;
     dateOfArrival = dOa;
    timeOfArrival = tOa;
     fare = f;
     totalPassengers = tP;
     id = ID;
   }
   
   public String get_s_location(){//get Method
      return startingLocation;
    }
    
   public String getDestination(){//get Method
    return destination;
    }
    
    public String get_date_of_departure(){//get Method
    return dateOfDeparture;
    }
    
   public String get_time_of_departure(){//get Method
    return timeOfDeparture;
    }
   
   public String get_date_of_arrival(){//get Method
    return dateOfArrival;
    }
    
   public String get_time_of_arrival(){//get Method
    return timeOfArrival;
    }
    
   public double get_fare(){//get Method
    return fare;
    }
    
   public int get_total_passengers(){//get Method
    return totalPassengers;
    }
    
   public long get_id(){//get Method
        return id;
    }
   
   @Override
   public String toString(){// method to print out a string of our Trips information 
 
        String out = "Starting Location:  " + startingLocation + " \nDestination:  "+  destination 
       + " \nDeparture Date:  " + dateOfDeparture + " \nTime of Departure: " + timeOfDeparture +" \nDate of Arrival: " +
       dateOfArrival + "\nTime of Arrival:  " + timeOfArrival +" \nFare: " + fare + " \nTotal Available Seats: " +
       totalPassengers + " \nID:  " + id +  "\n";
 
        return out;     
    }  
    
}
