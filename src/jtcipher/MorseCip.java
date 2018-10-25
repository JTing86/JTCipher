/*
 * This class handle all the method dealing with Morse code.
 */
package jtcipher;



import java.util.ArrayList;


public class MorseCip {
    private static final int enCpting = 0,deCpting = 1;
    private static String outputText = "";
    private ArrayList<String> MorseList ;  
    //private static int option;
    
    
    public MorseCip(){
        MorseList = new ArrayList<String>();
        String [] morseCyp = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};        
        for(String s : morseCyp){
            MorseList.add(s);
        }        
    }
    
    /* This method has been used in the main program where it gets whether en or de and the input text
    * it returns output text
    */
    public static String MorseCiping(int option, String inputText){
        
        MorseCip MrC = new MorseCip();
  
        if (option == enCpting){
            
            for (int i = 0; i < inputText.length(); i++){
                char c = inputText.charAt(i);
                int pos = Character.getNumericValue(c);
                
                if(pos <36 && pos>9){ // 10 ~ 35, 26 letters a-z
                    outputText += MrC.MorseList.get(pos-10)+" ";
                }
                
                if(pos == -1){  //space
                    outputText += "/";
                }      
            }    
        }
        
        if (option == deCpting){
                                                            //Morse code seperating letters by ' '  and words by'/' "
            String [] words = inputText.split("/");
            for (String w : words){
                String []letter = w.split(" ");
                for (String s : letter){                    
                    int pos = MrC.MorseList.indexOf(s) + 10;   //the reverse method of getNumericValue()
                    outputText += Character.forDigit(pos, 36); 
                }
                outputText += " "; //sepreating each word
            }            
        }           
        return outputText;
    }
}
