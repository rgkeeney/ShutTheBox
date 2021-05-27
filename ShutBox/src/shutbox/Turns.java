package shutbox;

public class Turns {
	public void printTurnD2(Board board, Dice die) {
	System.out.println("board: ");
	board.showAvail();
	int d1=die.roll();
	int d2=die.roll();
	int dV=d1+d2;
	System.out.println("\n rolled numbers: "+d1+" "+d2);
	board.selectText(dV);
	}
	
	public void printTurnD1(Board board, Dice die) {
		System.out.println("board: ");
		board.showAvail();
		int d1=die.roll();
		int dV=d1;
		System.out.println("\n rolled number: "+d1);
		board.selectText(dV);
	}
	
	public int[] boxsetup(Board board, Dice die) {
		if(board.val[6]==7|board.val[7]==8|board.val[8]==9) {
			int d1=die.roll();
			int d2=die.roll();
			int[] out= {d1,d2};
			return out;
		}else {
			int d1=die.roll();			
			int[] out= {d1, 0};
			return out;
		}

	}
	
	
	
	}
