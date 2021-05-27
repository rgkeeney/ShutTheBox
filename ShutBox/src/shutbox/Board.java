package shutbox;
import java.util.*;
import java.awt.*;
public class Board {
		public int[] val;
		public Board() {
			val= new int[] {1,2,3,4,5,6,7,8,9};	
		}
		int[] win= {0,0,0,0,0,0,0,0,0};
		public void showAvail() {
			for(int i=0; i<9; i++) {
				if(val[i]==0) {
					System.out.println("- ");
				}else
				System.out.print(val[i]+" ");
			}
		}
		
		public void selectText(int dV) {
			int total=0;
			int goal=dV;
			int[] pool= val;
			int[] used=  {0,0,0,0,0,0,0,0,0};
			System.out.print("Please select number(s) from the board\n");
			@SuppressWarnings("resource")
			Scanner num=new Scanner(System.in);
			while (goal>total ) {
				int input=num.nextInt();
				if(total+input>goal) {
					System.out.println("value too large");
				}else if(pool[input-1]!=input) {
					System.out.println("can not use same value more than once");
				}else if(pool[input-1]==input&&total<goal) {
					total=total+input;
					pool[input-1]=0;
					used[input-1]=input;
				}
			}
			if(goal==total) {
				for(int i=0; i<9; i++) {
					if(used[i]!=0) {
						val[i]=0;
					}
				}
			}
		}
		
		/**public void selectBox(int goalVal) {
			int total=0;
			int input=lastAL;
			int goal=goalVal;
			int[] pool= val;
			int[] used=  {0,0,0,0,0,0,0,0,0};
			while (goal>total ) {		
				if(total+input>goal) {
					System.out.println("value too large");
				}else if(pool[input-1]!=input) {
					System.out.println("can not use same value more than once");
				}else if(pool[input-1]==input&&total<goal) {
					total=total+input;
					pool[input-1]=0;
					used[input-1]=input;
				}
			}
			if(goal==total) {
				for(int i=0; i<9; i++) {
					if(used[i]!=0) {
						val[i]=0;
					}
				}
			}
		}**/
		
		
		
}
