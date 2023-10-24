public class Connect4 extends ConsoleProgram {

    private static int p1 = 1;
    private static int pS;

    public static void main(String[] args) {
        ConsoleProgram c = new ConsoleProgram();
        Grid grid = new Grid();
        grid.printStatus(c);

        /* for (int i = 0; i < 5; i++) {
            playerTurn(c, 1, grid);
        }
        grid.frames(c, 6, 1); */

        // grid.grid.length;

        askPlayers(c);
        grid.printStatus(c);
        if (pS == 2) {
            while (!(grid.checkRows() || grid.checkCols() || grid.checkDiags())) {
                playerTurn(c, p1, grid);
                boolean bool1 = grid.checkRows() || grid.checkCols() || grid.checkDiags();
                // c.println("Booled");
                if (bool1) {
                    // c.println("done");
                    break;
                }
                playerTurn(c, pS, grid);
            }
            if (grid.getWin() == 2) {
                c.reset();
                p2Win(c);
            }
            else {
                c.reset();
                p1Win(c);
            }

        }
        else if (pS == 3) {
            while (!(grid.checkRows() || grid.checkCols() || grid.checkDiags())) {
                playerTurn(c, p1, grid);
                boolean bool = grid.checkRows() || grid.checkCols() || grid.checkDiags();
                // c.println("Booled");
                if (bool) {
                    // c.println("done");
                    break;
                }
                playerTurn(c, pS, grid);
            }
            if (grid.getWin() == 3) {
                c.reset();
                lose(c);
            }
            else {
                c.reset();
                p1Win(c);
            }
        }
        // c.println(grid.checkRows() + " Row\n" + grid.checkCols() + " Col\n" + grid.checkDiags() + " diags\n" + grid.getWin());

    }
    //Note - Add computer option/random to all plyr methods


    public void run() {

    }

    public static int askCol(ConsoleProgram c, Grid g, int plyr) {
        while (true) {
            int col = c.readInt("Player " + plyr + " - Enter a column: ") - 1;
            if (col <= 6 && col >= 0) {
                if (g.getColNum(col) == 6) {
                    c.println("Column full");
                    continue;
                }
                else {
                    return col;
                }
            }
            else {
                c.println("Not a valid column");
                continue;
            }
        }
    }

    public static void askPlayers(ConsoleProgram c) {
        while (true) {
            int numP = c.readInt("1 or 2 players? ");
            if (numP == 1) {
                pS = 3;
                c.reset();
                return;
            }
            else if (numP == 2) {
                pS = 2;
                c.reset();
                return;
            }
            else {
                c.println("Not a valid input");
                continue;
            }
        }
    }

    public static void playerTurn(ConsoleProgram c, int plyr, Grid g) {
        if (plyr == 3) {
            // g.addTile(g.checkNum(), plyr);
            g.frames(c, g.checkNum(), plyr);
        }
        else {
            // g.addTile(askCol(c, g, plyr), plyr);
            g.frames(c, askCol(c, g, plyr), plyr);
        }
        c.reset();
        g.printStatus(c);
        // if ()
    }

    public static void delay(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {}
    }

    public static void p2Win(ConsoleProgram c) {
        c.println("- - - - - - - ");
        c.println("- O O O - - - ");
        c.println("- O - - O - - ");
        c.println("- O O O - - - ");
        c.println("- O - - - - - ");
        c.println("- O - - - - - ");
        c.println("");
        c.println("- - - - - - - ");
        c.println("- - O O - - - ");
        c.println("- O - - O - - ");
        c.println("- - - - O - - ");
        c.println("- - - O - - - ");
        c.println("- O O O O - - ");
        c.println("");
        c.println("- - - - - - - ");
        c.println("O - - O - - O ");
        c.println("- O - O - O - ");
        c.println("- O - O - O - ");
        c.println("- O - O - O - ");
        c.println("- - O O O - - ");
        c.println("");
        c.println("- O O O O O - ");
        c.println("- - - O - - - ");
        c.println("- - - O - - - ");
        c.println("- - - O - - - ");
        c.println("- - - O - - - ");
        c.println("- O O O O O - ");
        c.println("");
        c.println("- - - - - - - ");
        c.println("- O - - - O - ");
        c.println("- O O - - O - ");
        c.println("- O - O - O - ");
        c.println("- O - - O O - ");
        c.println("- O - - - O - ");
        c.println("");
        c.println("- - O O O - - ");
        c.println("- O - - - O - ");
        c.println("- - O - - - - ");
        c.println("- - - O O - - ");
        c.println("- O - - - O - ");
        c.println("- - O O O - - ");
        c.println("");
        c.println("- - - O - - - ");
        c.println("- - - O - - - ");
        c.println("- - - O - - - ");
        c.println("- - - O - - - ");
        c.println("- - - - - - - ");
        c.println("- - - O - - - ");
    }

    public static void p1Win(ConsoleProgram c) {
        c.println("- - - - - - - ");
        c.println("- X X X - - - ");
        c.println("- X - - X - - ");
        c.println("- X X X - - - ");
        c.println("- X - - - - - ");
        c.println("- X - - - - - ");
        c.println("");
        c.println("- - - X - - - ");
        c.println("- - X X - - - ");
        c.println("- X - X - - - ");
        c.println("- - - X - - - ");
        c.println("- - - X - - - ");
        c.println("- X X X X X - ");
        c.println("");
        c.println("- - - - - - - ");
        c.println("X - - X - - X ");
        c.println("- X - X - X - ");
        c.println("- X - X - X - ");
        c.println("- X - X - X - ");
        c.println("- - X X X - - ");
        c.println("");
        c.println("- X X X X X - ");
        c.println("- - - X - - - ");
        c.println("- - - X - - - ");
        c.println("- - - X - - - ");
        c.println("- - - X - - - ");
        c.println("- X X X X X - ");
        c.println("");
        c.println("- - - - - - - ");
        c.println("- X - - - X - ");
        c.println("- X X - - X - ");
        c.println("- X - X - X - ");
        c.println("- X - - X X - ");
        c.println("- X - - - X - ");
        c.println("");
        c.println("- - X X X - - ");
        c.println("- X - - - X - ");
        c.println("- - X - - - - ");
        c.println("- - - X X - - ");
        c.println("- X - - - X - ");
        c.println("- - X X X - - ");
        c.println("");
        c.println("- - - X - - - ");
        c.println("- - - X - - - ");
        c.println("- - - X - - - ");
        c.println("- - - X - - - ");
        c.println("- - - - - - - ");
        c.println("- - - X - - - ");
    }

    public static void lose(ConsoleProgram c) {
        c.println("- X - - - X - ");
        c.println("- X - - - X - ");
        c.println("- - X - X - - ");
        c.println("- - - X - - - ");
        c.println("- - - X - - - ");
        c.println("- - - X - - - ");
        c.println("");
        c.println("- - - - - - - ");
        c.println("- - X X X - - ");
        c.println("- X - - - X - ");
        c.println("- X - - - X - ");
        c.println("- X - - - X - ");
        c.println("- - X X X - - ");
        c.println("");
        c.println("- - - - - - - ");
        c.println("- X - - - X - ");
        c.println("- X - - - X - ");
        c.println("- X - - - X - ");
        c.println("- X - - - X - ");
        c.println("- - X X X - - ");
        c.println("");
        c.println("- X - - - - - ");
        c.println("- X - - - - - ");
        c.println("- X - - - - - ");
        c.println("- X - - - - - ");
        c.println("- X - - - - - ");
        c.println("- X X X X X - ");
        c.println("");
        c.println("- - - - - - - ");
        c.println("- - X X X - - ");
        c.println("- X - - - X - ");
        c.println("- X - - - X - ");
        c.println("- X - - - X - ");
        c.println("- - X X X - - ");
        c.println("");
        c.println("- - X X X - - ");
        c.println("- X - - - X - ");
        c.println("- - X - - - - ");
        c.println("- - - X X - - ");
        c.println("- X - - - X - ");
        c.println("- - X X X - - ");
        c.println("");
        c.println("- - - - - - - ");
        c.println("- X X X X X - ");
        c.println("- X - - - - - ");
        c.println("- X X X X X - ");
        c.println("- X - - - - - ");
        c.println("- X X X X X - ");
    }
}