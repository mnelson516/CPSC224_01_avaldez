/*

 */
package tictactoemain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;

public class TicTacToeMain extends JFrame {
    private JPanel northPanel;
    private JPanel player1Panel;
    private JPanel player2Panel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JPanel southOptionPanel;
    private JPanel southStatusPanel;
    private JLabel statusLabel;
    private JTextField player1;
    private JTextField player2;
    private JButton newGame;
    private JButton reset;
    private JButton exit;
    
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_LENGTH = 500;
    private static JButton playButtons[] = new JButton[9];
    private int player1Wins = 0;
    private int player2Wins = 0;
    private JLabel winCount1 = new JLabel("0", SwingConstants.LEFT);
    private JLabel winCount2 = new JLabel("0", SwingConstants.LEFT);
    private JLabel lossCount1 = new JLabel("0", SwingConstants.LEFT);
    private JLabel lossCount2 = new JLabel("0", SwingConstants.LEFT);
    
    
    String symbol = "X";
    int winner = 0;
    boolean validStart = false;
    
    public TicTacToeMain()
    {
        setTitle("Tic Tac Toe");
        
        setSize(WINDOW_WIDTH, WINDOW_LENGTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        player1 = new JTextField(8);
        player2 = new JTextField(8);
        
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1,2));
        playerPanel(player1Panel, 1);
        playerPanel(player2Panel, 2);
        
        centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        centerPanel.setLayout(new GridLayout(3,3));
        createButtons("");
        
        southPanel = new JPanel();
        southOptionPanel = new JPanel();
        southStatusPanel = new JPanel();
        
        newGame = new JButton("New Game");
        reset = new JButton("Reset");
        exit = new JButton("Exit");
        newGame.addActionListener(new ButtonListener());
        reset.addActionListener(new ButtonListener());
        exit.addActionListener(new ButtonListener());
        
