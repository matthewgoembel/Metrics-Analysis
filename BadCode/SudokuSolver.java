
public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = new int[9][9];

        board[0][0] = 5; board[0][1] = 3; board[0][4] = 7;
        board[1][0] = 6; board[1][3] = 1; board[1][4] = 9; board[1][5] = 5;
        board[2][1] = 9; board[2][2] = 8; board[2][7] = 6;
        board[3][0] = 8; board[3][4] = 6; board[3][8] = 3;
        board[4][0] = 4; board[4][3] = 8; board[4][5] = 3; board[4][8] = 1;
        board[5][0] = 7; board[5][4] = 2; board[5][8] = 6;
        board[6][1] = 6; board[6][6] = 2; board[6][7] = 8;
        board[7][3] = 4; board[7][4] = 1; board[7][5] = 9; board[7][8] = 5;
        board[8][4] = 8; board[8][7] = 7; board[8][8] = 9;

        solve(board);

        // print board
        int r = 0;
        while (r < 9) {
            int c = 0;
            while (c < 9) {
                System.out.print(board[r][c] + " ");
                c = c + 1;
            }
            System.out.println();
            r = r + 1;
        }
    }

    public static boolean solve(int[][] board) {
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

    public static boolean try1(int[][] b, int r, int c) {
        if (isOkay(b, r, c, 1)) {
            b[r][c] = 1;
            if (solve(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    public static boolean try2(int[][] b, int r, int c) {
        if (isOkay(b, r, c, 2)) {
            b[r][c] = 2;
            if (solve(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    public static boolean try3(int[][] b, int r, int c) {
        if (isOkay(b, r, c, 3)) {
            b[r][c] = 3;
            if (solve(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    public static boolean try4(int[][] b, int r, int c) {
        if (isOkay(b, r, c, 4)) {
            b[r][c] = 4;
            if (solve(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    public static boolean try5(int[][] b, int r, int c) {
        if (isOkay(b, r, c, 5)) {
            b[r][c] = 5;
            if (solve(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    public static boolean try6(int[][] b, int r, int c) {
        if (isOkay(b, r, c, 6)) {
            b[r][c] = 6;
            if (solve(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    public static boolean try7(int[][] b, int r, int c) {
        if (isOkay(b, r, c, 7)) {
            b[r][c] = 7;
            if (solve(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    public static boolean try8(int[][] b, int r, int c) {
        if (isOkay(b, r, c, 8)) {
            b[r][c] = 8;
            if (solve(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }
    public static boolean try9(int[][] b, int r, int c) {
        if (isOkay(b, r, c, 9)) {
            b[r][c] = 9;
            if (solve(b)) return true;
            b[r][c] = 0;
        }
        return false;
    }

    public static boolean isOkay(int[][] board, int row, int col, int num) {
        int i = 0;
        while (i < 9) {
            if (board[row][i] == num) return false;
            i = i + 1;
        }

        int j = 0;
        while (j < 9) {
            if (board[j][col] == num) return false;
            j = j + 1;
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        int x = 0;
        while (x < 3) {
            int y = 0;
            while (y < 3) {
                if (board[startRow + x][startCol + y] == num) return false;
                y = y + 1;
            }
            x = x + 1;
        }

        return true;
    }
}
