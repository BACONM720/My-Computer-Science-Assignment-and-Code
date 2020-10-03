import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import  java.awt.image.*;
import java.util.ArrayList;
import java.util.Iterator;

public class InvadersApp extends JFrame implements Runnable, KeyListener {
    ImageIcon icon = new ImageIcon(workingDirectory + "\\alien_ship_1.png");
    Image alienImage = icon.getImage();
    ImageIcon icon2 = new ImageIcon(workingDirectory + "\\alien_ship_2.png");
    Image alienImage2 = icon2.getImage();

    String message;

    private int score = 0;

    int speed = 0;

    private boolean isPlaying = true;

    private boolean isGraphicsInitialised;

    private static String workingDirectory;

    private static final Dimension WindowSize = new Dimension(800, 600);

    private BufferStrategy strategy;

    private static int NUMALIENS = 30;
    private Player PlayerShip;
    private Aliens[] AliensArray = new Aliens[NUMALIENS];
    private ArrayList<bullet> bullets = new ArrayList<>(5);

    public InvadersApp() {
        //Create and set up the window.

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window, centred on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        int x = screensize.width / 2 - WindowSize.width / 2;

        int y = screensize.height / 2 - WindowSize.height / 2;

        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
        this.setTitle("Week 5");


        ImageIcon icon3 = new ImageIcon(workingDirectory + "\\player_ship.png");
        Image Ship = icon3.getImage();


        PlayerShip = new Player(Ship, Ship, 800);  Thread t = new Thread(this);
        t.start();


        addKeyListener(this);

        createBufferStrategy(2);
        strategy = getBufferStrategy();

        Graphics offScreenGraphic = strategy.getDrawGraphics();
        isGraphicsInitialised = true;


        PlayerShip.setPosition(380, 540);




    }

    public void startGame() {
        isPlaying = true;
        score  = 0;
        int xx = 0;
        int yy = 0;
        speed = 1;
        NUMALIENS = 30;
        for (int j = 0; j < NUMALIENS; j++) {

            AliensArray[j] = new Aliens(alienImage, alienImage2, 800);


            if (j % 6 == 0) {
                yy += 40;
                xx = 0;
            }

            AliensArray[j].setIsAlive(true);
            AliensArray[j].setPosition(xx = xx + 60, yy);
            Aliens.setFleetSpeed(speed);
        }
        bullets.clear();

    }

    public void startNewWave() {
        isPlaying = true;
        int xx = 0;
        int yy = 0;
        speed = speed + 1;
        NUMALIENS = 30;
        for (int j = 0; j < NUMALIENS; j++) {

            AliensArray[j] = new Aliens(alienImage, alienImage2, 800);


            if (j % 6 == 0) {
                yy += 40;
                xx = 0;
            }

            AliensArray[j].setIsAlive(true);
            AliensArray[j].setPosition(xx = xx + 60, yy);
            Aliens.setFleetSpeed(speed);
        }
        bullets.clear();

    }

    public void shootBullet() {

        ImageIcon icon4 = new ImageIcon(workingDirectory + "\\bullet.png");
        Image bulletImg = icon4.getImage();
        bullet b = new bullet(bulletImg, bulletImg, WindowSize.width);
        b.setPosition(PlayerShip.x + 54 / 2, PlayerShip.y);
        bullets.add(b);

    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(12);

            } catch (InterruptedException ignored) {

            }

            boolean move = false;

            for (int i = 0; i < NUMALIENS; i++) {
                if (AliensArray[i].move()) {
                    move = true;

                }
            }
            if (move) {
                Aliens.reverseDirection();
                for (int i = 0; i < NUMALIENS; i++)
                    AliensArray[i].moveDown();

            }
           Iterator iterator = bullets.iterator();
            while(iterator.hasNext()){
                bullet b = (bullet) iterator.next();
                b.move();
                Rectangle bul = new Rectangle(b.x, b.y, b.width, b.height);
                for (int i = 0; i < NUMALIENS; i++) {
                    Rectangle Al = new Rectangle(AliensArray[i].x, AliensArray[i].y, AliensArray[i].width, AliensArray[i].height);
                    if (bul.intersects(Al)) {
                        AliensArray[i].setIsAlive(false);
                        b.setIsAlive(false);
                        score += 10;
                    }
                }
            }

            for (int i = 0; i < NUMALIENS; i++) {
                Rectangle player = new Rectangle(PlayerShip.x, PlayerShip.y, PlayerShip.width, PlayerShip.height);
                Rectangle Al = new Rectangle(AliensArray[i].x, AliensArray[i].y, AliensArray[i].width, AliensArray[i].height);
                if (Al.intersects(player)) {
                    isPlaying = false;
                }
            }

            PlayerShip.move();
            this.repaint();

        }

    }

    private void gameOver(Graphics g) {
        isPlaying = false;
        message = "GAME OVER!!!";
        g.clearRect(0,0,800,600);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 800, 600);

        g.setColor(Color.green);
        g.fillRect(50, 250,  700, 100);
        g.setColor(Color.white);
        g.drawRect(50, 250, 700, 100);



        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g.setColor(Color.white);
        g.drawString(" FINAL SCORE: " + score,  200,200);

        g.setFont(new Font("TimesRoman", Font.BOLD, 100));
        g.setColor(Color.black);
        g.drawString("GAME OVER",  100,335);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.setColor(Color.white);
        g.drawString("PRESS ANY KEY TO START A NEW GAME",  220,400);

    }

    public void drawAliens(Graphics g) {
             for (int i = 0; i < NUMALIENS; i++) {
                AliensArray[i].paint(g);
                if (AliensArray[i].isAlive()) {
                    AliensArray = Aliens.removeTheAlien(AliensArray, i);
                    NUMALIENS--;
                }
            }
        }


    public void drawBullets(Graphics g) {

        Iterator iterator = bullets.iterator();
        while(iterator.hasNext()){
            bullet b = (bullet) iterator.next();
                b.paint(g);
                if (b.isAlive()) {
                    iterator.remove();
                }
                if (b.y <= 20) {
                    iterator.remove();
                }
            }
        }

    public void drawPlayer(Graphics g) {

            PlayerShip.paint(g);

    }

    public void drawScore(Graphics g){
        g.setColor(Color.white);
        g.drawString("SCORE: " + score,  380,40);
    }
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            PlayerShip.setXspeed(-5);
        }

        if (key == KeyEvent.VK_RIGHT) {
            PlayerShip.setXspeed(5);
        }

        if (key == KeyEvent.VK_SPACE) {
            if (bullets.size() <= 4)
                shootBullet();
        }

            if(!isPlaying){
                startGame();
            }
        }



    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {

            PlayerShip.setXspeed(0);
        }


    }

    public void keyTyped(KeyEvent e) {


    }


    public void paint(Graphics g) {
        if (!isGraphicsInitialised) {
            return;
        }

        g = strategy.getDrawGraphics();


        if(isPlaying){

            g.setColor(Color.darkGray);
            g.fillRect(0, 0, 800, 600);


            drawAliens(g);
            drawBullets(g);
            drawPlayer(g);
            drawScore(g);


            if (NUMALIENS == 0) {
                startNewWave();
            }

        }
        else{
            gameOver(g);
        }

            strategy.show();
    }

    public static void main(String[] args) {
        workingDirectory= System.getProperty("user.dir");
        System.out.println("Working Directory = "+ workingDirectory);
        InvadersApp w = new InvadersApp();
         w.startGame();
    }
}