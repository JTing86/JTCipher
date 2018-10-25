/*
 * This class deal with music note cipher
 */
/*

C D E F G A B C6

tone:
1-10
default start at C5

rate:

default q, space as h
w - whole duration
h - half duration
q - quarter duration
i - eighth duration
s - sixteenth duration
t - thirty-second duration
x - sixty-fourth duration
n - 1/128th duration
*/
package jtcipher;

//import org.jfugue.player.Player;

import org.jfugue.player.Player;


public class MusicCip {

    private static final int enCpting = 0,deCpting = 1;
    private static String outputNotes = "";
    private static String musicalAlp,rate;
    private static int tone;
    private static boolean isLastNote = false; //last note is slow, to sepreate words
    
    //music note components
    private static final String[]musicalAlps = {"C","D","E","F","G","A","B"};  // C D G F E A B
    private static String[] rates = {"n","x","t","s","i","q","h","w"};
    
    private String note = "";
    
    private static MusicCip MuC;
    
    public MusicCip(){
        
        
        //Player player = new Player();
        //player.play(outputNotes);
    }
    
    public void MusicCiping(int option, String inputText){
        
        
        if(option == enCpting){  
            outputNotes = convertToMnote(inputText);
            Player player = new Player();
            player.play(outputNotes);
            //return outputNotes;
                //textoutputA.setText(outputNotes); 
        }
        
        if(option == deCpting){            
        }        
    }
    
    // This method convert input letters to music tone code so that JFudge can read them and play music
    public static String convertToMnote(String inputText){
        String line = inputText+" "; // add an extra space to the end so that check next won't out of range
        for (int i = 0; i < line.length()-1; i++){
            char c = line.charAt(i);
            int pos = Character.getNumericValue(c);
            
            // check if the letter is the last letter of a word but not the last letter of a text
            
            //get rate
            int posNext = Character.getNumericValue(line.charAt(i+1)); 
            
            if(posNext == -1){ //is a space
                isLastNote = true;     
                rate = rates[6]; //5-q  
            }
            else{
                rate = rates[5];
            }

            //check if input is valid letter, if not, ignore it
            if(pos <36 && pos>9){ // 10 ~ 35, 26 letters a-z
                int index = (pos-10)%7;
                musicalAlp = musicalAlps[index];
                tone = 5+ (pos-10)/7;  
                outputNotes += MuC.musicalAlp+tone+rate+" "; 
            }
            else if(pos>35 || pos < 10 || !isLastNote){
                outputNotes += "";                
            }
            if(pos == -1){  //space
                outputNotes += "";
            }      
        } 
        
        return outputNotes;
    }    
}
