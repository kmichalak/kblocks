package pl.kmi.kblock.core.core;

public enum Block {

    I {
        @Override
        int[][] getMatrix() {
            return new int[][] {
                    {1},
                    {1},
                    {1},
                    {1}
            };
        }
    },

    O {
        @Override
        int[][] getMatrix() {
            return new int[][] {
                    {1, 1},
                    {1, 1}
            };
        }
    },

    T {
        @Override
        int[][] getMatrix() {
            return new int[][] {
                    {1, 1, 1},
                    {0, 1, 0}
            };
        }
    },

    L {
        @Override
        int[][] getMatrix() {
            return new int[][] {
                    {1, 0},
                    {1, 0},
                    {1, 0},
                    {1, 1}
            };
        }
    },

    J {
        @Override
        int[][] getMatrix() {
            return new int[][] {
                    {0, 1},
                    {0, 1},
                    {0, 1},
                    {1, 1}
            };
        }
    },

    S {
        @Override
        int[][] getMatrix() {
            return new int[][] {
                    {0, 1, 1},
                    {1, 1, 0}
            };
        }
    },

    Z {
        @Override
        int[][] getMatrix() {
            return new int[][] {
                    {1, 1, 0},
                    {0, 1, 1}
            };
        }
    };

    abstract int[][] getMatrix();

}
