
public class Car
{
    // instance variables flevel(fuel Level)
    private double distance;
    private double totalKm;
    public double fLevel;
    private String carName = "";
    public Engine engine;
  
    public Car(String carName)
    {
        //initialise instance variables
        distance = 0;
        totalKm = 0;
        fLevel = 0;
        this.carName = carName;
        engine = new Engine(50, "V11");
       
    }
    
     public void add(Engine engine)
    {
        //Method to add an engine object to car
        this.engine = engine;
    }
    
    public void add(Wheel wheel)
    {
        //Method to add a wheel object to car
        this.engine.wheel = wheel;
    }
   
   
    public void setCarName()
    {
        //Method to set car name
        this.carName = carName;
    }
    
    public String getCarName()
    {
        //Method to return car name
        return carName;
    } 
    
    public void drive()
    {
        //Method that calls turned which calls turn() from wheel returning the circumferenc
        //then setting distance to be engine.getDistance which returns our value after our 
        //calculation for distance
        //then update totalKm by adding the distance on
        if(fLevel<=1){
            System.out.println("No Fuel in tank");
        }
        else
        {
        engine.getRadius();
        engine.getTnT();
        engine.getTpl();
        distance  =  engine.getDistance();
        totalKm += distance;
        fLevel =  0;
    }
    }
    
    
    public void setFuel(double fuel){
        //Method that calls on a method in engine to set our fuel
        engine.setFuel(fuel);
        fLevel = fuel;
    }
    

    public void printState()
    {
      //A method in which all our values are returned and printed out in the 
      //terminal using System.out.printf statements
       System.out.printf("############################## \n");
      System.out.printf("Starting fuel: %.2f \n", engine.getFuel());
      System.out.printf("Current Fuel: %.2f \n",fLevel); 
      System.out.printf("Configuration: "+carName + "\n");
      System.out.printf("Engine name: " + engine.getEngineName() + "\n");
      System.out.printf("Engine turns per litre: %.2f \n",engine.getTpl());
      System.out.printf("Engine's total turn count: %.2f \n",engine.getTnT());
      System.out.printf("Wheel name: " + engine.wheel.getWheelName()+ "\n");
      System.out.printf("Wheel Circumference: %.2f \n",engine.wheel.turn());
      System.out.printf("Distance this trip: %.2f \n",distance);
      System.out.printf("Total Distance: %.2f \n",totalKm);
      System.out.printf("############################## \n");
    }
    
    
}
