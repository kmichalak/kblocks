package pl.kmi.kblock.core.core;

import static pl.kmi.kblock.test.helpers.Assertions.*;
import static pl.kmi.kblock.core.core.Block.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BlockRotatorForIBlockTest {

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
    public void testRotatesIBlockLeft90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][]{
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(I.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }

    @Test
    public void testRotatesIBlockLeft180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][]{
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(I.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }

    @Test
    public void testRotatesIBlockLeft270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(I.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }

    @Test
    public void testRotatesIBlockLeft360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][]{
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(I.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }


    @Test
    public void testRotatesIBlockRight90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(I.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotatesIBlockRight180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][]{
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(I.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotatesIBlockRight270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(I.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotatesIBlockRight360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][]{
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(I.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }
}
