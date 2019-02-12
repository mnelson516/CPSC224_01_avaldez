// Max Nelson & Armando Valdez
// 2/11/2019
// Assignment 2
package assignment.pkg2;

import javax.swing.JOptionPane;
import java.lang.StringBuilder;
import java.lang.Math;


public class Assignment2 {
    public static void main(String[] args) {
         int num;
         int wordLength;
         String wordToGuess = null;
         
        while (true){
           num = menu();
            switch (num) {
                case 1:
                	wordToGuess = generateRandomWord();
                	wordLength = wordToGuess.length();
                	playGame(wordToGuess,wordLength);
                    break;
                    
                case 2:
                	wordToGuess = JOptionPane.showInputDialog("Enter a word for the other player to guess");
                	wordLength = wordToGuess.length();
                	playGame(wordToGuess,wordLength);
                    System.exit(0);
                    break;
                    
                case 3:
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice!!!!");
                    break;
            }   
        }
    }
    
    public static int menu()
  {
      String userChoice;
      int num;
      
      userChoice = JOptionPane.showInputDialog("1. Play game from a randomly chosen word in a list \n 2. Play game from a word entered by another user \n 3.Exit Game \n Enter what you would like to do"); 
      num = Integer.parseInt(userChoice);
      
      return num;
  }

    
   
	public static String getDashes(int wordLength)
	{
		String endWord;
		StringBuilder word = new StringBuilder("");
		for (int i=0; i < wordLength; i++)
		{
			word.append("_");
		}
		endWord = word.toString();
		return endWord;
	}

	public static String generateRandomWord()
	{
		String word = null;
		double random = Math.random() * 5 + 1;
		int num = (int)random;
		switch(num)
		{
			case 1:
				word = "science";
				break;
			
			case 2:
				word = "computer";
				break;
			
			case 3:
				word = "algorithm";
				break;
				
			case 4:
				word = "java";
				break;
				
			case 5:
				word = "programming";
				break;				
		}
		return word;
	}
	
	
	public static void playGame(String wordToGuess, int wordLength)
	{
		int strikes = 0;
		
		char letterGuessed;
		String tempString = null;
		String displayString = getDashes(wordLength);
		StringBuilder displayedString = new StringBuilder(displayString);
		
		while (strikes < 6)
		{
			
			tempString = JOptionPane.showInputDialog("The word is " + wordLength + " letters long. Guess a letter: ");
			letterGuessed = tempString.charAt(0);
			
			if (!(Character.isLetter(letterGuessed)))
			{
				JOptionPane.showMessageDialog(null,"Invalid option, please enter a letter.");
			}
			
			else if (!(wordToGuess.contains(tempString)))
			{
				strikes++;
				JOptionPane.showMessageDialog(null,"You have " + strikes + " strikes");
			}
			
			else
			{
				for (int i = 0; i < wordLength; i++)
				{
					if (wordToGuess.charAt(i) == letterGuessed)
					{
						displayedString.setCharAt(i,letterGuessed);
					}
				}
			}
			if (strikes == 0)
			{
				JOptionPane.showMessageDialog(null,"No strikes!");
			}
			
			if (strikes == 1)
			{
				JOptionPane.showMessageDialog(null," \n"
		                + " ------\n"
		                + "|      |\n"
		                + "|      O\n"
		                + "|\n"
		                + "|\n"
		                + "|\n"
		                + "|\n"
		                + "|\n"
		                + "|\n"
		                + "|");
			}
			
			if (strikes == 2)
			{
				JOptionPane.showMessageDialog(null, "\n"
		                + " ------\n"
		                + "|      |\n"
		                + "|      O\n"
		                + "|      |\n"
		                + "|      |\n"
		                + "|      |\n"
		                + "|\n"
		                + "|\n"
		                + "|\n"
		                + "|");
			}
			
			if (strikes == 3)
			{
				JOptionPane.showMessageDialog(null, "\n"
		                + " ------\n"
		                + "|      |\n"
		                + "|   \\  O  \n"
		                + "|    \\ | \n"
		                + "|     \\|\n"
		                + "|      |\n"
		                + "|      |\n" );
			}
			
			if (strikes == 4)
			{
				JOptionPane.showMessageDialog(null," \n"
		                + " ------\n"
		                + "|      |\n"
		                + "|   \\  O  /\n"
		                + "|    \\ | /\n"
		                + "|     \\|/\n"
		                + "|      |\n"
		                + "|      |\n");
			}
			
			if (strikes == 5)
			{
				JOptionPane.showMessageDialog(null," \n"
		                + " ------\n"
		                + "|      |\n"
		                + "|   \\  O  /\n"
		                + "|    \\ | /\n"
		                + "|     \\|/\n"
		                + "|      |\n"
		                + "|      |\n"
		                + "|     / \n"
		                + "|    /     \n " );
			}
			
			if (strikes == 6)
			{
				JOptionPane.showMessageDialog(null," \n"
		                + " ------\n"
		                + "|      |\n"
		                + "|   \\  O  /\n"
		                + "|    \\ | /\n"
		                + "|     \\|/\n"
		                + "|      |\n"
		                + "|      |\n"
		                + "|     / \\ \n"
		                + "|    /   \\ \n"
		                + "|    You lose!!!! "
		                + "		The word to guess was: " + wordToGuess);
				
			}
			
		JOptionPane.showMessageDialog(null, displayedString);
		}
	} 
   
}