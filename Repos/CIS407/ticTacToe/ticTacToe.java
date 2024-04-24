
public class TicTacToe {
	private char[][] data;
	private int rowNumber;
	private int columnNumber;
	private char markSelected;
	
	public TicTacToe() {
		data = new char[3][3];
		rowNumber = 0;
		columnNumber = 0;
		markSelected = 'X';
	}
	
	public void displayWelcomeMessage() {
		System.out.println("Welcome to Tic Tac Toe");
	}
	
	public void displayGrid() {
		System.out.println("+---+---+---+");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(data[i][j] + " | ");
			}
			System.out.println("\n+---+---+---+");
		}
	}
	
	public void startGame() {
		boolean gameOver = false;
		while (!gameOver) {
			takeTurn();
			displayGrid();
			gameOver = checkForWinner();
		}
	}
	
	public void takeTurn() {
		System.out.println(markSelected + "'s turn");
		System.out.print("Pick a row (1, 2, 3): ");
		rowNumber = readInput() - 1;
		System.out.print("Pick a column (1, 2, 3): ");
		columnNumber = readInput() - 1;
		
		while (data[rowNumber][columnNumber] != '\u0000') {
			System.out.println("Cell already marked. Choose another.");
			System.out.print("Pick a row (1, 2, 3): ");
			rowNumber = readInput() - 1;
			System.out.print("Pick a column (1, 2, 3): ");
			columnNumber = readInput() - 1;
		}
	
		data[rowNumber][columnNumber] = markSelected;
	
		markSelected = (markSelected == 'X') ? 'O' : 'X';
	}

	private int readInput() {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		int input = scanner.nextInt();
		scanner.nextLine();
		return input;
	}

	public boolean checkForWinner() {
		for (int i = 0; i < 3; i++) {
			if (data[i][0] != '\u0000' && data[i][0] == data[i][1] && data[i][1] == data[i][2]) {
				System.out.println("Player " + data[i][0] + " wins!");
				return true;
			}
		}
	
		for (int j = 0; j < 3; j++) {
			if (data[0][j] != '\u0000' && data[0][j] == data[1][j] && data[1][j] == data[2][j]) {
				System.out.println("Player " + data[0][j] + " wins!");
				return true;
			}
		}
	
		if (data[0][0] != '\u0000' && data[0][0] == data[1][1] && data[1][1] == data[2][2]) {
			System.out.println("Player " + data[0][0] + " wins!");
			return true;
		}
	
		if (data[0][2] != '\u0000' && data[0][0] == data[1][1] && data[1][1] == data[2][0]) {
			System.out.println("Player " + data[0][2] + " wins!");
			return true;
		}
	
		int totalMoves = 0;
		for (char[] row : data) {
			for (char cell : row) {
				if (cell != '\u0000') {
					totalMoves++;
				}
			}
		}
	
		if (totalMoves == 9) {
			System.out.println("It's a tie!");
			return true;
		}
	
		return false;
	}
}




