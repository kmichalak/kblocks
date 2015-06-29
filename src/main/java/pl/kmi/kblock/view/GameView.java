package pl.kmi.kblock.view;

import pl.kmi.kblock.core.model.Box;
import pl.kmi.kblock.core.model.Block;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameView extends JPanel implements Runnable, KeyListener {


    public static final int WIDTH = 600;
    public static final int HEIGHT = 860;
    public static final int SCALE = 1;

    // game thread
    private Thread gameThread;
    private boolean running;

    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    // image
    private BufferedImage image;
    private Graphics2D graphics;

    private Box boxModel;
    private GameBox gameBox;


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
            try {
                Thread.sleep(targetTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {

    }

    private void draw() {
        gameBox.draw((Graphics2D) getGraphics());
    }

    private void init() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        boxModel = new Box();
        boxModel.addBlockToBox(Block.L);
        gameBox = new GameBox(boxModel);
        gameBox.enableGrid();
        running = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT : {
                boxModel.moveBlockLeft();
                break;
            }

            case KeyEvent.VK_RIGHT : {
                boxModel.moveBlockRight();
                break;
            }

            case KeyEvent.VK_UP : {
                break;
            }

            case KeyEvent.VK_DOWN : {
                break;
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
