package pl.kmi.kblock.core.rotation.wall;

import pl.kmi.kblock.core.model.Box;

public class RotateOnTheWallTest {

    public void rotateBlockRight90(Box boxModel) {
        boxModel.rotateBlockRight();
    }

    public void rotateBlockRight180(Box boxModel) {
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();
    }

    public void rotateBlockRight270(Box boxModel) {
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();
    }

    public void rotateBlockRight360(Box boxModel) {
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();
        boxModel.rotateBlockRight();
    }


    public void stickToTheRightWall(Box boxModel) {
        while (boxModel.canMoveBlockRight()) {
            boxModel.moveBlockRight();
        }
    }

    public void stickToTheLeftWall(Box boxModel) {
        while (boxModel.canMoveBlockLeft()) {
            boxModel.moveBlockLeft();
        }
    }



}
