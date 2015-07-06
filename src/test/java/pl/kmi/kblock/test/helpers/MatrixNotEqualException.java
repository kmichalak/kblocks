package pl.kmi.kblock.test.helpers;

import java.util.Arrays;

import static java.lang.String.format;

public class MatrixNotEqualException extends RuntimeException {

    private int[][] expectedMatrix;
    private int[][] actualMatrix;

    public MatrixNotEqualException(int[][] expectedMatrix, int[][] actualMatrix) {
        this.expectedMatrix = expectedMatrix;
        this.actualMatrix = actualMatrix;
    }

    @Override
    public String getMessage() {
        return format(
                "Expected \n%s \nbut got \n%s",
                Arrays.deepToString(expectedMatrix).replace("], ", "]\n"),
                Arrays.deepToString(actualMatrix).replace("], ", "]\n")
        );
    }
}
