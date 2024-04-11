import java.util.Scanner;

public class ticTacToe {
    public static void main(String[] args) {
        ticTacToe ticTacToe = new ticTacToe();
        ticTacToe.displayWelcomeMessage();
        ticTacToe.startGame();
    }

    private char[][] board;
    private int rowNumber;
    private int columnNumber;
    private char markSelected;

    public ticTacToe() {
        this.board = new char[3][3];
        this.rowNumber = 0;
        this.columnNumber = 0;
        this.markSelected = ' ';
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Tic Tac Toe!");
    }

    public void displayGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void startGame() {
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            displayGrid();
            gameOver = takeTurn(scanner);
        }

        scanner.close();
    }

    public boolean takeTurn(Scanner scanner) {
        determineMarkSelected();
        promptRowNumber(scanner);
        promptColumnNumber(scanner);

        if (board[rowNumber][columnNumber] != ' ') {
            System.out.println("Cell already taken. Please choose another.");
            return false;
        }

        board[rowNumber][columnNumber] = markSelected;
        displayGrid();

        return checkForWinner();
    }

    private void determineMarkSelected() {
        markSelected = (markSelected == 'X') ? 'O' : 'X';
        System.out.println("Player " + markSelected + ", it's your turn.");
    }

    private void promptRowNumber(Scanner scanner) {
        System.out.print("Enter row number (0-2): ");
        rowNumber = scanner.nextInt();
    }

    private void promptColumnNumber(Scanner scanner) {
        System.out.print("Enter column number (0-2): ");
        columnNumber = scanner.nextInt();
    }

    public boolean checkForWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                System.out.println("Player " + markSelected + " wins!");
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                System.out.println("Player " + markSelected + " wins!");
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
            (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
            System.out.println("Player " + markSelected + " wins!");
            return true;
        }

        return false;
    }
}


