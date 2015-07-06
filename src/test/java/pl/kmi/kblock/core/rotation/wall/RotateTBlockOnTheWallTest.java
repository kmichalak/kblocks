package pl.kmi.kblock.core.rotation.wall;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.kmi.kblock.core.model.Block;
import pl.kmi.kblock.core.model.Box;

import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;
import static pl.kmi.kblock.test.helpers.Assertions.assertThat;
import static pl.kmi.kblock.test.helpers.MatrixFactory.boxMatrixThatBeginsWith;

public class RotateTBlockOnTheWallTest extends RotateOnTheWallTest {

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
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        boxModel.addBlockToBox(Block.T);
        stickToTheRightWall(boxModel);

        // when
        rotateBlockRight90(boxModel);

        // then
        assertMatricesEquals(expectedMatrix, boxModel.getMatrix());
    }

    @Test
    public void testRotateTBlock180OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                }
        );

        boxModel.addBlockToBox(Block.T);
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
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                }
        );

        boxModel.addBlockToBox(Block.T);
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
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        boxModel.addBlockToBox(Block.T);
        stickToTheRightWall(boxModel);

        // when
        rotateBlockRight360(boxModel);

        // then
        assertMatricesEquals(expectedMatrix, boxModel.getMatrix());
    }

    @Test
    public void testRotateTBlock360OnLeftWall() throws Exception {
        assertThat(Block.T)
                .putInBox(boxModel)
                .movedToTheLeftWall()
                .afterRotation360ToTheRight()
                .equalsTo(boxMatrixThatBeginsWith(
                        new int[][]{
                                {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        }
                ));
    }

    @Test
    public void testRotateTBlock90OnLeftWall() throws Exception {
        assertThat(Block.T)
                .putInBox(boxModel)
                .movedToTheLeftWall()
                .afterRotation90ToTheRight()
                .equalsTo(boxMatrixThatBeginsWith(
                        new int[][]{
                                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        }
                ));
    }

    @Test
    public void testRotateTBlock180OnLeftWall() throws Exception {
        assertThat(Block.T)
                .putInBox(boxModel)
                .movedToTheLeftWall()
                .afterRotation180ToTheRight()
                .equalsTo(boxMatrixThatBeginsWith(
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        }
                ));
    }

    @Test
    public void testRotateTBlock270OnLeftWall() throws Exception {
        assertThat(Block.T)
                .putInBox(boxModel)
                .movedToTheLeftWall()
                .afterRotation270ToTheRight()
                .equalsTo(boxMatrixThatBeginsWith(
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        }
                ));
    }



}
