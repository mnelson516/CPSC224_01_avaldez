/*
Author: Armando Valdez
Date: 2/22/19
ICA4
 */
package dice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Dice extends JFrame{
    private JPanel imagePanel;
    private JPanel imagePanel2;
    private JPanel buttonPanel;
    private JLabel imageLabel;
    private JLabel imageLabel2;
    private JButton button;
    private final int WINDOW_WIDTH = 200; 
    private final int WINDOW_HEIGHT = 150; 

    public Dice()
    {
        setTitle("Dice Simulator");
        
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        buildImagePanel();
        buildImagePanel2();
        buildbuttonPanel();
        
        add(imagePanel, BorderLayout.WEST);
        add(imagePanel2, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    private void buildImagePanel()
    {
        imagePanel = new JPanel();
        
        imageLabel = new JLabel("Dice #1");
        
        imagePanel.add(imageLabel);
    }
    
    private void buildImagePanel2()
    {
        imagePanel2 = new JPanel();
        
        imageLabel2 = new JLabel("Dice #2");
        
        imagePanel2.add(imageLabel2);
    }
    
    
    private void buildbuttonPanel()
    {
        buttonPanel = new JPanel();
        button = new JButton("Roll the Dice");
        button.addActionListener(new ButtonListener());
        buttonPanel.add(button);
    }
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Random rand = new Random();
            int i = 1 + rand.nextInt(6);
            int j = 1 + rand.nextInt(6);
            switch(i)
            {
                case 1: imageLabel.setIcon(new ImageIcon("die1.png"));
                        imageLabel.setText(null);
                        break;
                case 2: imageLabel.setIcon(new ImageIcon("die2.png"));
                        imageLabel.setText(null);
                        break;
                case 3: imageLabel.setIcon(new ImageIcon("die3.png"));
                        imageLabel.setText(null); 
                        break;
                case 4: imageLabel.setIcon(new ImageIcon("die4.png"));
                        imageLabel.setText(null);
                        break;
                case 5: imageLabel.setIcon(new ImageIcon("die5.png"));
                        imageLabel.setText(null);
                        break;
                case 6: imageLabel.setIcon(new ImageIcon("die6.png"));
                        imageLabel.setText(null);
                        break;        
            }
            
            switch(j)
            {
                case 1: imageLabel2.setIcon(new ImageIcon("die1.png"));
                        imageLabel2.setText(null);
                        break;
                case 2: imageLabel2.setIcon(new ImageIcon("die2.png"));
                        imageLabel2.setText(null);
                        break;
                case 3: imageLabel2.setIcon(new ImageIcon("die3.png"));
                        imageLabel2.setText(null); 
                        break;
                case 4: imageLabel2.setIcon(new ImageIcon("die4.png"));
                        imageLabel2.setText(null);
                        break;
                case 5: imageLabel2.setIcon(new ImageIcon("die5.png"));
                        imageLabel2.setText(null);
                        break;
                case 6: imageLabel2.setIcon(new ImageIcon("die6.png"));
                        imageLabel2.setText(null);
                        break;        
            }
            pack();
        }
    }

    public static void main(String[] args) {
         new Dice();
    }
}