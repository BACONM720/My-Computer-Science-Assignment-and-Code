 
public class Travel_Ireland
{
   
  
    public static void Travel_Ireland(String[] args)
    {
        test1();//call tests
        test2();
        test3();
       
   }
    //test 1 is just a straight forward tes with no incorrect information
   public static void test1(){
     Bus_eireann be = new Bus_eireann();// create new bus eireann object this instantiates 
     // three Trips objects
     
     be.displayAllTrips();//display all the trips
      
     Trips selectedTrip = be.getTrip(7183);//set the selected trip by using getTrip and entring the appropriate id
     if(selectedTrip == null){
         System.out.println("That is not a valid ID, please try again.");
        }
       else{
      Booking booking = new Booking(selectedTrip, 8);//create a new booking object by pasing 
     //in the trip and the number of passenger tickets you want
     
      boolean success = be.makeBooking(booking);//set the success boolean using the makeBooking method
       
      be.makeTicketStub(booking);// create Ticket Stub for customer
     
      be.displayAllTrips();// display all the trips again and if the booking was a success 
    // the seats are decremented
   }
   } 
   // again test 2 is like test one but its city link rather than buseireann , along 
   //with different variables, but there is an incorrect trip id which is handled by the if statement
   public static void test2(){
     City_link cityLink = new City_link();
     
     cityLink.displayAllTrips();
     
     Trips selectedTrip = cityLink.getTrip(8503);
     
      if(selectedTrip == null){
         System.out.println("That is not a valid ID, please try again.");
        }
        else{
        
       Booking booking = new Booking(selectedTrip, 3);
     
     boolean success = cityLink.makeBooking(booking);
      
     cityLink.makeTicketStub(booking);
     
    cityLink.displayAllTrips();
    }
   } 
   
    //Test 3 is a test for when too many seats are booked and it should return a booking Error 
    // and not decrement the total number of available seats 
   public static void test3(){
     GoBus gb = new GoBus();
     
     gb.displayAllTrips();
 
     Trips selectedTrip = gb.getTrip(6291);
     
      if(selectedTrip == null){
         System.out.println("That is not a valid ID, please try again.");
         
        }
        else{
        
     Booking booking = new Booking(selectedTrip, 70);
     
     boolean success = gb.makeBooking(booking);
     
     gb.makeTicketStub(booking);
    
    gb.displayAllTrips();
   }
   } 

}
