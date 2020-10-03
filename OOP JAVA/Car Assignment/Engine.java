
public class Engine
{
    // instance variables tpl(turns per litre)
    private double tpl;
    private double totalNumTurns;
    private String engineName = "";
    private double fuel;
    private double distance;
    public Wheel wheel;
    
    public Engine(double tpl,  String engineName)
    {
       //initialising all instance variables
        distance = 0;
        this.tpl = tpl;
        totalNumTurns = 0;
        this.engineName = engineName;
        fuel = 0;
        wheel = new Wheel(20, "Wichelin20");
   
    }
    
    public void setTpl (double tpl)
    {
        //method to set the turns per litre
        this.tpl = tpl;
    }
    
    public double getTpl()
    {
       //method to return the turns per litre
       return tpl;
    }
    
    public double getRadius()
    {
        //method to get the radius
        return wheel.getRadius();
    }
    
    
     public void setFuel(double fuel)
    {
       //Method to set fuel
       this.fuel = fuel;
    }
    
    public double getFuel(){
        //Method to return fuel
        return fuel;
    }
     
    public double getTnT()
     {
         //Method to calculate the total number of turns our car takes which is found by
         //multiplying fuel by the turns per litre and then returning the total
         totalNumTurns =+ (fuel * tpl); 
         return totalNumTurns;
        }
    
    public void setEngineName(String eName)
        {
            //Method to set the Engine name
            engineName = eName;
        
        }
        
     public String getEngineName()
     {
        //Method to return the engine name
        return engineName;
    }
    
    public double getDistance()
     {
           //Method to calculate the distance by calling wheel.circumference and multiplying
           //it by turns per litre and the fuel then returning the distance
           distance =  wheel.turn() * tpl * fuel;
           return distance;
        }    
        
}
