
public class Wheel
{
    // instance variables
    private double radius;
    private String wheelName = "";
    private double circumference;

    public Wheel(double radius, String wheelName)
    {
       // Initialising instance variables
       circumference = 0;
       this.radius = radius;
       this.wheelName = wheelName;
    }
    
    public void setRadius(double radius)
    {
        //method to set radius
        if( radius >= 50){
        System.out.println("Come on be reasonable!!!");
    }
    else{
       this.radius = radius;
    }
    }
    
    public double getRadius()
    {
    //method to return radius
    return radius; 
    }
    
    public void setWheelName(String wheelName)
    {
        //method to set the wheels name
        this.wheelName = wheelName;
    }
    
    public String getWheelName()
    {
        //method to return the wheels name
        return wheelName;
    }
    
    public double turn()
    {
        //method to calculate the cicumference of the tire and then return, the value of
        //which will be used to calculate the distance for the engine
         circumference = 2*Math.PI*radius;
         return circumference;
    } 
}
