package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
Stack<Double> nums = new Stack<Double>(); 
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
Random ran = new Random();
for (int i = 0; i < 100; i++) {
	nums.push(ran.nextDouble(100));
}
//System.out.println(nums);

        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
String numOne = JOptionPane.showInputDialog("Enter one number between 0 and 100");
Double DubOne = Double.parseDouble(numOne);
String numTwo = JOptionPane.showInputDialog("Enter another number between 0 and 100");
Double DubTwo = Double.parseDouble(numTwo);
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
while( ! nums.isEmpty() ) {
    Double popped = nums.pop();
	if (DubOne < popped) {
		if (popped < DubTwo) {
		System.out.println(popped);
		}
	}
	
}


        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}
