package pl.kmi.kblock.view;

import pl.kmi.kblock.core.model.Block;
import pl.kmi.kblock.core.model.Box;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import static java.awt.Color.BLACK;

public class Game extends Canvas implements Runnable, KeyListener {

    public static final int WIDTH = 820;
    public static final int HEIGHT = 830;
    public static final int SCALE = 1;
    public static final String NAME = "KBlock";

    private boolean running = false;

    private int blockMoveTimeout = 60;
    private int blockMoveTimer = blockMoveTimeout;

    private volatile Box box = new Box();
    private GameBox gameBox = new GameBox(box);
    private Block nextBlock = Block.T;
    private int nextBlockIndex = 0;
    private Block[] blocks = Block.values();

    private volatile boolean rotateBlock = false;

    public Game() {
        Dimension expectedSize = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setMinimumSize(expectedSize);
        setMaximumSize(expectedSize);
        setPreferredSize(expectedSize);

        setupGameFrame();
    }

    private void setupGameFrame() {
        GameWindow gameFrame = new GameWindow(NAME, this);
        gameFrame.addKeyListener(this);
        gameFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Game.this.stop();
            }
        });
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        // ~60 FPS
        double nsPerTick = 16666666.66666667D; // 1000000000D / 60D = 16666666,66666667D

        long lastTimer = System.currentTimeMillis();
        double delta = 0;

        initializeGameBox();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;

            lastTime = now;

            boolean shouldRender = false;

            while (delta >= 1) {
                tick();
                delta -= 1;

                shouldRender = true;
            }

            if (shouldRender) {
                render();
            }

            long updateRate = System.currentTimeMillis() - lastTimer;
            if (updateRate >= 1000) {
                lastTimer += 1000;
            }
        }
    }

    private void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bufferStrategy.getDrawGraphics();
        g.setColor(BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        gameBox.setNextBrick(nextBlock);
        gameBox.draw((Graphics2D) g);

        g.dispose();
        bufferStrategy.show();
    }

    private void initializeGameBox() {
        box.addBlockToBox(Block.L);
        gameBox.setWindowPadding(0);
        gameBox.enableGrid();
    }

    private void tick() {
        blockMoveTimer--;
        if (rotateBlock) {
            rotateBlock = false;
            box.rotateBlockRight();
        }
        if (blockMoveTimer == 0) {
            blockMoveTimer = blockMoveTimeout;
            if (box.canMoveBlockDown()) {
                box.moveBlockDown();
            } else {
                box.addBlockToBox(nextBlock);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT: {
                if (box.canMoveBlockLeft()) {
                    box.moveBlockLeft();
                }
                break;
            }

            case KeyEvent.VK_RIGHT: {
                if (box.canMoveBlockRight()) {
                    box.moveBlockRight();
                }
                break;
            }

            case KeyEvent.VK_UP: {
                rotateBlock = true;
                break;
            }

            case KeyEvent.VK_DOWN: {
                break;
            }

            case KeyEvent.VK_SPACE: {
                nextBlockIndex++;
                if (nextBlockIndex >= blocks.length) {
                    nextBlockIndex = 0;
                }
                nextBlock = blocks[nextBlockIndex];
                break;
            }

            case KeyEvent.VK_G: {
                if (gameBox.isGridEnabled()) {
                    gameBox.disableGrid();
                } else {
                    gameBox.enableGrid();
                }
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
