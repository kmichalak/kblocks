package pl.kmi.kblock.view;

import pl.kmi.kblock.core.model.Box;
import pl.kmi.kblock.core.model.Block;

import java.awt.*;

import static java.awt.Color.green;

public class GameBox extends GameObject {

    public static final int WINDOW_PADDING = 10;

    private int windowPadding = WINDOW_PADDING;
    private final int boxWidth;
    private final int boxHeight;
    private Box boxModel;
    private int boxModelWidth;
    private int boxModelHeight;
    private boolean drawGrid;

    private int scale = 40;
    private Block nextBrick;
    private Block currentBrick;

    public GameBox(Box boxModel) {
        this.boxModel = boxModel;
        boxModelWidth = boxModel.getWidth();
        boxModelHeight = boxModel.getHeight();

        boxWidth = boxModelWidth * scale;
        boxHeight = boxModelHeight * scale;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        drawBoxWithContent(graphics2D);
        drawCurrentBlock(graphics2D);
        drawNextItem(graphics2D);
        if (drawGrid) {
            drawGrid(graphics2D);
        }
    }

    private void drawNextItem(Graphics2D graphics2D) {
        Color originalColor = graphics2D.getColor();
        drawNextBrick(graphics2D);
        graphics2D.setColor(originalColor);
    }

    private void drawNextBrick(Graphics2D graphics2D) {
        if (nextBrick != null) {
            int[][] nextBrickMatrix = nextBrick.getMatrix();
            for (int rowNumber = 0; rowNumber < nextBrickMatrix.length; rowNumber++) {
                for (int colNumber = 0; colNumber < nextBrickMatrix[0].length; colNumber++) {
                    if (nextBrickMatrix[rowNumber][colNumber] == 1) {
                        graphics2D.setColor(Color.RED);
                    } else {
                        graphics2D.setColor(Color.BLACK);
                    }
                    graphics2D.fillRect(colNumber * scale + 500, rowNumber * scale + 100, scale, scale);
                }
            }
        }
    }

    private void drawBoxWithContent(Graphics2D graphics2D) {
        Color originalColor = graphics2D.getColor();
        drawBoxContentBlocks(graphics2D);
        graphics2D.setColor(originalColor);
    }

    private void drawCurrentBlock(Graphics2D graphics2D) {
        Color originalColor = graphics2D.getColor();
        drawBlock(graphics2D);
        graphics2D.setColor(originalColor);
    }

    private void drawBoxContentBlocks(Graphics2D graphics2D) {
        for (int rowNumber = 0; rowNumber < boxModelHeight; rowNumber++) {
            for (int colNumber = 0; colNumber < boxModelWidth; colNumber++) {
                if (boxModel.getMatrix()[rowNumber][colNumber] == 1) {
                    graphics2D.setColor(Color.RED);
                    graphics2D.fillRect(colNumber * scale, rowNumber * scale, scale, scale);
                } else {
                    graphics2D.setColor(Color.BLACK);
                    graphics2D.fillRect(colNumber * scale, rowNumber * scale, scale, scale);
                }
            }
        }
    }

    private void drawBlock(Graphics2D graphics2D) {
        int[][] brickMatrix = boxModel.getCurrentBlockMatrix();
        for (int rowNumber = 0; rowNumber < brickMatrix.length; rowNumber++) {
            for (int colNumber = 0; colNumber < brickMatrix[0].length; colNumber++) {
                int brickColPos = colNumber + boxModel.getCurrentBlockColumn();
                int brickRowPos = rowNumber + boxModel.getCurrentBlockRow();
                if (brickMatrix[rowNumber][colNumber] == 1) {
                    graphics2D.setColor(Color.RED);
                    graphics2D.fillRect(brickColPos * scale, brickRowPos * scale, scale, scale);
                }
            }
        }
    }

    private void drawGrid(Graphics2D graphics2D) {
        graphics2D.setColor(green);
        for (int rowNumber = 1; rowNumber < boxModelHeight; rowNumber++) {
            int yCoordinate = rowNumber * scale + windowPadding;
            graphics2D.drawLine(windowPadding, yCoordinate, boxWidth + windowPadding, yCoordinate);
        }


        for (int columnNumber = 1; columnNumber < boxModelWidth; columnNumber++) {
            int xCoordinate = columnNumber * scale + windowPadding;
            graphics2D.drawLine(xCoordinate, windowPadding, xCoordinate, boxHeight + windowPadding);
        }
    }

    public void setWindowPadding(int padding) {
        windowPadding = padding;
    }

    public void enableGrid() {
        drawGrid = true;
    }

    public void disableGrid() {
        drawGrid = false;
    }

    public boolean isGridEnabled() {
        return drawGrid;
    }

    public void setNextBrick(Block nextBrick) {
        this.nextBrick = nextBrick;
    }

    public void setCurrentBrick(Block currentBrick) {
        this.currentBrick = currentBrick;
    }

}
