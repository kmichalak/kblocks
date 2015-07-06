package pl.kmi.kblock.test.helpers;

import pl.kmi.kblock.core.model.Block;
import pl.kmi.kblock.core.model.Box;

import java.util.Arrays;

import static org.testng.Assert.assertNotNull;

public class Assertions {

    public static void assertMatricesEquals(int[][] expected, int[][] actual) throws MatrixNotEqualException {
        if (!Arrays.deepEquals(expected, actual)) {
            throw new MatrixNotEqualException(expected, actual);
        }
    }

    public static BlockAssertion assertThat(Block block) {
        return new BlockAssertion(block);
    }

    public static class BlockAssertion {
        private Block block;
        private Box boxModel;

        public BlockAssertion(Block block) {
            this.block = block;
        }

        public BlockAssertion putInBox(Box box) {
            this.boxModel = box;
            boxModel.addBlockToBox(block);
            return this;
        }

        public BlockAssertion movedToTheRightWall() {
            while (getBoxModel().canMoveBlockRight()) {
                getBoxModel().moveBlockRight();
            }
            return this;
        }

        public BlockAssertion movedToTheLeftWall() {
            while (getBoxModel().canMoveBlockLeft()) {
                getBoxModel().moveBlockLeft();
            }
            return this;
        }

        public BlockAssertion afterRotation90ToTheRight() {
            getBoxModel().rotateBlockRight();
            return this;
        }

        public BlockAssertion afterRotation180ToTheRight() {
            getBoxModel().rotateBlockRight();
            getBoxModel().rotateBlockRight();
            return this;
        }

        public BlockAssertion afterRotation270ToTheRight() {
            getBoxModel().rotateBlockRight();
            getBoxModel().rotateBlockRight();
            getBoxModel().rotateBlockRight();
            return this;
        }

        public BlockAssertion afterRotation360ToTheRight() {
            getBoxModel().rotateBlockRight();
            getBoxModel().rotateBlockRight();
            getBoxModel().rotateBlockRight();
            getBoxModel().rotateBlockRight();
            return this;
        }

        public void equalsTo(int[][] expectedMatrix) {
            assertMatricesEquals(expectedMatrix, this.boxModel.getMatrix());
        }

        private void assertBlockInsideTheBox() {
            assertNotNull(boxModel, "Box model is not defined. Did you call 'putInBox(box)?'");
        }

        public Box getBoxModel() {
            assertBlockInsideTheBox();
            return boxModel;
        }
    }

}
