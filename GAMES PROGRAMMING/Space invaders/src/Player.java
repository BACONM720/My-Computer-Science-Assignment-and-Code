import java.awt.*;

public class Player extends Sprite2D{

    public Player(Image i, Image j, int windowWidth){
        super(i,j,windowWidth);

        height = i.getHeight(null);
        width = i.getWidth(null);


    }

    public void move() {
        if(x < 0)
            x = 10;
        else if (x > 750)
            x  = 740;

        x+= xSpeed;
    }
}
