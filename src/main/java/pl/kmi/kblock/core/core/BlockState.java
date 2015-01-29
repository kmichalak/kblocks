package pl.kmi.kblock.core.core;

public class BlockState {

    private Block block;
    private int currentXPosition;
    private int currentYPosition;

    public BlockState(Block block, int currentXPosition, int currentYPosition) {
        this.block = block;
        this.currentXPosition = currentXPosition;
        this.currentYPosition = currentYPosition;
    }

    public void moveBlockDown() {
        currentYPosition++;
    }

    public void moveBlockLeft() {
        currentXPosition--;
    }

    public void moveBlockRight() {
        currentXPosition++;
    }

    public int getCurrentXPosition() {
        return currentXPosition;
    }

    public int getCurrentYPosition() {
        return currentYPosition;
    }
}
