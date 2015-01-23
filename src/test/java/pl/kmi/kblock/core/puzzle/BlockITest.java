package pl.kmi.kblock.core.puzzle;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.kmi.kblock.core.base.Block;

import java.util.Arrays;

public class BlockITest {

    private Block block;

    @BeforeMethod
    public void setUp() throws Exception {
        block = new BlockI();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        block = null;
    }

    @Test
    public void testShouldCreateMatrixWithValidDimensionsAfterRotatingLeft() throws Exception {
        // given
        block.setBlockMatrix(new int[][] { {1}, {2}, {3}, {4} });
        final int[][] expectedMatrix = new int[][] { {1, 2, 3, 4} };

        // when
        block.rotateLeft();
        final int[][] rotatedPuzzleMatrix = block.getBlockMatrix();

        // then
        assertMatricesEquals(expectedMatrix, rotatedPuzzleMatrix);
    }

    @Test
    public void testShouldCreateMatrixWithValidDimensionsAfterRotatingRight() throws Exception {
        // given
        block.setBlockMatrix(new int[][] { {1}, {2}, {3}, {4} });
        final int[][] expectedMatrix = new int[][] { {4, 3, 2, 1} };

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
