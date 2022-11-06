package _03_Hangman;

import java.util.ArrayList;
import java.util.Stack;

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
	 System.out.println(word);
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
	 wrongLabel.setText(wrongArray.toString());
	 lifeLabel.setText(String.valueOf(life));
	 wordLabel.setText(guessArray.toString());
	 frame.setVisible(true);
	 frame.pack();
	 
	 while (life > 0 && guessArray.contains('_')) {
	 String guess = JOptionPane.showInputDialog("Enter a letter");
	 
	 if (word.contains(guess) == true){
		 int index = word.indexOf(guess);
		 guessArray.set(index, guess.charAt(0));
		 wordLabel.setText(guessArray.toString());
		 frame.pack();
		 if (!guessArray.contains('_')) {
			life = 6;
		 }
	 }
	 else {
		 life--;
		 wrongArray.add(guess.charAt(0));
	 }
	 }
	 
 }
 }
	 //Make a JLabel+ buttons for yes and no. If yes reset if no shut off. JLabel asking if they want to play again
	 //does not add wrong letters to new array or take away lives.
	 //Does not enter double letters
 }
}
