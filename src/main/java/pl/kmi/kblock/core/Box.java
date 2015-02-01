package pl.kmi.kblock.core;

import pl.kmi.kblock.core.core.Block;

public class Box {

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
                matrix[y + rowIndex][x + columnIndex] = blockMatrix[rowIndex][columnIndex];
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
                matrix[y + rowIndex][x + columnIndex] = 0;
            }
        }
    }

    public boolean canMoveBlockDown() {
        return blockDidNotReachEndOfBox() && !blockCollidesWithOtherBlocks();
    }

    private boolean blockCollidesWithOtherBlocks() {
        int[][] currentBlockMatrix = currentBlock.getMatrix();
        int blockWidth = currentBlockMatrix[0].length;
        int lastBlockElementPosition = currentBlockColumn + blockWidth - 1;

        int blockHeight = currentBlockMatrix.length;
        int lastBlockLinePosition = currentBlockRow + blockHeight;

        for (int colNumber = currentBlockColumn; colNumber < lastBlockElementPosition; colNumber++) {
            if (hitOtherBlock(currentBlockMatrix, lastBlockLinePosition, colNumber)) {
                return true;
            }
        }

        return false;
    }

    private boolean hitOtherBlock(int[][] currentBlockMatrix, int lastBlockElementPosition, int colNumber) {
        return matrix[lastBlockElementPosition - 1][colNumber] == 1
                && matrix[lastBlockElementPosition][colNumber] == 1;
    }

    private boolean blockDidNotReachEndOfBox() {
        return currentBlockRow + currentBlock.getMatrix().length < getHeight();
    }

    public void replaceMatrix(int[][] expectedBoxContent) {
        matrix = expectedBoxContent;
    }
}
