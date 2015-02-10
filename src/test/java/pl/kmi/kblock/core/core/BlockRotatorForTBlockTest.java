package pl.kmi.kblock.core.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;
import static pl.kmi.kblock.core.core.Block.T;

public class BlockRotatorForTBlockTest {

    private BlockRotator rotator;

    @BeforeMethod
    public void setUp() throws Exception {
        rotator = new BlockRotator();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        rotator = null;
    }

    @Test
    public void testRotatesTBlockRight90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(T.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotatesTBlockRight180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 1},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(T.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotatesTBlockRight270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(T.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotatesTBlockRight360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(T.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotatesTBlockLeft90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0},
        };

        // when
        int[][] rotateLeft = rotator.rotateLeft(T.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotateLeft);
    }

    @Test
    public void testRotatesTBlockLeft180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 1},
        };

        // when
        int[][] rotateLeft = rotator.rotateLeft(T.getMatrix());
        rotateLeft = rotator.rotateLeft(rotateLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotateLeft);
    }

    @Test
    public void testRotatesTBlockLeft270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotateLeft = rotator.rotateLeft(T.getMatrix());
        rotateLeft = rotator.rotateLeft(rotateLeft);
        rotateLeft = rotator.rotateLeft(rotateLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotateLeft);
    }

    @Test
    public void testRotatesTBlockLeft360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(T.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }

}