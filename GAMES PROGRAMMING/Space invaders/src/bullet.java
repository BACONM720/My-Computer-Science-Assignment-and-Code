import java.awt.*;

public class bullet extends Sprite2D {

    public bullet(Image i, Image j,int windowWidth){
        super(i,j,windowWidth);
        width = i.getWidth(null);
        height = i.getHeight(null);
        isAlive = true;
    }
    public void move(){
        y-= 10;
        if(!isAlive)
            y = 0;
    }

}

