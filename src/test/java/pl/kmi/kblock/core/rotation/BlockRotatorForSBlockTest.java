package pl.kmi.kblock.core.rotation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.kmi.kblock.core.model.BlockRotator;

import static pl.kmi.kblock.core.model.Block.S;
import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;

public class BlockRotatorForSBlockTest {

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
    public void testRotateSBlockRight90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1},
        };

        // when
        int[][] rotetadRight = rotator.rotateRight(S.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotetadRight);
    }

    @Test
    public void testRotateSBlockRight180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {1, 1, 0, 0},
        };

        // when
        int[][] rotetadRight = rotator.rotateRight(S.getMatrix());
        rotetadRight = rotator.rotateRight(rotetadRight);

        // then
        assertMatricesEquals(expectedMatrix, rotetadRight);
    }

    @Test
    public void testRotateSBlockRight270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotetadRight = rotator.rotateRight(S.getMatrix());
        rotetadRight = rotator.rotateRight(rotetadRight);
        rotetadRight = rotator.rotateRight(rotetadRight);

        // then
        assertMatricesEquals(expectedMatrix, rotetadRight);
    }

    @Test
    public void testRotateSBlockRight360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 1, 1},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotetadRight = rotator.rotateRight(S.getMatrix());
        rotetadRight = rotator.rotateRight(rotetadRight);
        rotetadRight = rotator.rotateRight(rotetadRight);
        rotetadRight = rotator.rotateRight(rotetadRight);

        // then
        assertMatricesEquals(expectedMatrix, rotetadRight);
    }

    @Test
    public void testRotateSBlockLeft90() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotetadLeft = rotator.rotateLeft(S.getMatrix());

        // then
        assertMatricesEquals(expectedMatrix, rotetadLeft);
    }

    @Test
    public void testRotateSBlockLeft180() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {1, 1, 0, 0},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(S.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }

    @Test
    public void testRotateSBlockLeft270() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(S.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }

    @Test
    public void testRotateSBlockLeft360() throws Exception {
        // given
        final int[][] expectedMatrix = new int[][] {
                {0, 0, 1, 1},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        // when
        int[][] rotatedLeft = rotator.rotateLeft(S.getMatrix());
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);
        rotatedLeft = rotator.rotateLeft(rotatedLeft);

        // then
        assertMatricesEquals(expectedMatrix, rotatedLeft);
    }







}
