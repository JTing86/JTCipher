
package jtcipher;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;             // for the rectangle
import java.awt.event.*;

public class cMenu extends JFrame implements ActionListener{
    
    JButton start;
    JTcipher mainPG;
    
    Action ac = new Action();
    
    
    public cMenu( JTcipher Jc){
    mainPG = Jc;
    setSize(610, 650);
    setLayout(new FlowLayout());


    
    JButton button = new JButton("hello agin1");
    add(button);
    button.addActionListener (new Action()); 
    //setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setVisible (true);
    }   
    
    public void actionPerformed(ActionEvent evt){
    	setVisible (false);
    	mainPG.setVisible(true);
    }
}

class Action implements ActionListener {        
    public void actionPerformed (ActionEvent e) {     
        JFrame frame2 = new JFrame("Clicked");
        frame2.setVisible(true);
        frame2.setSize(610, 650);
        JLabel label = new JLabel("you clicked me");
        JPanel panel = new JPanel();
        frame2.add(panel);
        panel.add(label);       
    }
}

