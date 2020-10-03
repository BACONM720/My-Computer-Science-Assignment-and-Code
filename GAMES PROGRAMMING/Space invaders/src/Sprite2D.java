import java.awt.*;



public  abstract class Sprite2D {
   protected int framesDrawn = 0;
    protected  int x,y;
    protected  double xSpeed = 0;
    protected Image myImage;
    protected Image myImage2;
    int winWidth;
    protected int width, height;
    protected boolean isAlive;

    public Sprite2D(Image i, Image j, int windowWidth){
        myImage = i;
        myImage2 = j;
        isAlive = true;
        winWidth = windowWidth;
    }


    public void setPosition(int xx, int yy){

        x = xx;
        y = yy;

    }


    public void setXspeed(double dx){

        xSpeed = dx;

    }

    public  void setIsAlive(boolean y){
        isAlive = y;
    }

    public boolean isAlive(){
        return !isAlive;
    }

    public void paint(Graphics g){
        framesDrawn++;
        if( framesDrawn%100<50 )
            g.drawImage(myImage, x, y, null);
        else
            g.drawImage(myImage2, x, y, null);}
    }