        statusLabel = new JLabel("Welcome to TIC TAC TOE!!");
        statusLabel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        southOptionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 7));
        southOptionPanel.add(newGame);
        southOptionPanel.add(reset);
        southOptionPanel.add(exit);
        southStatusPanel.add(statusLabel);
        southPanel.setLayout(new GridLayout(2,1));
        southPanel.add(southOptionPanel);
        southPanel.add(southStatusPanel);
        
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    private void createButtons(String label)
    {
        for(int i = 0; i < 9; i++)
        {
            playButtons[i] = new JButton(label);
            playButtons[i].addActionListener(new ButtonListener());
            playButtons[i].setEnabled(false);
            centerPanel.add(playButtons[i]);
        }
    }
    
    private void playerPanel(JPanel panel, int playerNum)
    {
        winCount1.setText(Integer.toString(player1Wins));
        winCount2.setText(Integer.toString(player2Wins));
        lossCount1.setText(Integer.toString(player2Wins));
        lossCount2.setText(Integer.toString(player1Wins));
        panel = new JPanel();
        
        if(playerNum == 1)
        {
            panel.setBorder(BorderFactory.createTitledBorder("player 1"));
            panel.setLayout(new GridLayout(3,2));
            panel.add(new JLabel("Name: ", SwingConstants.RIGHT));
            panel.add(player1);
            panel.add(new JLabel("Wins: ", SwingConstants.RIGHT));
            panel.add(winCount1);
            panel.add(new JLabel("Losses: ", SwingConstants.RIGHT));
            panel.add(lossCount1);
        }
        else
        {
            panel.setBorder(BorderFactory.createTitledBorder("player 2"));
            panel.setLayout(new GridLayout(3,2));
            panel.add(new JLabel("Name: ", SwingConstants.RIGHT));
            panel.add(player2);
            panel.add(new JLabel("Wins: ", SwingConstants.RIGHT));
            panel.add(winCount2);
            panel.add(new JLabel("Losses: ", SwingConstants.RIGHT));
            panel.add(lossCount2);
        }
        northPanel.add(panel);
    }
        
        private class ButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                String optionChosen = e.getActionCommand();
                Object chosenButton = e.getSource();
                
                if (optionChosen.equals("New Game"))
                {
                    if(!(player1.getText().isEmpty() || player2.getText().isEmpty()))
                    {
                        player1.setEditable(false);
                        player2.setEditable(false);
                        statusLabel.setText(player1.getText() + "'s turn");
                        
                        for(int i = 0; i < 9; i++)
                        {
                           playButtons[i].setText("");
                           playButtons[i].setEnabled(true);
                        }
                        symbol = "X";
                        validStart = true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You must enter a name for both players in order to play", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if(optionChosen.equals("Reset"))
                {
                    int result = JOptionPane.showConfirmDialog(null, "This will end the game and reset all stats to 0. Are you sure?", "Reset", JOptionPane.YES_NO_OPTION);
                    
                    if(result == 0)
                    {
                        player1Wins = 0;
                        player2Wins = 0;
                        winCount1.setText(Integer.toString(player1Wins));
                        lossCount1.setText(Integer.toString(player2Wins));
                        winCount2.setText(Integer.toString(player2Wins));
                        lossCount2.setText(Integer.toString(player1Wins));
                        player1.setText("");
                        player2.setText("");
                        validStart = false;
                        player1.setEditable(true);
                        player2.setEditable(true);
                        
                        for(int i = 0; i < 9; i++)
                        {
                            playButtons[i].setText("");
                            playButtons[i].setEnabled(false);
                        }
                    }
                            
                }        
                else if(optionChosen.equals("Exit"))
                {
                    System.exit(0);
                }
                else
                {
                    if(validStart)
                    {
                        JButton buttonPressed = (JButton) chosenButton;
                        buttonPressed.setText(symbol);
                        buttonPressed.setEnabled(false);
                        winner = checkBoard();
                        
                        if (winner == 1)
                        {
                            statusLabel.setText(player1.getText() + " Wins!!");
                            for (int i = 0; i < 9; i++)
                                playButtons[i].setEnabled(false);
                            winCount1.setText(Integer.toString(player1Wins));
                            lossCount2.setText(Integer.toString(player1Wins));
                        }
                        else if(winner == 2)
                        {
                            for(int i = 0; i < 9; i++)
                                playButtons[i].setEnabled(false);
                            statusLabel.setText(player2.getText() + " Wins!!");
                            winCount2.setText(Integer.toString(player2Wins));
                            lossCount1.setText(Integer.toString(player2Wins));
                        }
                        else if(winner == 3)
                        {
                            statusLabel.setText("Tie!");
                            for(int i = 0; i < 9; i++)
                                playButtons[i].setEnabled(false);
                        }        
                        else
                        {
                        if(symbol.equals("X"))
                        {
                            symbol = "O";
                            statusLabel.setText(player2.getText() + "'s turn");
                        }
                        else
                        {
                            symbol = "X";
                            statusLabel.setText(player1.getText() + "'s turn");
                        }
                    }           
                    }    
                }
            }
        }
        
        private int checkBoard()
        {
             int count = 0;
            
            for (int i = 0; i < 9; i++)
            {
                if(playButtons[i].getText() == "")
                {
                    count ++;
                }
            }
            if (count == 0)
            {
                if ((playButtons[0].getText() =="X" && playButtons[1].getText() == "X" && playButtons[2].getText() == "X") || (playButtons[3].getText() =="X" && playButtons[4].getText() == "X" && playButtons[5].getText() == "X") ||
		(playButtons[6].getText() =="X" && playButtons[7].getText() == "X" && playButtons[8].getText() == "X") || (playButtons[0].getText() =="X" && playButtons[3].getText() == "X" && playButtons[6].getText() == "X") ||
		(playButtons[1].getText() =="X" && playButtons[4].getText() == "X" && playButtons[7].getText() == "X") || (playButtons[2].getText() =="X" && playButtons[5].getText() == "X" && playButtons[8].getText() == "X") ||
		(playButtons[2].getText() =="X" && playButtons[4].getText() == "X" && playButtons[6].getText() == "X") || (playButtons[0].getText() =="X" && playButtons[4].getText() == "X" && playButtons[8].getText() == "X"))
                {
		 	player1Wins++;

			return 1;
                }
                else if ((playButtons[0].getText() =="O" && playButtons[1].getText() == "O" && playButtons[2].getText() == "O") || (playButtons[3].getText() =="O" && playButtons[4].getText() == "O" && playButtons[5].getText() == "O") ||
		(playButtons[6].getText() =="O" && playButtons[7].getText() == "O" && playButtons[8].getText() == "O") || (playButtons[0].getText() =="O" && playButtons[3].getText() == "O" && playButtons[6].getText() == "O") ||
		(playButtons[1].getText() =="O" && playButtons[4].getText() == "O" && playButtons[7].getText() == "O") || (playButtons[2].getText() =="O" && playButtons[5].getText() == "O" && playButtons[8].getText() == "O") ||
		(playButtons[2].getText() =="O" && playButtons[4].getText() == "O" && playButtons[6].getText() == "O") || (playButtons[0].getText() =="O" && playButtons[4].getText() == "O" && playButtons[8].getText() == "O"))
                {
                    player2Wins++;

                    return 2;
                }
                else
                    return 3;
            }
            else 
            {
               if ((playButtons[0].getText() =="X" && playButtons[1].getText() == "X" && playButtons[2].getText() == "X") || (playButtons[3].getText() =="X" && playButtons[4].getText() == "X" && playButtons[5].getText() == "X") ||
		(playButtons[6].getText() =="X" && playButtons[7].getText() == "X" && playButtons[8].getText() == "X") || (playButtons[0].getText() =="X" && playButtons[3].getText() == "X" && playButtons[6].getText() == "X") ||
		(playButtons[1].getText() =="X" && playButtons[4].getText() == "X" && playButtons[7].getText() == "X") || (playButtons[2].getText() =="X" && playButtons[5].getText() == "X" && playButtons[8].getText() == "X") ||
		(playButtons[2].getText() =="X" && playButtons[4].getText() == "X" && playButtons[6].getText() == "X") || (playButtons[0].getText() =="X" && playButtons[4].getText() == "X" && playButtons[8].getText() == "X"))
                {
		 	player1Wins++;

			return 1;
                }
                else if ((playButtons[0].getText() =="O" && playButtons[1].getText() == "O" && playButtons[2].getText() == "O") || (playButtons[3].getText() =="O" && playButtons[4].getText() == "O" && playButtons[5].getText() == "O") ||
		(playButtons[6].getText() =="O" && playButtons[7].getText() == "O" && playButtons[8].getText() == "O") || (playButtons[0].getText() =="O" && playButtons[3].getText() == "O" && playButtons[6].getText() == "O") ||
		(playButtons[1].getText() =="O" && playButtons[4].getText() == "O" && playButtons[7].getText() == "O") || (playButtons[2].getText() =="O" && playButtons[5].getText() == "O" && playButtons[8].getText() == "O") ||
		(playButtons[2].getText() =="O" && playButtons[4].getText() == "O" && playButtons[6].getText() == "O") || (playButtons[0].getText() =="O" && playButtons[4].getText() == "O" && playButtons[8].getText() == "O"))
                {
		 	player2Wins++;

			return 2;
                }
            }
            return 0;
        }

    public static void main(String[] args) {
       new TicTacToeMain();
    } 
}