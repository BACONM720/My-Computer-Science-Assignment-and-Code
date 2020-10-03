
public class testCar
{
    public Car car;
    public Engine engine;
    public Wheel wheel;
    
    public static void testCar(String[] args)
    {
        /* Im not really sure how to get test car to work, all my created engine, wheel 
         * and car objects just says they point to null, even though i've initialised them
         * otherwise when I create a car object and run my different methods I get the 
         * correct values and all the objects link and I can inspect them and the values
         * correct, and even when I printState() all the values print correctly, so im not 
         * sure what i am doing wrong, also i felt as though im missing something in how 
         * to link the classes efficiently and correctly, as im constantly having to 
         * re-write the same function in each class in order to obtain the value, maybe
         * this is correct but I am unsure.
         */
        Car car = new Car("X7");
        Engine engine = new Engine(43 , "DR9");
        car.add(engine);
        Wheel wheel = new Wheel(15 , "Whichelin15");
        car.add(wheel);
        car.setFuel(100);
        System.out.printf("Current fuel: %.2f\n", car.fLevel);
        car.drive();
        car.printState();
        car.setFuel(50);
        System.out.printf("Current fuel: %.2f\n",car.fLevel);
        car.drive();
        car.printState();
    }
}
