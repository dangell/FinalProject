//inserts a scanner that will be later used to check for user input
import java.util.Scanner;

/**
 * Name: Dylan Angell
 * Teacher: Mr.Hardman
 * Final Assignment 
 * Date Last Modified: 1/19/2017
 */
public class TicTacToe
{

	//creates a board 
	private static char[][] board = new char[3][3];

	public static void main( String[] args )
	{
		
		//Scanner to check for the program users input
		Scanner userInput = new Scanner(System.in);

		initBoard();
		displayBoard();
		
		String playerOne;
		String playerTwo; 
		
		int row = -1;
		int column = -1;
		
		boolean player1Win = false;
		boolean player2Win = false;
		boolean filledBoard = false;
		
		System.out.println("Please enter player one's name");
		playerOne = userInput.next();
		
		System.out.println("Please enter player two's name");
		playerTwo = userInput.next();
		
		do{
			if(player2Win == false && filledBoard == false){
				
				//this code checks if the row the user wants is full
				while(row == -1){
					System.out.println(playerOne + ", pick the row you want to place your X in");
					row = userInput.nextInt();
					
					//Actual checking of the row
					if(board[row][0] != ' ' && board[row][1] != ' ' && board[row][2] != ' '){
						System.out.println("That row is already taken please choose another");
						row = -1;
					}
				}
				//this code checks if the column the user wants is full
				while(column == -1){
					
					System.out.println(playerOne + ", pick the column you want to place your X in");
					column = userInput.nextInt();
					
					//Checks if the column is already full
					if(board[0][column] != ' ' && board[1][column] != ' ' && board[2][column] != ' '){
						System.out.println("That column is already taken please choose another");
						column = -1;
					}
					//checks if that position is taken
					else if(board[row][column] != ' '){
						System.out.println("That position is already taken, please choose another");
						column = -1;
					}
				}
				//sets the position the user entered with an X
				board[row][column] = 'X';
				
				displayBoard();
				
				player1Win = checkPlayer1Win();
				filledBoard = isFilled();
				
				row = -1;
				column = -1;
			}
			
			if(player1Win == false && filledBoard == false){
				
				//this code checks if the row the second user wants it full
				while(row == -1){
					System.out.println(playerTwo + ", pick the row you want to place your O in");
					row = userInput.nextInt();
					
					if(board[row][0] != ' ' && board[row][1] != ' ' && board[row][2] != ' '){
						System.out.println("That row is already taken please choose another");
						row = -1;
					}
				}
				
				
				//this code checks if the column the second user wants is full
				while(column == -1){
					System.out.println(playerTwo + ", pick the column you want to place your O in");
					column = userInput.nextInt();
					
					if(board[0][column] != ' ' && board[1][column] != ' ' && board[2][column] != ' '){
						System.out.println("That column is already taken please choose another");
						column = -1;
					}
					else if(board[row][column] != ' '){
						System.out.println("That position is already taken, please choose another");
						column = -1;
					}
				}
				//Sets the position the user entered with an O
				board[row][column] = 'O';
				
				displayBoard();
				
				player2Win = checkPlayer2Win();
				
				row = -1;
				column = -1;
			}
			
		}while( player1Win == false && player2Win == false && filledBoard == false );
		
		//If player one has three X's in a row, says player one wins in a formatted way
		if(player1Win == true){
			System.out.println(String.format(playerOne + "%-10s", ", you win!" ));
		}
		
		//If player two has three O's in a row, says player two wins in a formatted way
		else if(player2Win == true){
			System.out.println(String.format(playerTwo + "%-10s", ", you win!" ));
		}
		
		else if(filledBoard = true){
			System.out.println("No one has won, it's a tie.");
		}
		
		userInput.close();

	}
	/**
	 * initBoard fills board spaces with blanks
	 * 
	 * @param there are no parameters
	 * 
	 * @return the empty board
	 */
	public static void initBoard()
	{
		// fills up the board with blanks
		for ( int r=0; r<3; r++ ){
			for ( int c=0; c<3; c++ ){
				board[r][c] = ' ';
			}
		}
	}


	/**
	 * displayBoard will display the tic-tac-toe board 
	 * 
	 * @param there are no parameters
	 * 
	 * @return the tic-tac-toe board
	 */
	public static void displayBoard()
	{
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("     0 1 2 ");
	}

	/**
	 * checkPlayer1Win checks the board to see if player one has three X's in a row 
	 * 
	 * @param there are no parameters
	 * 
	 * @return if player one wins
	 */
	public static boolean checkPlayer1Win(){
		
		boolean player1Win = false;
		
		if(board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X'){
			 player1Win = true;
		}
		else if(board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X'){
			 player1Win = true;
		}
		else if(board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X'){
			 player1Win = true;
		}
		else if(board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X'){
			 player1Win = true;
		}
		else if(board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X'){
			 player1Win = true;
		}
		else if(board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X'){
			 player1Win = true;
		}
		else if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'){
			 player1Win = true;
		}
		else if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'){
			 player1Win = true;
		}
		
		return player1Win;
		
	}
	/**
	 * checkPlayer2Win checks the board to see if player two has three O's in a row 
	 * 
	 * @param there are no parameters
	 * 
	 * @return if player two wins
	 */
	public static boolean checkPlayer2Win(){
		
		boolean player2Win = false;
		
		if(board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O'){
			 player2Win = true;
		}
		else if(board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O'){
			 player2Win = true;
		}
		else if(board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O'){
			 player2Win = true;
		}
		else if(board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O'){
			 player2Win = true;
		}
		else if(board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O'){
			 player2Win = true;
		}
		else if(board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O'){
			 player2Win = true;
		}
		else if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'){
			 player2Win = true;
		}
		else if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'){
			 player2Win = true;
		}
		
		return player2Win;
		
	}
	/**
	 * isFilled checks the board to see if the whole board is taken up
	 * 
	 * @param there are no parameters
	 * 
	 * @return if the board is taken up
	 */
	public static boolean isFilled(){
		boolean isFilled = false;
		
		//checks if the whole board is taken up
		if(board[0][0] != ' ' && board[0][1] != ' ' && board[0][2] != ' ' && board[1][0] != ' ' && board[1][1] != ' ' && board[1][2] != ' ' && board[2][0] != ' ' && board[2][1] != ' ' && board[2][2] != ' '){
			 isFilled = true;
		}
		
		return isFilled;
	}
	
	
	
}

