package jtcipher;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.geom.*;             // for the rectangle
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

// for music
import org.jfugue.player.Player;
//for decoration
import javax.swing.JLayer;
import javax.swing.plaf.LayerUI;

public class JTcipher extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

// load class
//-------------------------menu---------------
    

    JPanel mainPanel;

    JPanel ChoiceCsCP;
    
    PaintPanel board;

    CardLayout cLayout = new CardLayout();
    

    //private Image backgroundPic = new ImageIcon("bgp1.jpg").getImage();
    private JLabel back;


    private String notes;
    private String cipher;
    private int ENorDE;
    private final int EnCpting = 0;
    private final int DeCpting = 1;

    private final int morse = 0;
    private final int pigpen = 1;
    private final int music = 3;
    private final int caesar = 4;

    private String instruction = " Encrypt or Decrypt?";
    
    private String inputText, outputText;
    private javax.swing.JTextArea textinputA;
    private javax.swing.JTextArea textoutputA;
    private javax.swing.JTextArea InstructionA;
    private javax.swing.JTextArea choiceA; // 

    Font myFont1 = new Font("Pigpen", Font.ITALIC | Font.BOLD, 12);
    Font PigpenFont = myFont1.deriveFont(50F);

    Font myFont2 = new Font("GL-DancingMen", Font.ITALIC | Font.BOLD, 12);
    Font DancingManFont = myFont2.deriveFont(50F);
    
    Font myFont3 = new Font("GL-Runen", Font.ITALIC | Font.BOLD, 12);
    Font GreekCharFont = myFont3.deriveFont(50F);
    
    JButton CptB = new JButton("Crypting");
    JButton CptPhB = new JButton("back to menu");
    JButton ClearB = new JButton("Clean it");
    JButton enCptB = new JButton("enCrypting");
    JButton deCptB = new JButton("deCrypting");

    JButton bookB = new JButton("Cipher Collections");
    JButton settingsB = new JButton("Settings");
    JButton submitB = new JButton("submit");

    JButton MusicCptB = new JButton("MusicCptB");
    JButton MorseCptB = new JButton("MorseCptB");
    JButton CaesarCptB = new JButton("CaesarCptB");
    JButton PigpenCptB = new JButton("PigpenCptB");
    JButton DancingManCptB = new JButton("DancingManCptB");
    JButton GreekCharCptB = new JButton("GreekCharCptB");
    //JButton PigpenCptB = new JButton("PigpenCptB");
    JButton bookPhB = new JButton("back to home");

    //load classes in fields
    private MorseCip MrC = new MorseCip();
    private MusicCip MuC = new MusicCip();
    private CaesarCip CsC = new CaesarCip();
    //load page classes

    //private JLabel backgroundPic;
    
