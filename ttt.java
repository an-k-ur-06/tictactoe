import java.util.Scanner;
public class ttt{
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        char currentPlayer = 'X';
        boolean gameWon = false;


        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to Tic Tac Toe!");
        printBoard(board);


        for (int moves = 0; moves < 9; moves++) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column: 1-3 each): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;


            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                moves--;
                continue;
            }


            board[row][col] = currentPlayer;
            printBoard(board);


            if (checkWinner(board, currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
                break;
            }


            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }


        if (!gameWon) {
            System.out.println("It's a draw!");
        }


        scanner.close();
    }


    private static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }


    }


    private static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || 
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
