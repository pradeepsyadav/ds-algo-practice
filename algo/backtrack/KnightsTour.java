public class KnightsTour {

    static int[][] initializeBoard(int N) {

        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = -1;

        return board;
    }

    static void solve(int N) {

        int[][] board = initializeBoard(N);
        
        int[] unitx = {2, 1, -1, -2, -2, -1, 1, 2};
        int unity[] = {1, 2, 2, 1, -1, -2, -2, -1};
        
        
        int currX = 0;
        int currY = 0;
        int moveCounter = 1;
        board[0][0] = 0;

        if (!findSolution(board, currX, currY, unitx, unity, moveCounter)) {
            System.out.println("No solution for present configuration");
        } else {
            printSolution(board);
        }
    }

    static boolean findSolution(int[][] board, int currX, int currY, int[] unitx, int[] unity, int moveCounter) {

        if (moveCounter == 64) {
            return true;
        }

        for (int route = 0; route < 8; route++) {

            int nextX = currX + unitx[route];
            int nextY = currY + unity[route];

            if (canMoveTo(nextX, nextY, board)) {
                board[nextX][nextY] = moveCounter;
                if (findSolution(board, nextX, nextY, unitx, unity, moveCounter + 1)) {
                    return true;
                } else {
                    board[nextX][nextY] = -1;
                }
            }
        }

        return false;
    }

    private static boolean canMoveTo(int nextX, int nextY, int[][] board) {
        return (nextX >= 0 && nextX < 8
                && nextY >= 0 &&nextY < 8
                && board[nextX][nextY] == -1);
    }

    private static void printSolution(int[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%2d | ", board[i][j]);
            }
            System.out.printf("\n%38s\n", "-".repeat(38));
        }
    }

    public static void main(String[] args) {
        solve(8);
    }
}
