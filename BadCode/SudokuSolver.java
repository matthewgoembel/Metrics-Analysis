public class SudokuSolver {

    public static void main(String[] args) {
        // Create a 9x9 Sudoku board with some preset values.
        int[][] sudokuBoard = new int[9][9];
        
        // Hardcoded initial board values (partial puzzle)
        sudokuBoard[0][0] = 5; sudokuBoard[0][1] = 3; sudokuBoard[0][4] = 7;
        sudokuBoard[1][0] = 6; sudokuBoard[1][3] = 1; sudokuBoard[1][4] = 9; sudokuBoard[1][5] = 5;
        sudokuBoard[2][1] = 9; sudokuBoard[2][2] = 8; sudokuBoard[2][7] = 6;
        sudokuBoard[3][0] = 8; sudokuBoard[3][4] = 6; sudokuBoard[3][8] = 3;
        sudokuBoard[4][0] = 4; sudokuBoard[4][3] = 8; sudokuBoard[4][5] = 3; sudokuBoard[4][8] = 1;
        sudokuBoard[5][0] = 7; sudokuBoard[5][4] = 2; sudokuBoard[5][8] = 6;
        sudokuBoard[6][1] = 6; sudokuBoard[6][6] = 2; sudokuBoard[6][7] = 8;
        sudokuBoard[7][3] = 4; sudokuBoard[7][4] = 1; sudokuBoard[7][5] = 9; sudokuBoard[7][8] = 5;
        sudokuBoard[8][4] = 8; sudokuBoard[8][7] = 7; sudokuBoard[8][8] = 9;
        
        // Attempt to solve the Sudoku puzzle
        if (solveSudoku(sudokuBoard)) {
            printSodoku(sudokuBoard);
        } else {
            System.out.println("No solution found!");
        }
    }
    
    // Badly implemented recursive backtracking solver using nine separate methods.
    public static boolean solveSudoku(int[][] board) {
        for (int i = 0; i < 9; i = i + 1) {
            for (int j = 0; j < 9; j = j + 1) {
                if (board[i][j] == 0) {
                    if (try1(board, i, j)) return true;
                    if (try2(board, i, j)) return true;
                    if (try3(board, i, j)) return true;
                    if (try4(board, i, j)) return true;
                    if (try5(board, i, j)) return true;
                    if (try6(board, i, j)) return true;
                    if (try7(board, i, j)) return true;
                    if (try8(board, i, j)) return true;
                    if (try9(board, i, j)) return true;
                    return false;
                }
            }
        }
        return true;
    }
    
    // Nine nearly identical methods for each digit attempt.
    public static boolean try1(int[][] b, int r, int c) {
        if (checkOk(b, r, c, 1)) {
            b[r][c] = 1;
            if (solveSudoku(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    
    public static boolean try2(int[][] b, int r, int c) {
        if (checkOk(b, r, c, 2)) {
            b[r][c] = 2;
            if (solveSudoku(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    
    public static boolean try3(int[][] b, int r, int c) {
        if (checkOk(b, r, c, 3)) {
            b[r][c] = 3;
            if (solveSudoku(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    
    public static boolean try4(int[][] b, int r, int c) {
        if (checkOk(b, r, c, 4)) {
            b[r][c] = 4;
            if (solveSudoku(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    
    public static boolean try5(int[][] b, int r, int c) {
        if (checkOk(b, r, c, 5)) {
            b[r][c] = 5;
            if (solveSudoku(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    
    public static boolean try6(int[][] b, int r, int c) {
        if (checkOk(b, r, c, 6)) {
            b[r][c] = 6;
            if (solveSudoku(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    
    public static boolean try7(int[][] b, int r, int c) {
        if (checkOk(b, r, c, 7)) {
            b[r][c] = 7;
            if (solveSudoku(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    
    public static boolean try8(int[][] b, int r, int c) {
        if (checkOk(b, r, c, 8)) {
            b[r][c] = 8;
            if (solveSudoku(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    
    public static boolean try9(int[][] b, int r, int c) {
        if (checkOk(b, r, c, 9)) {
            b[r][c] = 9;
            if (solveSudoku(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    
    // Extremely verbose and duplicated check routine.
    public static boolean checkOk(int[][] board, int row, int col, int num) {
        if (board[row][0] == num || board[row][1] == num || board[row][2] == num || board[row][3] == num ||
            board[row][4] == num || board[row][5] == num || board[row][6] == num || board[row][7] == num ||
            board[row][8] == num) {
            return false;
        }
        if (board[0][col] == num || board[1][col] == num || board[2][col] == num || board[3][col] == num ||
            board[4][col] == num || board[5][col] == num || board[6][col] == num || board[7][col] == num ||
            board[8][col] == num) {
            return false;
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        if (board[startRow][startCol] == num || board[startRow][startCol + 1] == num ||
            board[startRow][startCol + 2] == num || board[startRow + 1][startCol] == num ||
            board[startRow + 1][startCol + 1] == num || board[startRow + 1][startCol + 2] == num ||
            board[startRow + 2][startCol] == num || board[startRow + 2][startCol + 1] == num ||
            board[startRow + 2][startCol + 2] == num) {
            return false;
        }
        // Unnecessarily repeating row check again
        if (board[row][0] == num || board[row][1] == num || board[row][2] == num || board[row][3] == num ||
            board[row][4] == num || board[row][5] == num || board[row][6] == num || board[row][7] == num ||
            board[row][8] == num) {
            return false;
        }
        return true;
    }
    
    // Print board using while loops (inefficient and clunky)
    public static void printSodoku(int[][] board) {
        int i = 0;
        while (i < 9) {
            int j = 0;
            while (j < 9) {
                System.out.print(board[i][j] + " ");
                j = j + 1;
            }
            System.out.println();
            i = i + 1;
        }
    }
}