//---------------------------------
    public JTcipher(){
        super("JT CIPHERRRR!!!!!");
        BookC bc = new BookC();  //the page with tabs    
       
        
        board = new PaintPanel(this);// for paint component, dealing with appearance such as adding back ground pictures
        
        CptB.addActionListener(this);   // got buttons ... need listeners  
        CptPhB.addActionListener(this); // prev home Button
        ClearB.addActionListener(this); // clear the text areas
        enCptB.addActionListener(this);
        deCptB.addActionListener(this);         
        bookB.addActionListener(this);
        settingsB.addActionListener(this);
        submitB.addActionListener(this);

        bookPhB.addActionListener(this);

        // ciphering buttons
        MorseCptB.addActionListener(this);
        MusicCptB.addActionListener(this);
        CaesarCptB.addActionListener(this);
        PigpenCptB.addActionListener(this);
        DancingManCptB.addActionListener(this);
        GreekCharCptB.addActionListener(this);
        

        /*----------------------* home Page panel*------------------------------------*/
        JPanel homeP = new JPanel();
        homeP.setLayout(null);	

        CptB.setLocation(420, 375);
        CptB.setSize(350, 100);
        CptB.setForeground(new Color(255,230,230));
        CptB.setBorder(BorderFactory.createLineBorder(new Color(255,230,230), 3,true));//(col,thickness,boolean rounded
        CptB.setContentAreaFilled(false);
        CptB.setOpaque(false);
        CptB.setFont(DancingManFont);
        

        bookB.setLocation(420, 485);
        bookB.setSize(350, 100);
        bookB.setForeground(new Color(255,230,230));
        bookB.setBorder(BorderFactory.createLineBorder(new Color(255,230,230), 3,true));
        bookB.setContentAreaFilled(false);
        bookB.setOpaque(false);
        bookB.setFont(DancingManFont);
        
        settingsB.setLocation(420, 595);
        settingsB.setSize(350, 100);
        settingsB.setForeground(new Color(255,230,230));
        settingsB.setBorder(BorderFactory.createLineBorder(new Color(255,230,230), 3,true));
        settingsB.setContentAreaFilled(false);
        settingsB.setOpaque(false);
        

        homeP.add(CptB);
        homeP.add(bookB);
        
        homeP.setOpaque(false);
        homeP.add(board);

        /*-----------------------* crypting Page *--------------------------*/
        JPanel CptP = new JPanel();
        CptP.setLayout(null);
        
        /*      Cipher List Panel      */
        JPanel CipListP = new JPanel();
        CipListP.setOpaque(false);
        CipListP.setLocation(20, 20);
        CipListP.setSize(260, 690);
        CipListP.setBorder(BorderFactory.createLineBorder(Color.RED));
        CipListP.setLayout(null);


        MusicCptB.setLocation(10, 20);
        MusicCptB.setSize(240, 35);
        CipListP.add(MusicCptB);

        MorseCptB.setLocation(10, 60);
        MorseCptB.setSize(240, 35);
        CipListP.add(MorseCptB);

        CaesarCptB.setLocation(10, 100);
        CaesarCptB.setSize(240, 35);
        CipListP.add(CaesarCptB);

        PigpenCptB.setLocation(10, 140);
        PigpenCptB.setSize(240, 35);
        CipListP.add(PigpenCptB);
        
        DancingManCptB.setLocation(10, 180);
        DancingManCptB.setSize(240, 35);
        CipListP.add(DancingManCptB);
        
        GreekCharCptB.setLocation(10, 220);
        GreekCharCptB.setSize(240, 35);
        CipListP.add(GreekCharCptB);
        
        
        /*      mid Panel      */
        JPanel MidP = new JPanel();
        MidP.setLocation(300, 20);
        MidP.setSize(600, 690);
        MidP.setBorder(BorderFactory.createLineBorder(Color.black));
        MidP.setLayout(null);

        textinputA = new javax.swing.JTextArea();
        textinputA.setSize(580, 250);
        textinputA.setLocation(10, 160);

        textoutputA = new javax.swing.JTextArea();
        textoutputA.setSize(580, 250);
        textoutputA.setLocation(10, 435);

        enCptB.setLocation(70, 110);
        enCptB.setSize(200, 40);

        deCptB.setLocation(300, 110);
        deCptB.setSize(200, 40);
                
        MidP.setOpaque(false);
        MidP.add(textinputA);
        MidP.add(textoutputA);
        MidP.add(enCptB);
        MidP.add(deCptB);
        // MidP.add(logo);
        

        /*      Option Panel      */
        JPanel OptionP = new JPanel();
        OptionP.setOpaque(false);
        OptionP.setLocation(920, 20);
        OptionP.setSize(260, 690);
        OptionP.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        OptionP.setLayout(null);

        InstructionA = new javax.swing.JTextArea();
        InstructionA.setSize(240, 200);
        InstructionA.setLocation(10, 10);

        /*      Choice Panels (inside option panel)      --------------------------------------------*/
        JPanel ChoiceP = new JPanel();
        ChoiceP.setOpaque(false);
        ChoiceP.setLocation(10, 220);
        ChoiceP.setSize(240, 200);
        ChoiceP.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 40)));

        /*      Choice Panel (caesar Panel)      */
        ChoiceCsCP = new JPanel();
        ChoiceCsCP.setLocation(10, 220);
        ChoiceCsCP.setSize(240, 200);
        ChoiceCsCP.setLayout(null);
        ChoiceCsCP.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 40)));
        ChoiceCsCP.setVisible(false);

        choiceA = new javax.swing.JTextArea();
        choiceA.setLocation(10,10);
        choiceA.setSize(50, 50);

        submitB.setLocation(40, 20);
        submitB.setSize(60, 30);

        ChoiceCsCP.add(choiceA);
        ChoiceCsCP.add(submitB);

        /*      Choice Panel (Music Panel)     */
        JPanel ChoiceMuCP = new JPanel();
        ChoiceMuCP.setVisible(false);
        submitB.setLocation(40, 300);
        submitB.setSize(600, 30);

        ChoiceMuCP.setLocation(10, 220);
        ChoiceMuCP.setSize(240, 200);
        ChoiceMuCP.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 40)));

        /*      Choice Panel (caesar Panel)      */
        JPanel ChoiceCsCP = new JPanel();
         ChoiceMuCP.setVisible(false);
         submitB.setLocation(40,300);
         submitB.setSize(600,30);        
        
         ChoiceCsCP.setLocation(10,220);
         ChoiceCsCP.setSize(240,200);
         ChoiceCsCP.setBorder(BorderFactory.createLineBorder(new Color(200,200,40)));
         
        ChoiceP.add(ChoiceCsCP);
        /*      Choice Panels ends                        --------------------------------------------*/
        ClearB.setLocation(10, 500);
        ClearB.setSize(240, 30);

        CptPhB.setLocation(10, 600);
        CptPhB.setSize(240, 30);

        OptionP.add(ClearB);
        OptionP.add(CptPhB);
        OptionP.add(InstructionA);
        OptionP.add(ChoiceP);
        
        CptP.add(CipListP);
        CptP.add(MidP);
        CptP.add(OptionP);
        CptP.setOpaque(false);
        CptP.add(new PaintPanel(this));
        

        /*-------------------------* Booklet Page *-----------------------------------*/
        
        bookPhB.setLocation(1000,100);
        bookPhB.setSize(200,30);
        
        JPanel bookP = new JPanel();
        bookP.setOpaque(false);
        bookP.add(bc.tabPane);
        bookP.setLayout(null);
        bookP.setSize(1200,750);
        bookP.add(bookPhB);
        bookP.add(new PaintPanel(this));

        /*-------------------------* add to main panel *-----------------------------------*/
        mainPanel = new JPanel(cLayout);
        mainPanel.add(homeP, "homePage");
        mainPanel.add(CptP, "CptPage");
        mainPanel.add(bookP, "collectionPage");
        mainPanel.setOpaque(false);
        //mainPanel.add(board);
        //mainPanel.add(back,"bp");

        /*-------------------------* add mainpanel to frame *-----------------------------------*/
        add(mainPanel);
        
        addMouseListener(this);
        addActionListener(this);
        homeP.addMouseListener(this);
        mainPanel.addMouseMotionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750);
        setVisible(true);
    }

    public void checkclicking(Object source) {

        /*menu buttons*/
        if (source == CptB) {
            cLayout.show(mainPanel, "bp");
            cLayout.show(mainPanel, "CptPage");            
            InstructionA.setText(instruction);
        }
        if (source == bookB) {
            cLayout.show(mainPanel, "collectionPage");
        }

        /*sub buttons*/
        /*encrypting page buttons*/
        if (source == CptPhB || source == bookPhB) {
            cLayout.show(mainPanel, "homePage");
        }

        if (source == enCptB) {
            ENorDE = EnCpting;
            instruction = "input text and then choose a cipher catagory";
            InstructionA.setText(instruction);
        }
        if (source == deCptB) {
            ENorDE = DeCpting;
            instruction = "input text and then choose a cipher catagory";
            InstructionA.setText(instruction);
        }
        if (source == MusicCptB) {
            instruction = "now choose a cipher catagory";
            InstructionA.setText(instruction);
            inputText = textinputA.getText();
            MuC.MusicCiping(ENorDE, inputText);
        }

        if (source == MorseCptB) {
            inputText = textinputA.getText();
            outputText = MrC.MorseCiping(ENorDE, inputText);
            textoutputA.setText(outputText);
        }

        if (source == CaesarCptB) {

            ChoiceCsCP.setVisible(true);
            instruction = "input your cipher, new 'a'";
            cipher = choiceA.getText();
            InstructionA.setText(instruction);
            inputText = textinputA.getText();
            outputText = CsC.CaesarCiping(ENorDE, inputText, cipher.charAt(0), false); //contains exactly one letter, use charat to convert string to char
            textoutputA.setText(outputText);
        }

        if (source == PigpenCptB) {
            if (ENorDE == EnCpting) {
                inputText = textinputA.getText();
                textoutputA.setFont(PigpenFont);
                textoutputA.setText(inputText);
            }
            if (ENorDE == DeCpting) {
                inputText = textinputA.getText();
                outputText = inputText;
                textoutputA.setText(outputText);
            }
        }

        if (source == DancingManCptB) {
            if (ENorDE == EnCpting) {
                inputText = textinputA.getText();
                textoutputA.setFont(DancingManFont);
                textoutputA.setText(inputText);
            }
            if (ENorDE == DeCpting) {
                inputText = textinputA.getText();
                outputText = inputText;
                textoutputA.setText(outputText);
            }
        }
        
         if (source == GreekCharCptB) {
            if (ENorDE == EnCpting) {
                inputText = textinputA.getText();
                textoutputA.setFont(GreekCharFont);
                textoutputA.setText(inputText);
            }
            if (ENorDE == DeCpting) {
                inputText = textinputA.getText();
                outputText = inputText;
                textoutputA.setText(outputText);
            }
        }
        if (source == ClearB) {
            instruction = "try again? Start from EN or DE!";
            InstructionA.setText(instruction);
            inputText = "";
            textinputA.setText(inputText);
            outputText = "";
            textoutputA.setText(outputText);
        }
    }

    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        System.out.println(evt);
        checkclicking(source);
    }

    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JTcipher frame = new JTcipher();

        frame.setSize(1200, 750);
        frame.setLocation(200, 100); // frame of JTcipher's location that shows on the screen
    }
    

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }
}

/* This program draw all the images for the program*/
class PaintPanel extends JPanel{

    private Image backgroundPic;
    private Image JClogoPic;
    //private JTcipher mainFrame;

    public PaintPanel(JTcipher m){
            backgroundPic = new ImageIcon("bgp1.jpg").getImage();
            JClogoPic = new ImageIcon("jclogo.png").getImage();
            //mainFrame = m;
            setSize(1200,750);
    }
    
    public void paintComponent(Graphics g){ 	
        g.drawImage(backgroundPic,0,0,1200,750,this);  //g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        
        g.setColor(new Color(10,10,10,100));  
	g.fillRect(20,20,1160,710);
        g.drawImage(JClogoPic,330,140,this);

    }
}