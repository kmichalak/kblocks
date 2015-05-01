package pl.kmi.kblock.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.kmi.kblock.core.core.Block;

import static pl.kmi.kblock.test.helpers.Assertions.assertMatricesEquals;
import static pl.kmi.kblock.test.helpers.MatrixFactory.createBoxMatrix;

public class RotateLBlockOnTheWallTest {

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
    public void testRotateLBlock90OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.L);
        while (gameBox.canMoveBlockLeft()) {
            gameBox.moveBlockLeft();
        }

        // when
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateLBlock180OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.L);
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
    public void testRotateLBlock270OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.L);
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
    public void testRotateLBlock360OnLeftWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.L);
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
    public void testRotateLBlock90OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.L);
        while (gameBox.canMoveBlockRight()) {
            gameBox.moveBlockRight();
        }

        // when
        gameBox.rotateBlockRight();

        // then
        assertMatricesEquals(expectedMatrix, gameBox.getMatrix());
    }

    @Test
    public void testRotateLBlock180OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                }
        );

        gameBox.addBlockToBox(Block.L);
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
    public void testRotateLBlock270OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                }
        );

        gameBox.addBlockToBox(Block.L);
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
    public void testRotateLBlock360OnRightWall() throws Exception {
        // given
        int[][] expectedMatrix = createBoxMatrix(
                new int[][] {
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0,},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0,},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1,},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                }
        );

        gameBox.addBlockToBox(Block.L);
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