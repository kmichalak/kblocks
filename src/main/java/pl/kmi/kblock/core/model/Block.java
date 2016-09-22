package pl.kmi.kblock.core.model;

public enum Block {

    I {
        @Override
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
            };
        }
    },

    O {
        @Override
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1},
                    {1, 1},
            };
        }
    },

    T {
        @Override
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1, 1},
                    {0, 1, 0},
                    {0, 0, 0}
            };
        }
    },

    L {
        @Override
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 1, 0, 0},
                    {0, 1, 0, 0},
                    {0, 1, 1, 0},
                    {0, 0, 0, 0},
            };
        }
    },

    J {
        @Override
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 1, 1, 0},
                    {0, 0, 0, 0},
            };
        }
    },

    S {
        @Override
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 0, 1, 1},
                    {0, 1, 1, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
            };
        }
    },

    Z {
        @Override
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1, 0, 0},
                    {0, 1, 1, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
            };
        }
    };

    public abstract int[][] getMatrix();

}
