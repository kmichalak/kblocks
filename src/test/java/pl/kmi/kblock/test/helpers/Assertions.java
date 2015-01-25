package pl.kmi.kblock.test.helpers;

import java.util.Arrays;

public class Assertions {

    public static void assertMatricesEquals(int[][] expected, int[][] actual) throws MatrixNotEqualException {
        if (!Arrays.deepEquals(expected, actual)) {
            throw new MatrixNotEqualException(expected, actual);
        }
    }

}
