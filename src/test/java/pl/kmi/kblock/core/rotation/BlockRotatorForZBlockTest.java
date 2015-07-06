package pl.kmi.kblock.core.rotation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.kmi.kblock.core.model.BlockRotator;

import static pl.kmi.kblock.core.model.Block.Z;
import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;

public class BlockRotatorForZBlockTest {

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
    public void testRotateZBlockRight90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotetadRight = rotator.rotateRight(Z.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotetadRight);
    }

    @Test
    public void testRotateZBlockRight180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
        };

        // when
        int[][] rotetadRight = rotator.rotateRight(Z.getMatrix());
        rotetadRight = rotator.rotateRight(rotetadRight);

        // then
        assertMatricesEquals(expectedMatrix, rotetadRight);
    }

    @Test
    public void testRotateZBlockRight270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0},
        };

        // when
        int[][] rotetadRight = rotator.rotateRight(Z.getMatrix());
        rotetadRight = rotator.rotateRight(rotetadRight);
        rotetadRight = rotator.rotateRight(rotetadRight);

        // then
        assertMatricesEquals(expectedMatrix, rotetadRight);
    }

    @Test
    public void testRotateZBlockRight360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotetadRight = rotator.rotateRight(Z.getMatrix());
        rotetadRight = rotator.rotateRight(rotetadRight);
        rotetadRight = rotator.rotateRight(rotetadRight);
        rotetadRight = rotator.rotateRight(rotetadRight);

        // then
        assertMatricesEquals(expectedMatrix, rotetadRight);
    }

    @Test
    public void testRotateZBlockLeft90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0},
        };

        // when
        int[][] rotetadLeft = rotator.rotateLeft(Z.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotetadLeft);
    }

    @Test
    public void testRotateZBlockLeft180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(Z.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }

    @Test
    public void testRotateZBlockLeft270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(Z.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }

    @Test
    public void testRotateZBlockLeft360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(Z.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }







}
