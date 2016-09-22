package pl.kmi.kblock.core.rotation.wall;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.kmi.kblock.core.model.Block;
import pl.kmi.kblock.core.model.Box;

import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;
import static pl.kmi.kblock.test.helpers.Assertions.assertThat;
import static pl.kmi.kblock.test.helpers.MatrixFactory.boxMatrixThatBeginsWith;

public class RotateBlockOnTheWallTest extends RotateOnTheWallTest {

    private Box boxModel;
    private Block block = Block.T;

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
        assertThat(block)
                .putInBox(boxModel)
                .movedToTheRightWall()
                .afterRotation90ToTheRight()
                .equalsTo(boxMatrixThatBeginsWith(
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        }
                ));
    }

    @Test
    public void testRotateTBlock180OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        boxModel.addBlockToBox(block);
        stickToTheRightWall(boxModel);

        // when
        rotateBlockRight180(boxModel);

        // then
        assertMatricesEquals(expectedMatrix, boxModel.getMatrix());
    }

    @Test
    public void testRotateTBlock270OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                }
        );

        boxModel.addBlockToBox(block);
        stickToTheRightWall(boxModel);

        // when
        rotateBlockRight270(boxModel);

        // then
        assertMatricesEquals(expectedMatrix, boxModel.getMatrix());
    }

    @Test
    public void testRotateTBlock360OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        boxModel.addBlockToBox(block);
        stickToTheRightWall(boxModel);

        // when
        rotateBlockRight360(boxModel);

        // then
        assertMatricesEquals(expectedMatrix, boxModel.getMatrix());
    }


}
