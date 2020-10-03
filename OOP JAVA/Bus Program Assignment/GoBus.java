 import java.util.ArrayList;
public class GoBus implements Booking_methods
{
    boolean success = true;// boolean to check whether a booking is successful
    private ArrayList<Trips> trips = new ArrayList<>();// arraylist to store our trips
    Booking booking;// booking object
    Trips trip1 = new Trips("Roscommon","Fermanagh","28/11/19","13:00","28/11/19",
    "15:30",4.98,20,2190);//Define three different trip objects
    Trips trip2 = new Trips("Laois","Clare","25/11/19","14:50","25/11/19",
    "18:20",12.50,48,1037);
    Trips trip3 = new Trips("Antrim","Athlone","30/11/19","21:00","30/11/19",
    "01:15",16.70,52,6291);
    
     public GoBus()
    { 
        this.booking = booking;//initialise booking
        add(trip1);// add the trips to the arraylist and initialise them when the bus-eireann object is formed
        add(trip2);
        add(trip3);
    }
    
    public void add(Trips trip){
        trips.add(trip);// method to add our trip objects to the array list
    }
    
    @Override//overide the method from booking_methods
    public void displayAllTrips(){
     int i = 1;//counter just to display trip number 
     
     for(Trips trip: trips){//for each trip loop
         System.out.println("{"+ i +"} Company: Go Bus\n" + trip );
         i++;//print out each trip by infering the toString method defined in Trips
        }

    }
    
    @Override//overide the method from booking_methods
    public Trips getTrip(int Id){//method to get the trip by passing in the appropriate trip id
        
        if(Id == 2190){//if the id is equal to one of the trips return that trip
         return trip1; 
         }
        if(Id == 1037){
          return trip2;
        }
        if(Id == 6291){
           return trip3;
        }
        else{
           return  null;
        }
    
    }
    @Override//overide the method from booking_methods
   public boolean makeBooking(Booking booking){
     // method to check whether a booking is valid or not by making sure the number of
     //passengers being booked does not exceed the number of available seats
     if(booking.get_num_passengers()  > booking.getTrip().get_total_passengers() ){
         return success = false;// return success as false and print the message defined 
         //in travel_ireland
    }
    else{
         //if everything is all right update the total available seats and return success as true
        booking.selectedTrip.totalPassengers -= booking.get_num_passengers();
        return true;
    }
   }
   @Override
    public void makeTicketStub(Booking booking){
      if(success)//if success is true print out the ticket stub
    //with some of the information
     {
      System.out.println( "\nBooking Successful");
      System.out.println("````````````````````````````````````````````````````");
      System.out.println("Number of Passengers: " + booking.get_num_passengers());
     System.out.println("Trip Details: {"+booking.getTrip().get_s_location() +
     "} to {"+ booking.getTrip().getDestination()+ "}");
     System.out.println("Trip ID: "+booking.getTrip().get_id());
     System.out.printf("Total Cost: %.2f£ \n",booking.getTotalCost());
     System.out.println("````````````````````````````````````````````````````\n\n\n\n");
    }
    else{// if success is false print out a booking error
        System.out.println("\n\nBooking Failed!!!\n\n");
    }  
    }
}
