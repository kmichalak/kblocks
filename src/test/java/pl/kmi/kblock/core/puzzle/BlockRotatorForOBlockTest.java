package pl.kmi.kblock.core.puzzle;

import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;
import static pl.kmi.kblock.core.puzzle.Block.O;

import junit.framework.TestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BlockRotatorForOBlockTest extends TestCase {

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
    public void testRotatesOBlockRight90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1},
                {1, 1}
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(O.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotatesOBlockRight180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1},
                {1, 1}
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(O.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotatesOBlockRight270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1},
                {1, 1}
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(O.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }

    @Test
    public void testRotatesOBlockRight360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1},
                {1, 1}
        };

        // when
        int[][] rotatedRight = rotator.rotateRight(O.getMatrix());
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);
        rotatedRight = rotator.rotateRight(rotatedRight);

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);
    }



    @Test
    public void testRotatesOBlockLeft90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1},
                {1, 1}
        };

        // when
        int[][] rotatedRight = rotator.rotateLeft(O.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotatedRight);

    }

    @Test
    public void testRotatesOBlockLeft180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1},
                {1, 1}
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(O.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);

    }

    @Test
    public void testRotatesOBlockLeft270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1},
                {1, 1}
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(O.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);

    }


    @Test
    public void testRotatesOBlockLeft360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1},
                {1, 1}
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(O.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);

    }



}