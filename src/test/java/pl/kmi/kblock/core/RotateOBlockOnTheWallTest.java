package pl.kmi.kblock.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.kmi.kblock.core.core.Block;

import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;
import static pl.kmi.kblock.test.helpers.MatrixFactory.createBoxMatrix;

public class RotateOBlockOnTheWallTest {

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
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        while (gameBox.canMoveBlockLeft()) {
            gameBox.moveBlockLeft();
        }

        // when
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock180OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        while (gameBox.canMoveBlockLeft()) {
            gameBox.moveBlockLeft();
        }

        // when
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock270OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        while (gameBox.canMoveBlockLeft()) {
            gameBox.moveBlockLeft();
        }

        // when
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock360OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        while (gameBox.canMoveBlockLeft()) {
            gameBox.moveBlockLeft();
        }

        // when
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock90OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        while (gameBox.canMoveBlockRight()) {
            gameBox.moveBlockRight();
        }

        // when
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock180OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        while (gameBox.canMoveBlockRight()) {
            gameBox.moveBlockRight();
        }

        // when
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock270OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        while (gameBox.canMoveBlockRight()) {
            gameBox.moveBlockRight();
        }

        // when
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateOBlock360OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.O);
        while (gameBox.canMoveBlockRight()) {
            gameBox.moveBlockRight();
        }

        // when
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

}