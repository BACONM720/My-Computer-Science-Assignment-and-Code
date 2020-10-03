
public class Ostrich extends Bird
{
    String name;
    boolean isTall;// I put isTall in Ostrich because it dosent apply to many birds 
    public Ostrich(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "Black & Grey"; // this overrides the values inherited from Bird
        flies = false;
        isTall = true;
    }
    
    @Override  
    public void sing(){// an overrridden method from bird
        System.out.println("Bwak Bwak Bwak");
    }
    
    /**
     * toString method returns a String representation of the Ostrich
     */
    @Override
    public String toString(){//toString method to print the fields that pertain to this Ostrich
        String strng ="";
        strng+= "Ostrich: ";
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
        strng+=  hasWings();
        strng+= "\n";
        strng+= "Is this bird tall? ";
        strng+= "\n";
        strng+= isTall;
        return strng;
    }

    
    
    @Override
    public boolean equals(java.lang.Object object){
      
        if(this == object){// if the object is being compared to itself return true
            return true;
        }
            if(object instanceof Ostrich){//if the object is a Ostrich object
                Ostrich ostrich = (Ostrich) object;//cast as a Ostrich
                if(name ==  ostrich.name && colour == ostrich.colour){// if the colour & name are the same its the same object thus return true
                return true;
            }
        }
        return false; //if not equal return false
    }
    
}
