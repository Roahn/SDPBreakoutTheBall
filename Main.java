import java.awt.Color;

import javax.swing.JFrame;

import GamePlay.Gameplay;

public class Main {

	public static void main(String args[])
	{
		JFrame obj = new JFrame();
		Gameplay gameplay = new Gameplay();


		obj.setBounds(10,10,700,600);
		//obj.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		obj.setTitle("Break out Ball");
		obj.add(gameplay);
		obj.setResizable(false);
		obj.setBackground(Color.black);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		


	}

}
