/**
 * SudokuElegant is a concise, well-structured Sudoku solver.
 * It uses clear naming, avoids code duplication, and minimizes complexity.
 */
public class BestSudokuSolverEver {

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

        if (solve(board)) {
            displayBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    /**
     * Recursively solves the Sudoku puzzle using a standard backtracking approach.
     *
     * @param board the 9x9 Sudoku grid
     * @return true if the puzzle is solved, false otherwise
     */
    public static boolean solve(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = 0; // Reset on backtrack
                        }
                    }
                    return false; // No valid number found in this position
                }
            }
        }
        return true; // Puzzle solved, all cells are non-zero
    }

    /**
     * Determines if placing a given number in the specified cell is valid.
     *
     * @param board the Sudoku grid
     * @param row   the row index
     * @param col   the column index
     * @param num   the candidate number to place (1-9)
     * @return true if placement is valid, false otherwise
     */
    public static boolean isValid(int[][] board, int row, int col, int num) {
        // Check the row and column for the number
        for (int index = 0; index < SIZE; index++) {
            if (board[row][index] == num || board[index][col] == num) {
                return false;
            }
        }
        // Check the 3x3 sub-grid for the number
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
     * Assembles the board into a string and prints it in one go.
     *
     * @param board the Sudoku grid
     */
    public static void displayBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb.toString());
    }
}
