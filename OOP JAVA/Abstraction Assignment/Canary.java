
public class Canary extends Bird
{
    // instance variables - replace the example below with your own
    String name; // the name of this Canary

    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "yellow"; // this overrides the value inherited from Bird
    }
    
      
    @Override //overridden sing method from bird superclass
     public void sing(){
        System.out.println("tweet tweet tweet");
    }
    
    /**
     * toString method returns a String representation of the bird
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= "Canary: ";
        strng+= "\n";
        strng+= "name? ";
        strng+= "\n";
        strng+= name;
        strng+= "\n";
        strng+= "colour? ";
        strng+= "\n";
        strng+= colour;
        strng+= "\n";
        strng+= "Does this bird fly? ";
        strng+= "\n";
        strng+= flies;
        strng+= "\n";
        strng+= "Does this bird have feathers? ";
        strng+= "\n";
        strng+= hasFeathers();// use the getter methods to return true or false and print that out.
        strng+= "\n";
        strng+= "Does this bird have wings? ";
        strng+= "\n";
        strng+= hasWings();
        
        return strng;
    }

   
    
    @Override
    public boolean equals(java.lang.Object object){
        if(this == object){// if the object is being compared to itself return true
            return true;
        }
            if(object instanceof Canary){//if the object is a Canary object
                Canary canary = (Canary) object;// cast as a canary object
                if(name ==  canary.name && colour == canary.colour){// if the colour & name are the same its the same object thus return true
                return true;
            }
        }
        return false; // if its not equal return false
    }
    
    
}
    
     
