package shutbox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

public class Main extends JFrame {
	public  Turns turns;
	public  Dice dice;
	public  Board board;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	int goalVal;
	int[] used;
	int added;
	int lastAL;
	String DisVal;
	JLabel diceNum;
	private JFrame frame;
	public class AL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(b1.equals(e.getSource())) {
				b1.setEnabled(false);
			}
			if(b2.equals(e.getSource())) {
				b2.setEnabled(false);
			}
			if(b3.equals(e.getSource())) {
				b3.setEnabled(false);
			}
			if(b4.equals(e.getSource())) {
				b4.setEnabled(false);
			}
			if(b5.equals(e.getSource())) {
				b5.setEnabled(false);
			}
			if(b6.equals(e.getSource())) {
				b6.setEnabled(false);
			}
			if(b7.equals(e.getSource())) {
				b7.setEnabled(false);
			}
			if(b8.equals(e.getSource())) {
				b8.setEnabled(false);
			}
			if(b9.equals(e.getSource())) {
				b9.setEnabled(false);
			}
			
			char c= s.charAt(0);
			lastAL= Character.getNumericValue(c);
			selectBox(goalVal);
			
		}
	}
	
	public void selectBox(int goalVal) {
		int total=added;
		int goal=goalVal;
		int[] pool= board.val;
		int[] used=  {0,0,0,0,0,0,0,0,0};
		if (goal>total ) {	
			int input=lastAL;
			if(total+input>goal) {
				System.out.println("value too large");
			}else if(pool[input-1]!=input) {
				System.out.println("can not use same value more than once");
			}else if(pool[input-1]==input&&total<goal) {
				total=total+input;
				pool[input-1]=0;
				used[input-1]=input;
				added=added+lastAL;
			}
		}
		if(goal==total) {
			added=0;
			for(int i=0; i<9; i++) {
				if(used[i]!=0) {
					board.val[i]=0;
				}
			}
			boxNextTurn(board, dice);
		}
	}
	
	
	public Main() {
		AL listen= new AL();
		turns= new Turns();
		dice= new Dice();
		board= new Board();
		used= new int[8];
		added=0;
		int d1= turns.boxsetup(board, dice)[0];
		int d2 =turns.boxsetup(board, dice)[1];
		goalVal= d1+d2;
		setTitle("Shut the Box");
		frame= this;
		frame.setLayout(new GridLayout(3,3));
		JPanel numpanel= new JPanel(new FlowLayout());
		 b1= new JButton("1");
		 b2= new JButton("2");
		 b3= new JButton("3");
		 b4= new JButton("4");
		 b5= new JButton("5");
		 b6= new JButton("6");
		 b7= new JButton("7");
		 b8= new JButton("8");
		 b9= new JButton("9");
		numpanel.add(b1);
		numpanel.add(b2);
		numpanel.add(b3);
		numpanel.add(b4);
		numpanel.add(b5);
		numpanel.add(b6);
		numpanel.add(b7);
		numpanel.add(b8);
		numpanel.add(b9);
		JPanel line2= new JPanel();
		JLabel inst= new JLabel("Please select number(s)");
		line2.add(inst);
		JPanel dicePanel= new JPanel(new FlowLayout());
		DisVal= (d1+" "+d2);
		System.out.println("dice:  "+DisVal);
		//JLabel diceNum= new JLabel(DisVal);
		JLabel dN= new JLabel("dice roll(s) are in the console ");
		
		b1.addActionListener(listen);
		b2.addActionListener(listen);
		b3.addActionListener(listen);
		b4.addActionListener(listen);
		b5.addActionListener(listen);
		b6.addActionListener(listen);
		b7.addActionListener(listen);
		b8.addActionListener(listen);
		b9.addActionListener(listen);
		dicePanel.add(dN);
		//dicePanel.add(diceNum);
		frame.add(numpanel);
		frame.add(inst);
		frame.add(dicePanel);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	public void boxNextTurn(Board board, Dice dice) {
		if(Arrays.equals(board.win, board.val)==false) {
			if(board.val[6]==7|board.val[7]==8|board.val[8]==9) {
				turns.boxsetup(board, dice);
				int d1= turns.boxsetup(board, dice)[0];
				int d2 =turns.boxsetup(board, dice)[1];
				goalVal= d1+d2;
				DisVal= (d1+" "+d2);
				System.out.println("dice: " +DisVal);
				
			}else {
				int d1=dice.roll();			
				goalVal=d1;
				DisVal=(d1)+" ";
				System.out.println("dice: " +DisVal);
			}
		}
		if(Arrays.equals(board.win, board.val)==true){
			System.out.println("you win!");
			return;
		}

	}
	
	
	
	public static void main(String[] args) {
		Main Box= new Main();
		Box.setVisible(true);
	}
}

