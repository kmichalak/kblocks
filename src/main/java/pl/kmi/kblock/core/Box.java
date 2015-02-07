package pl.kmi.kblock.core;

import pl.kmi.kblock.core.core.Block;

public class Box {

    private static final int BLOCK_PART = 1;
    private static final int BLOCK_EMPTY_SPACE = 0;
    private int[][] matrix = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    private Block currentBlock;
    private int currentBlockRow;
    private int currentBlockColumn;

    public void addBlockToBox(Block block) {
        currentBlock = block;

        final int[][] blockMatrix = block.getMatrix();

        int blockWidth = blockMatrix[0].length;
        int blockStart = (matrix[0].length - blockWidth) / 2;

        currentBlockColumn = blockStart;
        currentBlockRow = 0;

        addBlockAtPosition(blockMatrix, blockStart, 0);
    }

    private void addBlockAtPosition(int[][] blockMatrix, int x, int y) {
        int blockHeight = blockMatrix.length;
        int blockWidth = blockMatrix[0].length;

        for (int rowIndex=0; rowIndex < blockHeight; rowIndex++) {
            for (int columnIndex=0; columnIndex < blockWidth; columnIndex++) {
                if (matrix[y + rowIndex][x + columnIndex] == 0) {
                    matrix[y + rowIndex][x + columnIndex] = blockMatrix[rowIndex][columnIndex];
                }
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getWidth() {
        return matrix[0].length;
    }

    public int getHeight() {
        return matrix.length;
    }

    public void moveBlockDown() {
        int[][] currentBlockMatrix = currentBlock.getMatrix();
        removeBlockFromPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
        currentBlockRow++;
        addBlockAtPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
    }

    private void removeBlockFromPosition(int[][] blockMatrix, int x, int y) {
        int blockHeight = blockMatrix.length;
        int blockWidth = blockMatrix[0].length;

        for (int rowIndex=0; rowIndex < blockHeight; rowIndex++) {
            for (int columnIndex=0; columnIndex < blockWidth; columnIndex++) {
                matrix[y + rowIndex][x + columnIndex] = BLOCK_EMPTY_SPACE;
            }
        }
    }

    public boolean canMoveBlockDown() {
        return !blockReachedEndOfBox() && !blockCollidesWithOtherBlocks();
    }

    private boolean blockCollidesWithOtherBlocks() {
        int[][] currentBlockMatrix = currentBlock.getMatrix();
        int blockWidth = currentBlockMatrix[0].length;
        int blockHeight = currentBlockMatrix.length;
        return standsOnBlock(blockWidth, blockHeight) || hangsOnOtherBlock(currentBlockMatrix, blockWidth, blockHeight);
    }

    private boolean hangsOnOtherBlock(int[][] currentBlockMatrix, int blockWidth, int blockHeight) {
        for (int blockRow = 0; blockRow < blockHeight - 1; blockRow++) {

            for (int blockColumn = 0; blockColumn < blockWidth; blockColumn++) {

                if (currentBlockMatrix[blockRow][blockColumn] == BLOCK_PART
                        && currentBlockMatrix[blockRow + 1][blockColumn] == BLOCK_EMPTY_SPACE
                        && matrix[currentBlockRow + blockRow + 1][currentBlockColumn + blockColumn] == BLOCK_PART) {

                        return true;
                }

            }
        }
        return false;
    }

    private boolean standsOnBlock(int blockWidth, int blockHeight) {
        int lastBlockElementPosition = currentBlockColumn + blockWidth - 1;
        int lastBlockLinePosition = currentBlockRow + blockHeight;

        for (int colNumber = currentBlockColumn; colNumber < lastBlockElementPosition; colNumber++) {

            if (matrix[lastBlockLinePosition - 1][colNumber] == BLOCK_PART
                    && matrix[lastBlockLinePosition][colNumber] == BLOCK_PART) {
                return true;
            }

        }

        return false;
    }

    private boolean blockReachedEndOfBox() {
        return currentBlockRow + currentBlock.getMatrix().length == getHeight();
    }

}
