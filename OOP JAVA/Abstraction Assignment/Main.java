
public class Main
{   
    public static void Main(String[] args)
    {
        test1();
        test2();
        test3();
    }
    private static void test1()
        {
        Animal[] animals = new Animal[4];//Declare Array of size 4
        animals[0] = new Canary("JFK");// fill array with object references
        animals[1] = new Trout("Benji");
        animals[2] = new Ostrich("Lambo");
        animals[3] = new Shark("Lorry");
            for(Animal animal: animals){// loop through animals
             System.out.println(animal);// print out the animal which will automatically call the toString 
            animal.move(20);// each animal will get different outputs from move because of how i've set it up
            System.out.println("````````````````````````````````````````````````````````````````````````````````````````````````");
            System.out.println("\n");
            
        }
        
        }
         
    private static void test2()
    {
        Animal[] animals = new Animal[4];//Declare array
        animals[0] = new Canary("JFK");//fill array with animal object references
        animals[1] = new Trout("Benji");
        animals[2] = new Ostrich("Lambo");
        animals[3] = new Shark("Lorry");
        
        System.out.println("---Test 2---");
            if(animals[0].equals(animals[1]) || animals[0].equals(animals[2]) || animals[0].equals(animals[3])){
                System.out.println("animals[0] is equal to one of the objects");
             }// compare each animal to every other one and print out if its eaqual to one or not
            else{
              System.out.println("animals[0] is not equal to one of the objects");
            }
            if(animals[1].equals(animals[0]) || animals[1].equals(animals[2]) || animals[1].equals(animals[3])){
                System.out.println("animals[1] is equal to one of the objects");
            }
            else{
                System.out.println("animals[1] is not equal to one of the objects ");
            }
            if(animals[2].equals(animals[0]) || animals[2].equals(animals[1])|| animals[2].equals(animals[3])){
                System.out.println("animals[2] is equal to one of the objects");
            }
            else{
                System.out.println(" animals[2] is not equal to one of the objects");
            }
            if(animals[3].equals(animals[0])  || animals[3].equals(animals[1])|| animals[3].equals(animals[2])){
                System.out.println("animals[3] is equal to one of the objects");
            }
            else{
                System.out.println("animals[3] is not equal to one of the objects");
            }
             
             
           System.out.println("````````````````````````````````````````````````````````````````````````````````````````````````");

            
    }
    
    private static void test3(){ 
        Animal[] animals = new Animal[5];//Declare array of animals
        animals[0] = new Canary("JFK");
        animals[1] = new Canary("JFK");//Fill array with animal object Refernces
        animals[2] = new Shark("Lorry");
        animals[3] = new Shark("Lorry");
        animals[4] = new Trout("Marky Mark");
        // in this example their will be two objects equal to each other
        System.out.println("---Test 3---");
        
            if(animals[0].equals(animals[1]) || animals[0].equals(animals[2]) || animals[0].equals(animals[3]) || animals[0].equals(animals[4])){
                System.out.println("animals[0] is equal to one of the objects");
            }// compare each animal to every other one and print out if its eaqual to one or not
            else{
                System.out.println("animals[0] is not equal to one of the objects");
            }
            if(animals[1].equals(animals[0]) || animals[1].equals(animals[2]) || animals[1].equals(animals[3]) || animals[1].equals(animals[4])){
                System.out.println("animals[1] is equal to one of the objects");
            }
            else{
                System.out.println("animals[1] is not equal to one of the objects ");
            }
            if(animals[2].equals(animals[0]) || animals[2].equals(animals[1])|| animals[2].equals(animals[3])|| animals[2].equals(animals[4])){
                System.out.println("animals[2] is equal to one of the objects");
            }
            else{
                System.out.println("animals[2] is not equal to one of the objects");
            }
            if(animals[3].equals(animals[0])  || animals[3].equals(animals[1])|| animals[3].equals(animals[2])|| animals[3].equals(animals[4])){
                System.out.println("animals[3] is equal to one of the objects");
            }
            else{
                System.out.println("animals[3] is not equal to one of the objects");
            }
            if(animals[4].equals(animals[0])  || animals[4].equals(animals[1])|| animals[4].equals(animals[2])|| animals[4].equals(animals[3])){
                System.out.println("animals[4] is equal to one of the objects ");
            }
            else{
                System.out.println("animals[4] is not equal to one of the objects");
            }
             
            
        
    }
}
     
       

