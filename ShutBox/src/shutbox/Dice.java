package shutbox;
import java.util.*;

public class Dice {
	public int roll() {
		Random r = new Random();
		int rD=r.nextInt(6)+1;
		return rD;
	}
}
