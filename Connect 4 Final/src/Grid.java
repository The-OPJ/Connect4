public class Grid {

    private int[] colAmts;
    private Location[][] grid;
    private static final int NUM_COLS = 7;
    private static final int NUM_ROWS = 6;
    private static final int[] diags1 = {4, 5, 6};
    private static final int[] diags2 = {6, 5, 4};
    private int winner;

    public Grid() {
        colAmts = new int[NUM_COLS];
        grid = new Location[NUM_ROWS][NUM_COLS];
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                grid[i][j] = new Location();
            }
        }
        winner = -1;
    }

    public int getColNum(int col) {
        return colAmts[col];
    }

    public void printStatus(ConsoleProgram c) {
        for (int z = 1; z <= NUM_COLS; z++) {
            c.print(z + " ");
        }
        c.println();

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                c.print(grid[i][j].getStatusName() + " ");

            }
            c.println();
        }
    }

    public void addTile(int col, int plyr) {
        colAmts[col] += 1;
        int row = 6 - colAmts[col];
        grid[row][col].setStatus(plyr);
    }

    public boolean hasWon() {
        return false;
    }

    public boolean checkRows() {
        int currD = -1;
        int newD;
        int count = 1;

        // System.out.println("Checking");

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {

                newD = grid[i][j].getStatus();
                if (newD == currD && newD != 0) {
                    count++;
                    if (count == 4) {
                        winner = newD;
                        return true;
                    }
                }
                else {
                    count = 1;
                }

                currD = grid[i][j].getStatus();

            }
            count = 1;
        }
        return false;
    }

    public boolean checkCols() {
        int currC = -1;
        int newC;
        int count = 1;

        // System.out.println("Checking");

        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {

                newC = grid[j][i].getStatus();
                if (newC == currC && newC != 0) {
                    count++;
                    if (count == 4) {
                        winner = newC;
                        return true;
                    }
                }
                else {
                    count = 1;
                }

                currC = grid[j][i].getStatus();

            }
            count = 1;
        }
        return false;
    }

    public boolean checkDiags() {
        int currS = -1;
        int newS;
        int count = 1;

        // System.out.println("Checking");

        for (int i = 3; i < diags1.length + 3; i++) {
            for (int j = 0; j < diags1[i - 3]; j++) {

                newS = grid[i - j][0 + j].getStatus();

                if (newS == currS && newS != 0) {
                    count++;
                    if (count == 4) {
                        winner = newS;
                        // System.out.println("Diag 1");
                        return true;
                    }
                }
                else {
                    count = 1;
                }

                currS = grid[i - j][0 + j].getStatus();
            }
            count = 1;
        }
        currS = -1;
        for (int i = 3; i < diags1.length + 3; i++) {
            for (int j = 0; j < diags1[i - 3]; j++) {

                newS = grid[i - j][6 - j].getStatus();

                if (newS == currS && newS != 0) {
                    count++;
                    if (count == 4) {
                        winner = newS;
                        // System.out.println("Diag 2");
                        return true;
                    }
                }
                else {
                    count = 1;
                }

                currS = grid[i - j][6 - j].getStatus();
            }
            count = 1;
        }

        currS = -1;
        for (int i = 0; i < diags2.length; i++) {
            for (int j = 0; j < diags2[i]; j++) {

                newS = grid[i + j][0 + j].getStatus();

                if (newS == currS && newS != 0) {
                    count++;
                    if (count == 4) {
                        winner = newS;
                        // System.out.println("Diag 3");
                        return true;
                    }
                }
                else {
                    count = 1;
                }

                currS = grid[i + j][0 + j].getStatus();
            }
            count = 1;
        }
        currS = -1;
        for (int i = 0; i < diags2.length; i++) {
            for (int j = 0; j < diags2[i]; j++) {

                newS = grid[i + j][6 - j].getStatus();

                if (newS == currS && newS != 0) {
                    count++;
                    if (count == 4) {
                        winner = newS;
                        // System.out.println("Diag 4");
                        return true;
                    }
                }
                else {
                    count = 1;
                }

                currS = grid[i + j][6 - j].getStatus();
            }
            count = 1;
        }

        return false;
    }

    public int checkNum() {
        while (true) {

            int i = Randomizer.nextInt(0, 6);

            if (colAmts[i] == 6) {
                continue;
            }
            else {
                return i;
            }
        }
    }

    public int getWin() {
        return winner;
    }

    public void frames(ConsoleProgram c, int col, int plyr) {
        if (colAmts[col] == 6) {
            System.out.println("Error");
            return;
        }



        for (int l = 0; l < 6 - colAmts[col]; l++) {
            c.reset();
            for (int z = 1; z <= NUM_COLS; z++) {
                c.print(z + " ");
            }
            c.println();

            for (int i = 0; i < NUM_ROWS; i++) {
                for (int j = 0; j < NUM_COLS; j++) {

                    if (i == l && j == col) {
                        if (plyr == 1) {
                            c.print("X ");
                        }
                        else if (plyr == 2) {
                            c.print("O ");
                        }
                        else if (plyr == 3) {
                            c.print("C ");
                        }
                    }
                    else {
                        c.print(grid[i][j].getStatusName() + " ");
                    }

                }
                c.println();
            }
            delay(200);
        }
        addTile(col, plyr);
    }

    public void delay(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {}
    }
}