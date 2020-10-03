 
public class Shark extends Fish
{
    String name;
    public Shark(String name)
     {
         super(); // call the constructor of the superclass Fish
        this.name = name;
        colour = "Grey"; // this overrides the value inherited from Fish
        isDangerous = true;
        isEdible = false;
    }
    
    
    @Override// my toString method which prints out the various fields to do with this shark
     public String toString(){
        String strng ="";
        strng+= "Shark: ";
        strng+= "\n";
        strng+= "name: ";
        strng+= "\n";
        strng+= name;
        strng+= "\n";
        strng+= "colour: ";
        strng+= "\n";
        strng+= colour;
        strng+= "\n";
        strng+= "Does this Shark have fins? ";
        strng+= "\n";
        strng+= hasFins();// use the getter methods to return true or false and print that out.
        strng+= "\n";
        strng+= "Does this shark have Gills";
        strng+= "\n";
        strng+=  hasGills();
        strng+= "\n";
        strng+= "Can this shark Swim? ";
        strng+= "\n";
        strng+= canSwim();
        strng+= "\n";
        strng+= "Is this shark dangerous? ";
        strng+= "\n";
        strng+= isDangerous();
        strng+= "\n";
        strng+= "Is this shark edible? ";
        strng+= "\n";
        strng+= isEdible();
        return strng;// return the entire string 
    }
    
     @Override
    public boolean equals(java.lang.Object object){
        if(this == object){
            return true;// if the object is being compared to itself return true
        }
            if(object instanceof Shark){//if the object is a shark object 
                Shark shark = (Shark) object;//cast it as a shark object
                if(name ==  shark.name && colour == shark.colour){// if the colour & name are the same its the same object thus return true
                return true;
            }
        }
        return false; //return false if it is not equal to the object
    }
    
    @Override
    public void bite(){ //An overridden method from Fish 
    System.out.println("Chomp Chomp");
    }

}