package pl.kmi.kblock.core.core;

public enum Block {

    I {
        @Override
        public int[][] getMatrix() {
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
        public int[][] getMatrix() {
            return new int[][] {
                    {1, 1},
                    {1, 1}
            };
        }
    },

    T {
        @Override
        public int[][] getMatrix() {
            return new int[][] {
                    {1, 1, 1},
                    {0, 1, 0}
            };
        }
    },

    L {
        @Override
        public int[][] getMatrix() {
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
        public int[][] getMatrix() {
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
        public int[][] getMatrix() {
            return new int[][] {
                    {0, 1, 1},
                    {1, 1, 0}
            };
        }
    },

    Z {
        @Override
        public int[][] getMatrix() {
            return new int[][] {
                    {1, 1, 0},
                    {0, 1, 1}
            };
        }
    };

    public abstract int[][] getMatrix();

}
