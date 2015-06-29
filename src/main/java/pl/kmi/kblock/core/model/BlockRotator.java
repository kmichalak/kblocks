package pl.kmi.kblock.core.model;

public class BlockRotator {

    public int[][] rotateLeft(int[][] blockMatrix) {
        int blockWidth = blockMatrix.length;
        int blockHeight = blockMatrix[0].length;

        final int[][] newBlockMatrix = new int[blockHeight][blockWidth];

        for (int blockRowIndex = 0; blockRowIndex < blockHeight; ++blockRowIndex) {
            for (int blockColumnIndex = 0; blockColumnIndex < blockWidth; ++blockColumnIndex) {
                // TODO: Is there any way to refactor this code to extract
                // some common method? Only this line makes a difference
                // between rotateLeft and rotateRight methods.
                newBlockMatrix[blockRowIndex][blockColumnIndex] = blockMatrix[blockColumnIndex][blockHeight - blockRowIndex - 1];
            }
        }

        return newBlockMatrix;
    }

    public int[][] rotateRight(int[][] blockMatrix) {
        int blockWidth = blockMatrix.length;
        int blockHeight = blockMatrix[0].length;

        final int[][] newBlockMatrix = new int[blockHeight][blockWidth];

        for (int blockRowIndex = 0; blockRowIndex < blockHeight; ++blockRowIndex) {
            for (int blockColumnIndex = 0; blockColumnIndex < blockWidth; ++blockColumnIndex) {
                newBlockMatrix[blockRowIndex][blockColumnIndex] = blockMatrix[blockWidth - blockColumnIndex - 1][blockRowIndex];
            }
        }

        return newBlockMatrix;
    }

}
