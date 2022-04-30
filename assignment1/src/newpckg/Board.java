package newpckg;

public class Board {
	private final int NUM_OF_COLUMNS = 7; 
	private final int NUM_OF_ROW = 6; 
	private char[][] board = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
	
	private char player;
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 */
	
	public void fakeMakeMove(int j, char symbol) {
		for (int i = 5; i >=0; i--) {
			if (board[i][j - 1] == ' ') {
				board[i][j - 1] = symbol;
				break;
			}
		}
	}
	public static void main (String [] args) {
		Board b1 = new Board();
		b1.printBoard();
	}
		
	public Board() {
		
		reset();
		
	}
	
	//implementation for the print board class, prints the board
	
	public void printBoard() {
		
		//System.out.println("---------------");
		
		for (int row = NUM_OF_ROW - 1; row >= 0 ; row--){
			
			System.out.print("|");
			
			for (int col = 0; col < NUM_OF_COLUMNS; col++){
				
				System.out.print(board[row][col]);
				
				System.out.print("|");
			}
			System.out.println();
			
			//System.out.println("---------------");
		}
		
		System.out.println();
	}
	
	public boolean containsWin() {
		//check for 4 across
		for(int row = 0; row < NUM_OF_ROW; row++)
		{
			for (int col = 0;col < NUM_OF_COLUMNS - 3;col++)
			{
				if (board[row][col] == board[row][col+3]   && 
					board[row][col+1] == board[row][col+3] &&
					board[row][col+2] == board[row][col+3] &&
					board[row][col+3] != ' ')
				{
					return true;
				}
			}			
		}
		//check for 4 up and down
		for(int row = 0; row < NUM_OF_ROW - 3; row++){
			for(int col = 0; col < NUM_OF_COLUMNS; col++){
				if (board[row][col] == board[row][col+3]  && 
					board[row+1][col] == board[row][col+3] &&
					board[row+2][col] == board[row][col+3] &&
					board[row+3][col] != ' ')
				{
					return true;
				}
			}
		}
		//check upward diagonal
		for(int row = 3; row < NUM_OF_ROW; row++){
			for(int col = 0; col < NUM_OF_COLUMNS - 3; col++){
				if (board[row][col] == board[row][col+3]   && 
					board[row-1][col+1] == board[row][col+3] &&
					board[row-2][col+2] == board[row][col+3] &&
					board[row-3][col+3] != ' '){
					return true;
				}
			}
		}
		//check downward diagonal
		for(int row = 0; row < NUM_OF_ROW - 3; row++){
			for(int col = 0; col < NUM_OF_COLUMNS - 3; col++){
				if (board[row][col] == board[row][col+3]   && 
					board[row+1][col+1] == board[row][col+3] &&
					board[row+2][col+2] == board[row][col+3] &&
					board[row+3][col+3] != ' '){
					return true;
				}
			}
		}
		return false;
		
	}
	
	public boolean isTie() {
		
        for (int row = 0; row < NUM_OF_ROW; row++) {
        	
            for (int col = 0; col < NUM_OF_COLUMNS; col++) {
            	
                if (board[row][col] == 0) {
                	
                    return false;
                    
                }
            }
        }
        
        return true;	

	}
	
	public void reset() {
        for (int row = 0; row < NUM_OF_ROW; row++) {
            for (int col = 0; col < NUM_OF_COLUMNS; col++) {
                board[row][col] = 0;
            }
        }
	}

}
