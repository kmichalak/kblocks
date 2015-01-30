package pl.kmi.kblock.view;

import pl.kmi.kblock.core.Box;

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

    public GameBox(Box boxModel) {
        this.boxModel = boxModel;
        boxModelWidth = boxModel.getWidth();
        boxModelHeight = boxModel.getHeight();

        boxWidth = boxModelWidth * scale;
        boxHeight = boxModelHeight * scale;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
//        graphics2D.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
//        graphics2D.fillRect(windowPadding, windowPadding, boxWidth, boxHeight);
        drawBoxWithContent(graphics2D);
        if (drawGrid) {
            drawGrid(graphics2D);
        }
    }

    private void drawBoxWithContent(Graphics2D graphics2D) {
        Color originalColor = graphics2D.getColor();
        drawBoxContentBlocks(graphics2D);
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
}
