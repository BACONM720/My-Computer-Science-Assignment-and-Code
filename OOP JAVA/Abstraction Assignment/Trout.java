


/**
 * Write a description of class Trout here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Trout extends Fish
{
     String name;
    boolean isBrown;// I put these three fields in trout specifically because they pertain to trout more than Fish in general
    boolean riverReproduction;
    boolean hasSpikes;
    public Trout(String name)
    {
        super(); // call the constructor of the superclass Fish
        this.name = name;
        colour = "Rainbow"; // this overrides the values inherited from Fish
        isDangerous = false;
        isBrown = true;
        hasSpikes = true;
        riverReproduction = true;
    }
    
    
     @Override// my toString method which prints out the various fields to do with this trout 
     public String toString(){
        String strng ="";
        strng+= "Trout: ";
        strng+= "\n";
        strng+= "name? ";
        strng+= "\n";
        strng+=  name;
        strng+= "\n";
        strng+= "The colour of this Trout is? ";
        strng+= "\n";
        strng+=  colour;
        strng+= "\n";
        strng+= "Does this Trout have Fins? ";
        strng+= "\n";
        strng+=  hasFins();
        strng+= "\n";
        strng+= "Does this Trout have Gills? ";
        strng+= "\n";
        strng+=  hasGills();
        strng+= "\n";
        strng+= "Can this Trout Swim? ";
        strng+= "\n";
        strng+=  canSwim();
        strng+= "\n";
        strng+= "Is this Trout dangerous? ";
        strng+= "\n";
        strng+=  isDangerous();// use the getter methods to return true or false and print that out.
        strng+= "\n";
        strng+= "Is this Trout brown? ";
        strng+= "\n";
        strng+=  getIsBrown();
        strng+= "\n";
        strng+= "Does this Trout have spikes? ";
        strng+= "\n";
        strng+=  hasSpikes;
        strng+= "\n";
        strng+= "Does this trout reproduce up river? ";
        strng+= "\n";
        strng+=  riverReproduction;
        
        return strng;// return the final string
     }
    
    @Override
    public boolean equals(java.lang.Object object){
 
        if(this == object){// if the object is being compared to itself return true
             return true;
        }
            if(object instanceof Trout){//if the object is a Trout object 
                Trout trout = (Trout) object;//cast it as a Trout object
                if(name ==  trout.name){// if the colour & name are the same its the same object thus return true
                return true;
            }
        }
        return false; //if its not equal return false
    }
    
    @Override
   public void bite(){// method that is overridding the method from its parent class Fish
    System.out.println("Nibble Nibble");
    }
         
   public boolean getIsBrown(){//simple method to check whether the trout is brown or not
    if(colour == "brown"){
        return isBrown = true;
    }
    else{
        return isBrown = false;
    }
   }
}
