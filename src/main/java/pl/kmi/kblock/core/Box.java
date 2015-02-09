package pl.kmi.kblock.core;

import pl.kmi.kblock.core.core.Block;
import pl.kmi.kblock.core.core.BlockRotator;

import java.util.Arrays;

import static java.util.Arrays.copyOf;

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

//    private Block currentBlock;

    private int[][] previousBlockMatrix;
    private int[][] currentBlockMatrix;

    private int currentBlockRow;
    private int currentBlockColumn;
    private BlockRotator rotator;

    public Box() {
        rotator = new BlockRotator();
    }

    public void addBlockToBox(Block block) {
//        currentBlock = block;

//        final int[][] blockMatrix = block.getMatrix();
        previousBlockMatrix = block.getMatrix();
        currentBlockMatrix = block.getMatrix();

        int blockWidth = currentBlockMatrix[0].length;
        int blockStart = (matrix[0].length - blockWidth) / 2;

        currentBlockColumn = blockStart;
        currentBlockRow = 0;

        addBlockAtPosition(currentBlockMatrix, blockStart, 0);
    }

    private synchronized void addBlockAtPosition(int[][] blockMatrix, int x, int y) {
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
//        int[][] currentBlockMatrix = currentBlock.getMatrix();
        removeBlockFromPosition(previousBlockMatrix, currentBlockColumn, currentBlockRow);
//        System.out.println("Removed");
//        putOnStdOut(previousBlockMatrix);
        previousBlockMatrix = currentBlockMatrix;
        currentBlockRow++;
        addBlockAtPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
//        System.out.println("Added");
//        putOnStdOut(currentBlockMatrix);
    }

    private void putOnStdOut(int[][] matrix) {
//        System.out.flush();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");

//        for (int i = 0; i<20; i++) {
//            for (int j=0; j<10; j++) {
//                System.out.print(box.getMatrix()[i][j]);
//            }
//            System.out.println("");
//        }
    }

    public void moveBlockLeft() {
//        int[][] currentBlockMatrix = currentBlock.getMatrix();
        removeBlockFromPosition(previousBlockMatrix, currentBlockColumn, currentBlockRow);
        previousBlockMatrix = currentBlockMatrix;
        currentBlockColumn--;
        addBlockAtPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
    }

    public void moveBlockRight() {
//        int[][] currentBlockMatrix = currentBlock.getMatrix();
        removeBlockFromPosition(previousBlockMatrix, currentBlockColumn, currentBlockRow);
        previousBlockMatrix = currentBlockMatrix;
        currentBlockColumn++;
        addBlockAtPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
    }

    private synchronized void removeBlockFromPosition(int[][] blockMatrix, int x, int y) {
        int blockHeight = blockMatrix.length;
        int blockWidth = blockMatrix[0].length;

        for (int rowIndex=0; rowIndex < blockHeight; rowIndex++) {
            for (int columnIndex=0; columnIndex < blockWidth; columnIndex++) {
                matrix[y + rowIndex][x + columnIndex] = BLOCK_EMPTY_SPACE;
            }
        }
    }

    private boolean blockCollidesWithOtherBlocks() {
//        int[][] currentBlockMatrix = currentBlock.getMatrix();
//        int blockWidth = currentBlockMatrix[0].length;
        int blockWidth = previousBlockMatrix[0].length;
        int blockHeight = previousBlockMatrix.length;
//        int blockHeight = currentBlockMatrix.length;
//        return standsOnBlock(blockWidth, blockHeight) || hangsOnOtherBlock(currentBlockMatrix, blockWidth, blockHeight);
        return standsOnBlock(blockWidth, blockHeight) || hangsOnOtherBlock(previousBlockMatrix, blockWidth, blockHeight);
    }

    private boolean hangsOnOtherBlock(int[][] currentBlockMatrix, int blockWidth, int blockHeight) {
        for (int blockRow = 0; blockRow < blockHeight - 1; blockRow++) {

            for (int blockColumn = 0; blockColumn < blockWidth; blockColumn++) {

                if (currentBlockMatrix[blockRow][blockColumn] == BLOCK_PART
                        && currentBlockMatrix[blockRow + 1][blockColumn] == BLOCK_EMPTY_SPACE
                        && matrix[currentBlockRow + blockRow + 1][currentBlockColumn + blockColumn] == BLOCK_PART) {
                        System.out.println("currentBlockMatrix["+blockRow+"]["+blockColumn+"]");

                        System.out.println("currentBlockMatrix["+blockRow+" + 1]["+blockColumn+"]");
                        System.out.println("matrix["+currentBlockRow+" + "+blockRow+" + 1]["+currentBlockColumn+" + "+blockColumn+"]");

                        System.out.println("Hangs on other block");
                        putOnStdOut(matrix);
                        return true;
                }

            }
        }
        return false;
    }

    private boolean standsOnBlock(int blockWidth, int blockHeight) {
        int lastBlockElementPosition = currentBlockColumn + blockWidth - 1;
        int lastBlockLinePosition = currentBlockRow + blockHeight - 1;

        for (int colNumber = currentBlockColumn; colNumber < lastBlockElementPosition; colNumber++) {

            if (lastBlockLinePosition < matrix.length - 1
                    && matrix[lastBlockLinePosition][colNumber] == BLOCK_PART
                    && matrix[lastBlockLinePosition + 1][colNumber] == BLOCK_PART) {
                System.out.println("Stands on block");
                return true;
            }

        }

        return false;
    }

    private boolean blockReachedEndOfBox() {
        return currentBlockRow + currentBlockMatrix.length == getHeight();
    }

    public boolean canMoveBlockDown() {
        return !blockReachedEndOfBox() && !blockCollidesWithOtherBlocks();
    }

    public boolean canMoveBlockRight() {
//        int[][] currentBlockMatrix = currentBlock.getMatrix();
        int blockWidth = currentBlockMatrix[0].length;
        return currentBlockColumn + blockWidth < getWidth();
    }

    public boolean canMoveBlockLeft() {
        return currentBlockColumn > 0;
    }

    public synchronized void rotateBlockRight() {
        removeBlockFromPosition(previousBlockMatrix, currentBlockColumn, currentBlockRow);
        removeBlockFromPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);

//        previousBlockMatrix = currentBlockMatrix;
//        currentBlockRow++;
//        addBlockAtPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);


        previousBlockMatrix = copyOf(currentBlockMatrix, currentBlockMatrix.length);
        int[][] rotatedBlockMatrix = rotator.rotateRight(currentBlockMatrix);
        currentBlockMatrix = rotatedBlockMatrix;

        addBlockAtPosition(currentBlockMatrix, currentBlockColumn, currentBlockRow);
    }
}
