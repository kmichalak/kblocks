package pl.kmi.kblock.core.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.kmi.kblock.core.model.BlockRotator;

import static pl.kmi.kblock.core.model.Block.J;
import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;

public class BlockRotatorForJBlockTest {

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
    public void testRotateLBlockRight90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(J.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotateLBlockRight180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(J.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotateLBlockRight270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(J.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotateLBlockRight360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(J.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }
    
}
