package pl.kmi.kblock.core.puzzle;

import java.util.Arrays;

import static java.lang.String.format;

public class MatrixNotEqualException extends Exception {

    private int[][] expectedMatrix;
    private int[][] actualMatrix;

    public MatrixNotEqualException(int[][] expectedMatrix, int[][] actualMatrix) {
        this.expectedMatrix = expectedMatrix;
        this.actualMatrix = actualMatrix;
    }

    @Override
    public String getMessage() {
        return format(
                "Expected %s but got %s",
                Arrays.deepToString(expectedMatrix),
                Arrays.deepToString(actualMatrix)
        );
    }
}
