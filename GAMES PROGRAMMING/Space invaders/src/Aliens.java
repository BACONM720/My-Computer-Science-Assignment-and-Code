
import java.awt.*;

public class Aliens extends Sprite2D {
    static double aSpeed = 0;


    public Aliens(Image i, Image j, int windowWidth) {
        super(i, j, windowWidth);
        height = i.getHeight(null);
        width = i.getWidth(null);
        isAlive = true;
    }

    public static void setFleetSpeed(double xSpeed) {
        aSpeed = xSpeed;
    }

    public static Aliens[] removeTheAlien(Aliens [] arr, int index)
    {

        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }


        Aliens[] anotherArray = new Aliens[arr.length];

        for (int i = 0, k = 0; i < arr.length; i++) {


            if (i == index) {
                continue;
            }

            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }


    public boolean move() {
        x += aSpeed;
        return x <= 0 || x >= winWidth - myImage.getWidth(null);

    }

    public void moveDown() {
        y += 60;
    }


    public static void reverseDirection() {

        aSpeed = -1 * (aSpeed);
    }

    @Override
    public void paint(Graphics g) {

       if(isAlive) {
           super.paint(g);
       }

    }
}







