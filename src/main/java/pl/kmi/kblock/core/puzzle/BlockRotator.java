package pl.kmi.kblock.core.puzzle;

public class BlockRotator {

    public int[][] rotateLeft(int[][] blockMatrix) {
        int w = blockMatrix.length;
        int h = blockMatrix[0].length;

        final int[][] newBlockMatrix = new int[h][w];

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                newBlockMatrix[i][j] = blockMatrix[j][h - i - 1];
            }
        }

        return newBlockMatrix;
    }

    public int[][] rotateRight(int[][] blockMatrix) {
        int w = blockMatrix.length;
        int h = blockMatrix[0].length;

        final int[][] newBlockMatrix = new int[h][w];

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                newBlockMatrix[i][j] = blockMatrix[w - j - 1][i];
            }
        }

        return newBlockMatrix;
    }

}
