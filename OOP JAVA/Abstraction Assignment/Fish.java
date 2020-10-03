
public abstract class Fish extends Animal
{
    boolean hasGills;
    boolean canSwim;
    boolean hasFins;
    boolean isDangerous;
    boolean isEdible;
    
    public Fish()
    { 
        super(); //calls the constructor of superclass  - Animal
        colour = "black"; //overrides the value of colour inherited from Animal
        hasFins = true; //all the subclasses of Fish inherit this property and value
        canSwim = true;  
        hasGills = true;  
        isDangerous = true;
        isEdible = true;
         
    }

    /**
     * move method overrides the move method
     * inherited from superclass Animal
     */
    @Override 
    public void move(int distance){
        if(canSwim){//check if the fish can swim, if it can print the first line else print its a fish that doesnt swim.
            System.out.printf("I swam %d metres \n", distance);
         }else{
            System.out.printf("I am a Fish but I do not Swim. I crawled %d metres \n\n", distance);
        }
    }
    
    //method bite will be inherited by subclasses of Fish and can be overidden
    public void bite(){
         System.out.println("Munch Munch");// Just a simple mehtod that prints out a generic bite noise
    }
    
    public boolean hasGills(){// getter method for hasGills
        return hasGills;
    }
     
    public boolean hasFins(){//getter method for hasFins
        return hasFins;
    }
    
    public boolean canSwim(){//getter method for canSwim
        return canSwim;
    }
    
    public boolean isDangerous(){//getter method for isDangerous
    return isDangerous;
    }
     
    public boolean isEdible(){//getter method for isEdible
    return isEdible;
    }
    // all subclasses inherit these getter methods
}

