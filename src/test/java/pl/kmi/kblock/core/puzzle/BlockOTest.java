package pl.kmi.kblock.core.puzzle;

import junit.framework.TestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.kmi.kblock.core.base.Block;

import java.util.Arrays;

public class BlockOTest extends TestCase {

    private Block block;

    @BeforeMethod
    public void setUp() throws Exception {
        block = new BlockO();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        block = null;
    }

    public void testShouldCreateMatrixWithValidDimensionsAfterRotatingLeft() throws Exception {
        // given
        block.setBlockMatrix(new int[][]{{1, 2}, {3, 4}});
        final int[][] expectedMatrix = new int[][]{{1, 3}, {2, 4}};

        // when
        block.rotateLeft();
        final int[][] rotatedPuzzleMatrix = block.getBlockMatrix();

        // then
        assertMatricesEquals(expectedMatrix, rotatedPuzzleMatrix);
    }

    public void testShouldCreateMatrixWithValidDimensionsAfterRotatingRight() throws Exception {
        // given
        block.setBlockMatrix(new int[][]{{1, 2}, {3, 4}});
        final int[][] expectedMatrix = new int[][]{{3, 1}, {4, 2}};

        // when
        block.rotateRight();
        final int[][] rotatedPuzzleMatrix = block.getBlockMatrix();

        // then
        assertMatricesEquals(expectedMatrix, rotatedPuzzleMatrix);
    }


    private void assertMatricesEquals(int[][] expected, int[][] actual) throws MatrixNotEqualException {
        if (!Arrays.deepEquals(expected, actual)) {
            throw new MatrixNotEqualException(expected, actual);
        }
    }
}