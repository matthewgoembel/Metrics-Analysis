/**
 * A concise, well-structured Sudoku solver.
 * Designed to minimize code smells and technical debt.
 */
public class SudokuRefined {

    private static final int SIZE = 9;

    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No valid solution found.");
        }
    }

    /**
     * Recursively solves the Sudoku puzzle using a backtracking approach.
     *
     * @param board the Sudoku grid
     * @return true if solved, false if no solution
     */
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // All cells filled
    }

    /**
     * Checks if placing 'num' at board[row][col] is valid according to Sudoku rules.
     *
     * @param board the Sudoku grid
     * @param row   the current row index
     * @param col   the current col index
     * @param num   the candidate number (1-9)
     * @return true if valid placement, false otherwise
     */
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Row and column check
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        // Sub-box check
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[boxRowStart + r][boxColStart + c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Prints the Sudoku board in a simple format.
     *
     * @param board the Sudoku grid
     */
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
