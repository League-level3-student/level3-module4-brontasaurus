package _00_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener{
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel text = new JLabel();
	char Char;
	Stack<Character> delCharacters = new Stack<Character>();
	//Stack<String> characters = new Stack<String>();
	
	public void setUp() {
		frame.add(panel);
		panel.add(text);
		frame.setPreferredSize(new Dimension(500,500));
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.pack();
	}
		
	public static void main(String[] args) {
		_02_TextUndoRedo name = new _02_TextUndoRedo();
		name.setUp();
		
		
	}	
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		Char = e.getKeyChar();
		//characters.push(Char);
		text.setText(text.getText() + Char);
		//text.setText(text.getText() + characters);
		
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			//characters.pop();
			//jlabel.setText(k.subString(0,kl));
			delCharacters.push(Char);
			//System.out.println(delCharacters);
			
			char[] strChars = text.getText().toCharArray();
			int i = strChars.length;
			strChars[i].delete();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			delCharacters.pop();
			//characters.push(Char);
			text.setText(text.getText() + Char);
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	} 
		
	}
	
	
	




