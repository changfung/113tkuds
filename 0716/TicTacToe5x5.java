import java.util.Scanner;

public class TicTacToe5x5 {
    private static final int SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = initializeBoard();
        char currentPlayer = PLAYER_X;

        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard(board);

        while (true) {
            int row = -1, col = -1;
            boolean validMove = false;

            while (!validMove) {
                System.out.printf("玩家 %c 請輸入 row col (0~4): ", currentPlayer);
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                } else {
                    scanner.next(); // 跳過非整數
                    System.out.println("請輸入整數座標！");
                    continue;
                }

                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                } else {
                    scanner.next(); // 跳過非整數
                    System.out.println("請輸入整數座標！");
                    continue;
                }

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                    System.out.printf("無效座標：(%d, %d)\n", row, col);
                } else if (board[row][col] != EMPTY) {
                    System.out.printf("位置 (%d, %d) 已被佔用\n", row, col);
                } else {
                    validMove = true;
                }
            }

            board[row][col] = currentPlayer;
            System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", currentPlayer, row, col);
            printBoard(board);

            if (checkWinner(board, currentPlayer)) {
                System.out.printf("玩家 %c 獲勝！\n", currentPlayer);
                break;
            } else if (isBoardFull(board)) {
                System.out.println("平手！");
                break;
            }

            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }

        scanner.close();
    }

    // 初始化棋盤
    static char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
        return board;
    }

    // 列印棋盤
    static void printBoard(char[][] board) {
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    // 判斷是否獲勝
    static boolean checkWinner(char[][] board, char player) {
        // 檢查每一行
        for (int row = 0; row < SIZE; row++) {
            boolean win = true;
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // 檢查每一列
        for (int col = 0; col < SIZE; col++) {
            boolean win = true;
            for (int row = 0; row < SIZE; row++) {
                if (board[row][col] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // 主對角線
        boolean win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != player) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // 反對角線
        win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] != player) {
                win = false;
                break;
            }
        }
        return win;
    }

    // 判斷棋盤是否已滿
    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) return false;
            }
        }
        return true;
    }
}

