public class WorstSudokuEver {

    public static final int ROWS = 9;
    public static final int COLS = 9;

    public static final int R = ROWS;
    public static final int C = COLS;
    
    public static void main(String[] args) {
        int[][] puzzle = new int[ROWS][COLS];

        puzzle[0][0] = 5; puzzle[0][1] = 3; puzzle[0][4] = 7;
        puzzle[1][0] = 6; puzzle[1][3] = 1; puzzle[1][4] = 9; puzzle[1][5] = 5;
        puzzle[2][1] = 9; puzzle[2][2] = 8; puzzle[2][7] = 6;
        puzzle[3][0] = 8; puzzle[3][4] = 6; puzzle[3][8] = 3;
        puzzle[4][0] = 4; puzzle[4][3] = 8; puzzle[4][5] = 3; puzzle[4][8] = 1;
        puzzle[5][0] = 7; puzzle[5][4] = 2; puzzle[5][8] = 6;
        puzzle[6][1] = 6; puzzle[6][6] = 2; puzzle[6][7] = 8;
        puzzle[7][3] = 4; puzzle[7][4] = 1; puzzle[7][5] = 9; puzzle[7][8] = 5;
        puzzle[8][4] = 8; puzzle[8][7] = 7; puzzle[8][8] = 9;


        solvePuzzle(puzzle);
        solvePuzzle2(puzzle);  

        solvePuzzle3(puzzle);

        printPuzzle(puzzle);
    }


    public static void solvePuzzle(int[][] board) {
        int row = 0;
        while (row < ROWS) {
            int col = 0;
            while (col < COLS) {
                if (board[row][col] == 0) {
   
                    if (isSafeCheck1(board, row, col, 1)) { board[row][col] = 1; if (allDone(board)) { return; } }
                    else if (isSafeCheck1(board, row, col, 2)) { board[row][col] = 2; if (allDone(board)) { return; } }
                    else if (isSafeCheck1(board, row, col, 3)) { board[row][col] = 3; if (allDone(board)) { return; } }
                    else if (isSafeCheck1(board, row, col, 4)) { board[row][col] = 4; if (allDone(board)) { return; } }
                    else if (isSafeCheck1(board, row, col, 5)) { board[row][col] = 5; if (allDone(board)) { return; } }
                    else if (isSafeCheck1(board, row, col, 6)) { board[row][col] = 6; if (allDone(board)) { return; } }
                    else if (isSafeCheck1(board, row, col, 7)) { board[row][col] = 7; if (allDone(board)) { return; } }
                    else if (isSafeCheck1(board, row, col, 8)) { board[row][col] = 8; if (allDone(board)) { return; } }
                    else if (isSafeCheck1(board, row, col, 9)) { board[row][col] = 9; if (allDone(board)) { return; } }
                }
                col++;
            }
            row++;
        }
    }


    public static void solvePuzzle2(int[][] board) {
        int row = 0;
        while (row < ROWS) {
            int col = 0;
            while (col < COLS) {
                if (board[row][col] == 0) {
                    if (isSafeCheck2(board, row, col, 1)) { board[row][col] = 1; if (allDone(board)) { return; } }
                    else if (isSafeCheck2(board, row, col, 2)) { board[row][col] = 2; if (allDone(board)) { return; } }
                    else if (isSafeCheck2(board, row, col, 3)) { board[row][col] = 3; if (allDone(board)) { return; } }
                    else if (isSafeCheck2(board, row, col, 4)) { board[row][col] = 4; if (allDone(board)) { return; } }
                    else if (isSafeCheck2(board, row, col, 5)) { board[row][col] = 5; if (allDone(board)) { return; } }
                    else if (isSafeCheck2(board, row, col, 6)) { board[row][col] = 6; if (allDone(board)) { return; } }
                    else if (isSafeCheck2(board, row, col, 7)) { board[row][col] = 7; if (allDone(board)) { return; } }
                    else if (isSafeCheck2(board, row, col, 8)) { board[row][col] = 8; if (allDone(board)) { return; } }
                    else if (isSafeCheck2(board, row, col, 9)) { board[row][col] = 9; if (allDone(board)) { return; } }
                }
                col++;
            }
            row++;
        }
    }


    public static void solvePuzzle3(int[][] board) {
        int row = 0;
        while (row < R) {
            int col = 0;
            while (col < C) {
                if (board[row][col] == 0) {
                    if (isSafeCheck3(board, row, col, 1)) { board[row][col] = 1; if (allDone(board)) { return; } }
                    else if (isSafeCheck3(board, row, col, 2)) { board[row][col] = 2; if (allDone(board)) { return; } }
                    else if (isSafeCheck3(board, row, col, 3)) { board[row][col] = 3; if (allDone(board)) { return; } }
                    else if (isSafeCheck3(board, row, col, 4)) { board[row][col] = 4; if (allDone(board)) { return; } }
                    else if (isSafeCheck3(board, row, col, 5)) { board[row][col] = 5; if (allDone(board)) { return; } }
                    else if (isSafeCheck3(board, row, col, 6)) { board[row][col] = 6; if (allDone(board)) { return; } }
                    else if (isSafeCheck3(board, row, col, 7)) { board[row][col] = 7; if (allDone(board)) { return; } }
                    else if (isSafeCheck3(board, row, col, 8)) { board[row][col] = 8; if (allDone(board)) { return; } }
                    else if (isSafeCheck3(board, row, col, 9)) { board[row][col] = 9; if (allDone(board)) { return; } }
                }
                col++;
            }
            row++;
        }
    }

    public static boolean allDone(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isSafeCheck1(int[][] board, int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        int rStart = row - row % 3; int cStart = col - col % 3;
        for (int rr = 0; rr < 3; rr++) {
            for (int cc = 0; cc < 3; cc++) {
                if (board[rStart + rr][cStart + cc] == num) return false;
            }
        }
        return true;
    }

    public static boolean isSafeCheck2(int[][] board, int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        int rStart = row - row % 3; int cStart = col - col % 3;
        for (int rr = 0; rr < 3; rr++) {
            for (int cc = 0; cc < 3; cc++) {
                if (board[rStart + rr][cStart + cc] == num) return false;
            }
        }
        return true;
    }

    public static boolean isSafeCheck3(int[][] board, int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        int rStart = row - row % 3; int cStart = col - col % 3;
        for (int rr = 0; rr < 3; rr++) {
            for (int cc = 0; cc < 3; cc++) {
                if (board[rStart + rr][cStart + cc] == num) return false;
            }
        }
        return true;
    }


    public static void printPuzzle(int[][] puzzle) {
        int x = 0;
        while (x < puzzle.length) {
            for (int y = 0; y < puzzle[0].length; y++) {
                System.out.print(puzzle[x][y] + " ");
            }
            System.out.println();
            x++;
        }
    }
}
