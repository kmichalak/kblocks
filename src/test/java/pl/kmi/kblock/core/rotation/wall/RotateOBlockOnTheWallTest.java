package pl.kmi.kblock.core.rotation.wall;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.kmi.kblock.core.model.Block;
import pl.kmi.kblock.core.model.Box;

import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;
import static pl.kmi.kblock.test.helpers.MatrixFactory.boxMatrixThatBeginsWith;

public class RotateOBlockOnTheWallTest extends RotateOnTheWallTest {

    private Box gameBox;

    @BeforeMethod
    public void setUp() throws Exception {
        gameBox = new Box();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        gameBox = null;
    }

    @Test
    public void testRotateOBlock90OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        stickToTheLeftWall(gameBox);

        // when
        rotateBlockRight90(gameBox);

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock180OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        stickToTheLeftWall(gameBox);

        // when
        rotateBlockRight180(gameBox);

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock270OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        stickToTheLeftWall(gameBox);

        // when
        rotateBlockRight270(gameBox);

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock360OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        stickToTheLeftWall(gameBox);

        // when
        rotateBlockRight360(gameBox);

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock90OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        stickToTheRightWall(gameBox);

        // when
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock180OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        stickToTheRightWall(gameBox);

        // when
        rotateBlockRight180(gameBox);

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock270OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        stickToTheRightWall(gameBox);

        // when
        rotateBlockRight270(gameBox);

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock360OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = boxMatrixThatBeginsWith(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        stickToTheRightWall(gameBox);

        // when
        rotateBlockRight360(gameBox);

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

}