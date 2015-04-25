package pl.kmi.kblock.core;

import pl.kmi.kblock.core.core.Block;
import pl.kmi.kblock.core.core.BlockRotator;

import java.util.Arrays;

import static java.util.Arrays.copyOf;

public class Box {

    private static final int BLOCK_PART = 1;
    private static final int BLOCK_EMPTY_SPACE = 0;
    private int[][] matrix = new int[][]{
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

    private int[][] currentBlockMatrix;

    private int currentBlockRow;
    private int currentBlockColumn;
    private BlockRotator rotator;

    public Box() {
        rotator = new BlockRotator();
    }

    public void addBlockToBox(Block block) {
        currentBlockMatrix = block.getMatrix();

        int blockWidth = currentBlockMatrix[0].length;
        int blockStart = (matrix[0].length - blockWidth) / 2;

        currentBlockColumn = blockStart;
        currentBlockRow = 0;

        addBlockAtPosition(currentBlockMatrix, blockStart, 0);
    }

    private synchronized void addBlockAtPosition(final int[][] blockMatrix, final int x, final int y) {
        int blockHeight = blockMatrix.length;
        int blockWidth = blockMatrix[0].length;

        for (int blockRowIndex = 0; blockRowIndex < blockHeight; blockRowIndex++) {

            for (int blockColumnIndex = 0; blockColumnIndex < blockWidth; blockColumnIndex++) {

                final int boxRowIndex = y + blockRowIndex;
                final int boxColumnIndex = x + blockColumnIndex;

                final boolean blockNotBehindLeftWall = boxColumnIndex > -1;
                final boolean blockNotBehindRighttWall = boxColumnIndex < getWidth();
                final boolean blockIsNotBelowFloor = boxRowIndex < getHeight();

                if (blockIsNotBelowFloor) {

                    if (blockNotBehindLeftWall) {

                        if (blockNotBehindRighttWall) {

                            if (matrix[boxRowIndex][boxColumnIndex] == BLOCK_EMPTY_SPACE) {

                                if (blockMatrix[blockRowIndex][blockColumnIndex] == BLOCK_PART) {

                                    matrix[boxRowIndex][boxColumnIndex] = blockMatrix[blockRowIndex][blockColumnIndex];

                                }

                            }

                        }

                    }

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
        removeBlockFromPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
        currentBlockRow++;
        addBlockAtPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
    }

    public void moveBlockLeft() {
        removeBlockFromPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
        currentBlockColumn--;
        addBlockAtPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
    }

    public void moveBlockRight() {
        removeBlockFromPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
        currentBlockColumn++;
        addBlockAtPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
    }

    private synchronized void removeBlockFromPosition(int[][] blockMatrix, int x, int y) {
        int blockHeight = blockMatrix.length;
        int blockWidth = blockMatrix[0].length;

        for (int rowIndex = 0; rowIndex < blockHeight; rowIndex++) {

            for (int columnIndex = 0; columnIndex < blockWidth; columnIndex++) {
                if (blockMatrix[rowIndex][columnIndex] == BLOCK_PART) {

                    if (y + rowIndex < matrix.length) {
                        if (matrix[y + rowIndex][x + columnIndex] == BLOCK_PART) {
                            matrix[y + rowIndex][x + columnIndex] = BLOCK_EMPTY_SPACE;
                        }

                    }

                }

            }
        }
    }

    private boolean blockCollidesWithOtherBlocks() {
        int blockWidth = currentBlockMatrix[0].length;
        int blockHeight = currentBlockMatrix.length;

        return standsOnBlock(blockWidth, blockHeight) || hangsOnOtherBlock(currentBlockMatrix, blockWidth, blockHeight);
    }

    private boolean hangsOnOtherBlock(int[][] currentBlockMatrix, int blockWidth, int blockHeight) {
        for (int blockRow = blockHeight - 1; blockRow >= 0; blockRow--) {

            for (int blockColumn = 0; blockColumn < blockWidth; blockColumn++) {

                final int nextBlockRow = blockRow + 1;

                final int matrixRowAfterBlock = currentBlockRow + blockRow + 1;
                if (matrixRowAfterBlock < matrix.length) {
                    if (currentBlockMatrix[blockRow][blockColumn] == BLOCK_PART) {
                        if (nextBlockRow < blockHeight) {
                            if (currentBlockMatrix[nextBlockRow][blockColumn] == BLOCK_EMPTY_SPACE) {
                                if (matrix[matrixRowAfterBlock][currentBlockColumn + blockColumn] == BLOCK_PART) {
                                    return true;
                                }
                            }
                        }

                    }

                }

            }

        }

        return false;
    }

    private boolean standsOnBlock(int blockWidth, int blockHeight) {
        int lastBlockElementPosition = currentBlockColumn + blockWidth - 1;
        int lastBlockLinePosition = currentBlockRow + blockHeight - 1;

        for (int colNumber = currentBlockColumn; colNumber < lastBlockElementPosition; colNumber++) {

            if (colNumber > -1 && colNumber < getWidth()
                    && lastBlockLinePosition < matrix.length - 1
                    && matrix[lastBlockLinePosition][colNumber] == BLOCK_PART
                    && matrix[lastBlockLinePosition + 1][colNumber] == BLOCK_PART) {
                System.out.println("Stands on block");
                return true;
            }

        }

        return false;
    }

    private boolean blockReachedEndOfBox() {
        for (int rowIndex = currentBlockMatrix.length - 1; rowIndex >= 0; rowIndex--) {
            for (int columnIndex = 0; columnIndex < currentBlockMatrix[0].length; columnIndex++) {
                if (currentBlockMatrix[rowIndex][columnIndex] == BLOCK_PART) {
                    final int i = currentBlockRow + rowIndex;
                    return i == getHeight() - 1;
                }
            }
        }
        return currentBlockRow + currentBlockMatrix.length == getHeight() - 1;
    }

    public boolean canMoveBlockDown() {
        return !blockReachedEndOfBox() && !blockCollidesWithOtherBlocks();
    }

    public boolean canMoveBlockRight() {
        int blockWidth = currentBlockMatrix[0].length;

        for (int columnNumber = blockWidth - 1; columnNumber > 0; columnNumber--) {
            for (int rowNumber = 0; rowNumber < currentBlockMatrix.length; rowNumber++) {
                int blockMatrixColumn = currentBlockColumn + columnNumber;
                int[] ints = currentBlockMatrix[rowNumber];
                if (ints[columnNumber] == BLOCK_PART) {
                    if (blockMatrixColumn == getWidth() - 1) {
                        return false;
                    }
                }
            }
        }


//        return currentBlockColumn + blockWidth < getWidth();
        return true;
    }

    public boolean canMoveBlockLeft() {
        for (int columnNumber = 0; columnNumber < currentBlockMatrix[0].length; columnNumber++) {
            for (int rowNumber = 0; rowNumber < currentBlockMatrix.length; rowNumber++) {
                int blockMatrixColumn = currentBlockColumn + columnNumber;
                int[] ints = currentBlockMatrix[rowNumber];
                if (ints[columnNumber] == BLOCK_PART) {
                    if (blockMatrixColumn == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public synchronized void rotateBlockRight() {
        removeBlockFromPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
        int[][] tempMatrix = rotator.rotateRight(currentBlockMatrix);
        currentBlockMatrix = tempMatrix;
        addBlockAtPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
    }
}
