package pl.kmi.kblock.core.puzzle;

import pl.kmi.kblock.core.base.Block;

public class BlockO extends Block {

    public BlockO() {
        int[][] matrix = new int[][] {
            {1, 1},
            {1, 1}
        };
        setBlockMatrix(matrix);
    }

    @Override
    public void rotateLeft() {
        final int[][] blockMatrix = getBlockMatrix();

        int w = blockMatrix.length;
        int h = blockMatrix[0].length;

        final int[][] newBlockMatrix = new int[h][w];

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                newBlockMatrix[i][j] = blockMatrix[j][i];
            }
        }
        setBlockMatrix(newBlockMatrix);
    }

    @Override
    public void rotateRight() {
        final int[][] blockMatrix = getBlockMatrix();

        int w = blockMatrix.length;
        int h = blockMatrix[0].length;

        final int[][] newBlockMatrix = new int[h][w];

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                newBlockMatrix[i][j] = blockMatrix[w - j - 1][i];
            }
        }
        setBlockMatrix(newBlockMatrix);
    }
}
