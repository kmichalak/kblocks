package pl.kmi.kblock.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.kmi.kblock.core.model.Block;
import pl.kmi.kblock.core.model.Box;

import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;
import static pl.kmi.kblock.test.helpers.MatrixFactory.createBoxMatrix;

public class RotateTBlockOnTheWallTest {

    private Box boxModel;

    @BeforeMethod
    public void setUp() throws Exception {
        boxModel = new Box();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        boxModel = null;
    }

    @Test
    public void testRotateTBlock90OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        boxModel.addBlockToBox(Block.T);
        stickToTheRightWall();

        // when
        boxModel.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, boxModel.getMatrix());
    }

    @Test
    public void testRotateTBlock180OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                }
        );

        boxModel.addBlockToBox(Block.T);
        stickToTheRightWall();

        // when
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, boxModel.getMatrix());
    }

    @Test
    public void testRotateTBlock270OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                }
        );

        boxModel.addBlockToBox(Block.T);
        stickToTheRightWall();

        // when
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, boxModel.getMatrix());
    }

    @Test
    public void testRotateTBlock360OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        boxModel.addBlockToBox(Block.T);
        stickToTheRightWall();

        // when
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, boxModel.getMatrix());
    }

    private void stickToTheRightWall() {
        while (boxModel.canMoveBlockRight()) {
            boxModel.moveBlockRight();
        }
    }
}
