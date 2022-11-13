package _03_Hangman;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	Stack<String> wordList = new Stack<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel wordLabel = new JLabel();
	JLabel lifeLabel = new JLabel();
	JLabel wrongLabel = new JLabel();
	
	
 public static void main(String[] args) {
	
	 
}	
 
 public void start() {
	 System.out.println("starting");
	 int life = 6;
	 boolean playing = true;
	 
	 while (playing) {
	 
		 
	 String inputNum = JOptionPane.showInputDialog("Enter a number between 1 and " + Utilities.getTotalWordsInFile("dictionary.txt"));
	 int numOfWords = Integer.parseInt(inputNum);
	 
	
	 
	 while (wordList.size() < numOfWords) {
		String pushed = wordList.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		if (!wordList.contains(pushed)) {	
			wordList.push(pushed);
		}
	 }
	 while (life > 0 && wordList.size() > 0) {
	 String word = wordList.pop();
	// System.out.println(word);
	 int wordLength = word.length();
	 ArrayList<Character> wrongArray = new ArrayList<Character>();
	 ArrayList<Character> guessArray = new ArrayList<Character>();
	 //String underscores = word.replace(' ', '_');
	 for (int i = 0; i < wordLength; i++) {
		 guessArray.add('_');
	 }
	 
	 frame.add(panel);
	 panel.add(wordLabel);
	 panel.add(lifeLabel);
	 panel.add(wrongLabel);
	 wrongLabel.setText("Guessed Wrong: " + wrongArray.toString());
	 lifeLabel.setText("lives: " + String.valueOf(life));
	 wordLabel.setText(guessArray.toString());
	 frame.setVisible(true);
	 frame.pack();
	 
	 while (life > 0 && guessArray.contains('_')) {
	 String guess = JOptionPane.showInputDialog("Enter a letter");
	 
	 if (word.contains(guess) == true){
		 int index = word.indexOf(guess);
		 for (int i = index; i < word.length(); i++) {
			 if (word.charAt(i) == guess.charAt(0)) {
		 guessArray.set(i, guess.charAt(0));
			 }
		 }
		 wordLabel.setText(guessArray.toString());
		 frame.pack();
		 if (!guessArray.contains('_')) {
			JOptionPane.showMessageDialog(null, "Congrats! the word was " + word);
			life = 6;
		 }
	 }
	 else if (word.contains(guess) == false){
		 life--;
		 lifeLabel.setText("lives: " + String.valueOf(life));
		
		 wrongArray.add(guess.charAt(0));
		 wrongLabel.setText("Guessed Wrong: " + wrongArray.toString());
		 frame.pack();
	 }
	 
	 if (lives == 0) {
		 JOptionPane.showMessageDialog(null, "Oh no! the word was " + word);
	 }
	 }
	 Object[] options1 = {"yes", "no"}; 
	 
	 if (wordList.size() == 0) {
		int result = JOptionPane.showOptionDialog(null, panel, "do you want to play again?",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
		if (result == 0) {
			playing = true;
		}
		else {
			playing = false;
		}
	 }
 }
 }
	 //show letters that are wrong (reset the text & pack)
	 //change life counter to "lives: " + life
	 
 }
}
