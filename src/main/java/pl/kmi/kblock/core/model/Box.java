package pl.kmi.kblock.core.model;

public class Box {

    private static final int BLOCK_PART = 1;
    private final BlockRotator rotator;

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

    public Box() {
        rotator = new BlockRotator();
    }

    public void addBlockToBox(Block block) {
        currentBlockMatrix = block.getMatrix();

        final int brickYPositionFix = getPositionOfFirstNotEmptyRow(currentBlockMatrix);
        final int blockWidth = currentBlockMatrix[0].length;

        currentBlockColumn = (matrix[0].length - blockWidth) / 2;
        currentBlockRow = 0 - brickYPositionFix;
    }

    private int getPositionOfFirstNotEmptyRow(int[][] currentBlockMatrix) {
        for (int rowNumber = 0; rowNumber < currentBlockMatrix.length; rowNumber++) {
            for (int columnNumber = 0; columnNumber < currentBlockMatrix[0].length; columnNumber++) {
                if (currentBlockMatrix[rowNumber][columnNumber] == BLOCK_PART) {
                    return rowNumber;
                }
            }
        }
        return 0;
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
        currentBlockRow++;
    }

    public void moveBlockLeft() {
        currentBlockColumn--;
    }

    public void moveBlockRight() {
        currentBlockColumn++;
    }

    private boolean blockWillLand() {
        int blockWidth = currentBlockMatrix[0].length;
        int blockHeight = currentBlockMatrix.length;

        for (int blockRow = blockHeight - 1; blockRow >= 0; blockRow--) {
            int[] row = currentBlockMatrix[blockRow];

            for (int blockColumn = 0; blockColumn < blockWidth; blockColumn++) {
                int matrixRow = currentBlockRow + 1 + blockRow;
                int matrixCol = currentBlockColumn + blockColumn;
                if (matrixRow >= 0 && matrixRow < matrix.length
                        && matrixCol >= 0 && matrixCol < matrix[0].length
                        && matrix[matrixRow][matrixCol] == 1
                        && row[blockColumn] == 1) {
                    return true;
                }
            }

        }

        return false;
    }

    public void putBlockInBox() {
        int blockWidth = currentBlockMatrix[0].length;
        int blockHeight = currentBlockMatrix.length;

        for (int blockRow = blockHeight - 1; blockRow >= 0; blockRow--) {
            int[] row = currentBlockMatrix[blockRow];

            for (int blockColumn = 0; blockColumn < blockWidth; blockColumn++) {
                if (row[blockColumn] == 1) {
                    matrix[currentBlockRow + blockRow][currentBlockColumn + blockColumn] = row[blockColumn];
                }
            }

        }
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
        return !blockReachedEndOfBox() && !blockWillLand();
    }

    public boolean canMoveBlockRight() {
        int blockWidth = currentBlockMatrix[0].length;

        for (int columnNumber = blockWidth - 1; columnNumber > 0; columnNumber--) {
            for (int[] blockRow : currentBlockMatrix) {
                if (blockRow[columnNumber] == BLOCK_PART) {
                    if (currentBlockColumn + columnNumber == getWidth() - 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean canMoveBlockLeft() {
        for (int columnNumber = 0; columnNumber < currentBlockMatrix[0].length; columnNumber++) {
            for (int[] blockRow : currentBlockMatrix) {
                if (blockRow[columnNumber] == BLOCK_PART) {
                    if (currentBlockColumn + columnNumber == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public synchronized void rotateBlockRight() {
        currentBlockMatrix = rotator.rotateRight(currentBlockMatrix);

        correctBlockPosition(currentBlockMatrix, currentBlockColumn);
    }

    private void correctBlockPosition(int[][] currentBlockMatrix, int currentBlockColumn) {
        if (currentBlockColumn < 0) {
            this.currentBlockColumn = -findFirstNotEmptyColumn(currentBlockMatrix);
        }

        if (currentBlockColumn + currentBlockMatrix[0].length >= getWidth()) {
            this.currentBlockColumn = findLastNotEmptyColumn(currentBlockMatrix);
        }
    }

    private int findLastNotEmptyColumn(int[][] blockMatrix) {
        final int blockWidth = blockMatrix[0].length;
        final int blockHeight = blockMatrix.length;

        for (int blockColumnNumber = blockWidth - 1; blockColumnNumber >= 0; blockColumnNumber--) {
            for (int blockRowNumber = blockHeight - 1; blockRowNumber >= 0; blockRowNumber--) {

                if (blockMatrix[blockRowNumber][blockColumnNumber] == BLOCK_PART) {
                    return getWidth() - blockWidth + (blockWidth - blockColumnNumber) - 1;
                }

            }
        }

        return getWidth() - blockMatrix[0].length;
    }

    private int findFirstNotEmptyColumn(int[][] blockMatrix) {
        for (int columnCounter = 0; columnCounter < blockMatrix[0].length; columnCounter++) {
            for (int[] aBlockMatrix : blockMatrix) {
                if (aBlockMatrix[columnCounter] == BLOCK_PART) {
                    return columnCounter;
                }
            }
        }

        return 0;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getCurrentBlockRow() {
        return currentBlockRow;
    }

    public int getCurrentBlockColumn() {
        return currentBlockColumn;
    }

    public int[][] getCurrentBlockMatrix() {
        return currentBlockMatrix;
    }
}
