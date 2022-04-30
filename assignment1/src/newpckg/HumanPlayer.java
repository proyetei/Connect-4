package newpckg;
import java.util.Scanner;
public class HumanPlayer extends Player {
	
	public HumanPlayer(char symbol, Board board, String name) {
		super(symbol, board, name);
		
	}

	@Override
	public void makeMove(Board board) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println(name + ", please input your move: ");
		//int turn = input.nextInt();
			
		board.fakeMakeMove(input.nextInt(), symbol);
		
		
	}
	
	
	 
}
