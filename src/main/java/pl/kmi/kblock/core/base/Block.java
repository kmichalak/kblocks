package pl.kmi.kblock.core.base;

public abstract class Block {

    private int[][] puzzleMatrix;

    public abstract void rotateLeft();

    public abstract void rotateRight();

    public void setBlockMatrix(int[][] matrix) {
        if ((matrix.length == 0) || (matrix[0].length == 0)) {
            throw new IllegalArgumentException();
        }
        puzzleMatrix = matrix;
    }

    public int[][] getBlockMatrix() {
        return puzzleMatrix;
    }

}
