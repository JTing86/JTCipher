/*
 * This class contains all the collections of cipher
 */
package jtcipher;

import java.awt.*;
import static java.awt.Color.YELLOW;
import javax.swing.*;

public class BookC extends JFrame{
 //being used in the main probram (a page in main frame, therefore public)

    private JPanel ccsPanel;
    private JPanel dmPanel;
    private JPanel musPanel;
    private JPanel mrsPanel;
    private JPanel gekPanel;
    
    public JTabbedPane tabPane;
    
    public BookC(){
        
        setTitle( "Cipher Book" );
    
        setBackground( Color.gray );
       
        createccsP();
        createdmP();
        createmusP();
        createmrsP();
        creategekP();

        // Create a tabbed pane
        tabPane = new JTabbedPane();
        //tabPane.setLayout(null);
        tabPane.setSize(1000,700);
        tabPane.setLocation(10,10);
        tabPane.addTab( "Ceasar", ccsPanel );
        tabPane.addTab( "DancingMen", dmPanel );
        tabPane.addTab( "Morse", mrsPanel );
        tabPane.addTab( "GreekChar", gekPanel );
        tabPane.addTab( "Music", musPanel );
        add(tabPane);        
        
    }
    
    public void createdmP(){
        dmPanel = new JPanel();
        dmPanel.setLayout( null );
        dmPanel.setSize(1180,700);
        dmPanel.setLocation(0,0);
        
        JTextArea textA = new javax.swing.JTextArea();
        textA.setSize(1000, 600);
        textA.setLocation(10, 10);
        textA.setText("Mr. Hilton Cubitt of Ridling Thorpe Manor in Norfolk visits Sherlock Holmes and gives \n"
                + "him a piece of paper with this mysterious sequence of stick figures.");
        
        dmPanel.add(textA);
        
    }
    
    public void createmusP(){
        musPanel = new JPanel();
        musPanel.setLayout( null );
        musPanel.setSize(1180,700);
        musPanel.setLocation(0,0);

        JTextArea textA = new javax.swing.JTextArea();
        textA.setSize(1000, 600);
        textA.setLocation(10, 10);
        textA.setText(  "C D E F G A B C6\n" +
                        "\n" +
                        "tone:\n" +
                        "1-10\n" +
                        "default start at C5\n" +
                        "\n" +
                        "rate:\n" +
                        "\n" +
                        "default q, space as h\n" +
                        "w - whole duration\n" +
                        "h - half duration\n" +
                        "q - quarter duration\n" +
                        "i - eighth duration\n" +
                        "s - sixteenth duration\n" +
                        "t - thirty-second duration\n" +
                        "x - sixty-fourth duration\n" +
                        "n - 1/128th duration");

        musPanel.add(textA);

    }
    
    public void createmrsP(){
        mrsPanel = new JPanel();
        mrsPanel.setLayout( null );
        mrsPanel.setSize(1180,700);
        mrsPanel.setLocation(0,0);

        JTextArea textA = new javax.swing.JTextArea();
        textA.setSize(1000, 600);
        textA.setLocation(10, 10);
        textA.setText("Morse code is a method of transmitting text information as a series of on-off tones,\n"
                + " lights, or clicks that can be directly understood by a skilled listener or observer without\n"
                + " special equipment. The International Morse Code[1] encodes the ISO basic Latin alphabet, \n"
                + "some extra Latin letters, the Arabic numerals and a small set of punctuation and procedural \n"
                + "signals (prosigns) as standardized sequences of short and long signals called \"dots\" and \n"
                + "\"dashes\",[1] or \"dits\" and \"dahs\", as in amateur radio practice. Because many non-English \n"
                + "natural languages use more than the 26 Roman letters, extensions to the Morse alphabet exist \n"
                + "for those languages.");
        
        mrsPanel.add(textA);

    }
    
    public void createccsP(){
        ccsPanel = new JPanel();
        ccsPanel.setLayout( null );
        ccsPanel.setSize(1180,700);
        ccsPanel.setLocation(0,0);
        
        JTextArea textA = new javax.swing.JTextArea();
        textA.setSize(1000, 600);
        textA.setLocation(10, 10);
        textA.setText("In cryptography, a Caesar cipher, also known as Caesar's cipher, the shift cipher, \n"
                + "Caesar's code or Caesar shift, is one of the simplest and most widely known encryption \n"
                + "techniques. It is a type of substitution cipher in which each letter in the plaintext is \n"
                + "replaced by a letter some fixed number of positions down the alphabet. For example, with \n"
                + "a left shift of 3, D would be replaced by A, E would become B, and so on. The method is \n"
                + "named after Julius Caesar, who used it in his private correspondence.");
        ccsPanel.add(textA);
/*
        JLabel label1 = new JLabel( "cryptography" );
        label1.setLayout(null);
        label1.setBounds( 10,10,100,70 );
        MasPanel.add( label1 );
*/        
    }
    
    public void creategekP(){
        gekPanel = new JPanel();
        gekPanel.setLayout( null );
        gekPanel.setSize(1180,700);
        gekPanel.setLocation(0,0);

        JTextArea textA = new javax.swing.JTextArea();
        textA.setSize(1000, 600);
        textA.setLocation(10, 10);
        textA.setText("The Greek alphabet has been used to write the Greek language since \n"
                + "the 8th century BC.[2] It was derived from the earlier Phoenician alphabet,[3] \n"
                + "and was the first alphabetic script to have distinct letters for vowels as well \n"
                + "as consonants. It is the ancestor of the Latin and Cyrillic scripts.[4] Apart from \n"
                + "its use in writing the Greek language, in both its ancient and its modern forms, \n"
                + "the Greek alphabet today also serves as a source of technical symbols and labels in \n"
                + "many domains of mathematics, science and other fields.");
        
        gekPanel.add(textA);
    }
    
    
    public static void main( String args[] ){
        BookC mainFrame = new BookC();
        
        mainFrame.setVisible( true );
    }
    
}
