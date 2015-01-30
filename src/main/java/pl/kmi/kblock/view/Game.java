package pl.kmi.kblock.view;

import pl.kmi.kblock.core.Box;
import pl.kmi.kblock.core.core.Block;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import static java.awt.Color.BLACK;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 420;
    public static final int HEIGHT = 840;
    public static final int SCALE = 1;
    public static final String NAME = "Tetris";

    private boolean running = false;

    private JFrame gameFrame;   // GamaVie wwill be used here
    private int tickCount = 0;

    private int blockMoveTimeout = 60;
    private int blockMoveTimer = blockMoveTimeout;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private Box box = new Box();
    private GameBox gameBox = new GameBox(box);

    public Game() {
        Dimension expectedSize = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setMinimumSize(expectedSize);
        setMaximumSize(expectedSize);
        setPreferredSize(expectedSize);

        setupGameFrame();
    }

    private void setupGameFrame() {
        gameFrame = new JFrame(NAME);
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(this, BorderLayout.CENTER);
        gameFrame.pack();
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        // ~60 FPS
        double nsPerTick = 16666666.66666667D; // 1000000000D / 60D = 16666666,66666667D

        int ticks = 0;
        int frames = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;

        initializeGameBox();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;

            lastTime = now;

            boolean shouldRender = false;

            while (delta >= 1) {
                ticks++;
                tick();
                delta -= 1;

                shouldRender = true;
            }

            if (shouldRender) {
                frames++;
                render();
            }

            long updateRate = System.currentTimeMillis() - lastTimer;
            if (updateRate >= 1000) {
                lastTimer += 1000;
                System.out.println(frames + ", " + ticks);
                frames = 0;
                ticks = 0;
            }
        }
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        gameBox.draw((Graphics2D) g);

        g.dispose();
        bs.show();
    }

    private void initializeGameBox() {
        box.addBlockToBox(Block.L);
        gameBox.setWindowPadding(0);
        gameBox.enableGrid();
    }

    private void tick() {
        tickCount++;
        blockMoveTimer--;
        if (blockMoveTimer == 0) {
            blockMoveTimer = blockMoveTimeout;
            if (box.canMoveBlockDown()) {
                box.moveBlockDown();
            } else {
                box.addBlockToBox(Block.T);
            }
        }
    }

    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }

    public synchronized void stop() {
        running = false;
    }
}
