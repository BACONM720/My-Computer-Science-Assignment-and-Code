import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import  java.awt.image.*;
import java.io.*;

public class ConwayMain extends JFrame implements Runnable, MouseListener, MouseMotionListener {

    private boolean[][][] gameState = new boolean[40][40][2];
    private boolean isGraphicsInitialised;
    private boolean isPlaying;
    private BufferStrategy strategy;
    private Graphics offScreenbuffer;
    private int gameStateFrontBuffer = 0;
    private int prevx;
    private int prevy;

    public ConwayMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width / 2 - 400;
        int y = screensize.height / 2 - 400;

        setBounds(x, y,800, 800);
        setVisible(true);
        this.setTitle("Week 8");

        addMouseListener(this);
        addMouseMotionListener(this);
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        offScreenbuffer = strategy.getDrawGraphics();
        isPlaying = false;

        for (x = 0; x < 40; x++) {
            for ( y = 0; y < 40; y++) {
                gameState[x][y][0] = gameState[x][y][1] = false;
            }
        }

         isGraphicsInitialised = true;

        Thread t = new Thread(this);
        t.start();


    }
    private void saveGame() {
        String outputtext = "";
        for (int x = 0; x < 40; x++) {
            for (int y = 0; y < 40; y++) {
                if (gameState[x][y][gameStateFrontBuffer])
                    outputtext += "1";
                else
                    outputtext += "0";
            }
        }
        try {    String workingDirectory = System.getProperty("user.dir");
            String filename = workingDirectory+"\\lifegame.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(outputtext);
            writer.close();
        }    catch (IOException e) { }
    }

    private void loadGame() {
        String workingDirectory = System.getProperty("user.dir");
        String filename = workingDirectory+"\\lifegame.txt";
        String textinput = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            textinput = reader.readLine();
            reader.close();
        }    catch (IOException e) {

        }       if (textinput!=null) {
            for (int x=0;x<40;x++) {
                for (int y=0;y<40;y++) {
                    gameState[x][y][gameStateFrontBuffer] = (textinput.charAt(x*40+y)=='1');
                }
            }
        }
    }
    public void nextGeneration() {
        int front = gameStateFrontBuffer;
        int back = (front + 1) % 2;

        for (int l = 0; l < 40; l++) {
            for (int m = 0; m < 40; m++) {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i != 0 || j != 0) {
                            int ii = l + i;
                            if (ii < 0)
                                ii = 39;
                            else if (ii > 39)
                                ii = 0;
                            int jj = m + j;
                            if (jj < 0)
                                jj = 39;
                            else if (jj > 39)
                                jj = 0;
                            if (gameState[ii][jj][front])
                                aliveNeighbours++;

                        }
                    }
                }
                if(gameState[l][m][front]){

                    if(aliveNeighbours < 2)
                        gameState[l][m][back] = false;
                    else if(aliveNeighbours < 4)
                        gameState[l][m][back] = true;
                    else
                        gameState[l][m][back] = false;
                }
                else {
                    if(aliveNeighbours == 3)
                        gameState[l][m][back] = true;
                    else
                        gameState[l][m][back] = false;
                }


            }

        }
        gameStateFrontBuffer = back;
    }


        public void randomise(){
        for(int i = 0; i < 40; i++){
        for(int j = 0; j < 40; j++) {
            gameState[i][j][0] = (Math.random() < 0.25);

        }
        }

        }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int x = mouseEvent.getX()/20;
        int y = mouseEvent.getY()/20;
       if(!isPlaying) {
            if (mouseEvent.getX() >= 20 && mouseEvent.getY() >= 35 && mouseEvent.getX() <= 80 && mouseEvent.getY() <= 65) {
                isPlaying = true;
            }


            if (mouseEvent.getX() >= 90 && mouseEvent.getY() >= 35 && mouseEvent.getX() <= 180 && mouseEvent.getY() <= 65) {
                randomise();
            }

           if (mouseEvent.getX() >= 200 && mouseEvent.getY() >= 35 && mouseEvent.getX() <= 260 && mouseEvent.getY() <= 65) {
               saveGame();
           }


           if (mouseEvent.getX() >= 270 && mouseEvent.getY() >= 35 && mouseEvent.getX() <= 330 && mouseEvent.getY() <= 65) {
              loadGame();
           }

            gameState[x][y][0] = !gameState[x][y][0];

        }

       if(isPlaying) {
           nextGeneration();
       }
         this.repaint();

    }


    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX() / 20;
        int y = e.getY() / 20;
        if(!isPlaying){
        if (x != prevx || y != prevy) {
            gameState[x][y][gameStateFrontBuffer] = !gameState[x][y][gameStateFrontBuffer];
            this.repaint();
            prevx = x;
            prevy = y;
        }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    public void run() {

        while (1 == 1) {
            try {
                Thread.sleep(200);

            } catch (InterruptedException ignored) {

            }
            if(isPlaying) {

                nextGeneration();

                }
                this.repaint();
            }

        }




        public void paint(Graphics g) {
        if (!isGraphicsInitialised) {
            return;
        }

        g = offScreenbuffer;


    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 800, 800);

    g.setColor(Color.WHITE);
    for (int x = 0; x < 40; x++) {
        for (int y = 0; y < 40; y++) {
            if (gameState[x][y][gameStateFrontBuffer]) {
                g.fillRect(x * 20, y * 20, 20, 20);
            }

        }
    }

if(!isPlaying) {
    g.setColor(Color.MAGENTA);
    g.fillRect(20, 35, 60, 30);
    g.fillRect(90, 35, 70, 30);
    g.fillRect(200, 35, 60, 30);
    g.fillRect(270,35,60,30);
    g.setColor(Color.BLACK);
    g.drawString("START", 30, 60);
    g.drawString("RANDOMISE", 90, 60);
    g.drawString("SAVE", 215,60);
    g.drawString("LOAD", 285,60);
}
        strategy.show();

        }

    public static void main(String[] args){
        ConwayMain w = new ConwayMain();
    }
}

