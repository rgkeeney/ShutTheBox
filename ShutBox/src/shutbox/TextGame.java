 package shutbox;
import java.util.*;
public class TextGame {
	public static void main(String[] args) {
		Board board= new Board();
		Dice die= new Dice();
		Turns turn = new Turns();
		while(Arrays.equals(board.win, board.val)==false) {
			if(board.val[6]==7|board.val[7]==8|board.val[8]==9) {
				turn.printTurnD2(board, die);
				System.out.println("\n");
			}else {
				turn.printTurnD1(board, die);
				System.out.println("\n");
			}
		}
		if(Arrays.equals(board.win, board.val)==true){
			System.out.println("you win!");
			return;
		}
	}
}
 