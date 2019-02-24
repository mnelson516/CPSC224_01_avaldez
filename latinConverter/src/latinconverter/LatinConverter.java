//Author: Armando Valdez
//Date: 2/15/19
//ICA 3

package latinconverter;

import java.awt.BorderLayout;
import javax.swing.*;    // Needed for Swing classes 
import java.awt.event.*; // Needed for event listener interface



public class LatinConverter extends JFrame
{
   private JLabel messageLabel;    // To display a message
   private JButton Button1;      
   private JButton Button2;     
   private JButton Button3;   
   private JPanel panel;           // A panel to hold components
   private final int WINDOW_WIDTH = 450; // Window width
   private final int WINDOW_HEIGHT = 150; // Window height

   
   public LatinConverter()
   {
      
      setTitle("Latin Converter");
      
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
      messageLabel = new JLabel(" Choose a word to translate ");

      Button1 = new JButton("SINISTER");
      Button2 = new JButton("DEXTER");
      Button3 = new JButton("MEDIUM");
      

      Button1.addActionListener(new Button1Listener());
      Button2.addActionListener(new Button2Listener());
      Button3.addActionListener(new Button3Listener());

      panel = new JPanel();
      panel.add(messageLabel);
      panel.add(Button1);
      panel.add(Button2);
      panel.add(Button3);
      
      add(panel);
      add(BorderLayout.NORTH, messageLabel);
      add(BorderLayout.WEST, Button1);
      add(BorderLayout.CENTER, Button3);
      add(BorderLayout.EAST, Button2);

      setVisible(true);
   }


   private class Button1Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         messageLabel.setText(" Left "); 
      }
   }

   private class Button2Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
           messageLabel.setText(" Right "); 
      }
   }

   private class Button3Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
            messageLabel.setText(" Center "); 
      }
   }
   
   public static void main(String[] args)
   {
      new LatinConverter();
   }
}