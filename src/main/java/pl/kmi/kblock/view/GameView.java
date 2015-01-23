package pl.kmi.kblock.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameView extends JPanel implements Runnable, KeyListener {


    public static final int WIDTH = 320;
    public static final int HEIGHT = 240;
    public static final int SCALE = 2;

    // game thread
    private Thread gameThread;
    private boolean running;

    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    // image
    private BufferedImage image;
    private Graphics2D graphics;

    public GameView() {
        super();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setFocusable(true);
        requestFocus();
    }


    @Override
    public void run() {
        init();

        // game loop
        while (running) {
            update();
            draw();
            drawToScreen();
        }
    }

    private void update() {

    }

    private void draw() {
//        graphics.
    }

    private void drawToScreen() {
        final Graphics tempGraphics = getGraphics();
        tempGraphics.drawImage(image, 0, 0, null);
        tempGraphics.dispose();
    }



    private void init() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        running = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
