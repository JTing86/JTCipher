/*
 * letter shifting cipher
 */
package jtcipher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CaesarCip {
    private static final int enCpting = 0,deCpting = 1;
    private static String outputText = "";
    private static char key; //key
    private static boolean founded = false;
    
    private static Scanner kb = new Scanner(System.in);
    private static HashTable<String> HT = new HashTable<String>();
    
    public CaesarCip(){

    }
    public static void main(String[] args)throws FileNotFoundException {
        /*
        Infile.nextline get each line in the file as a  string, 
        */
        Scanner inFile = new Scanner(new BufferedReader(new FileReader("words.txt")));   
        while(inFile.hasNextLine()){
            HT.add(inFile.nextLine());        
        }       

                       
    }

    public static String CaesarCiping(int option, String inputText, char newA, boolean haveKey){
        CaesarCip CsC = new CaesarCip();
        

        
        if(option == enCpting){
            key = newA; 
            for(int i = 0;i< inputText.length();i++){
                char c = inputText.charAt(i);
                int pos = Character.getNumericValue(c);

                if(pos <36 && pos>9){ // 10 ~ 35, 26 letters a-z
                    char newc = CsC.toCipAlphbet(c,newA);
                    outputText+= newc;
                }

                else{  //space, other thing donot change.
                    outputText += c;
                }             
            } 
            return outputText;
        } 

        
        else{            //if(option == deCpting){
            if(haveKey){
                for(int i = 0;i< inputText.length();i++){
                    char c = inputText.charAt(i);
                    int pos = Character.getNumericValue(c);

                    if(pos <36 && pos>9){ // 10 ~ 35, 26 letters a-z
                        char newc = CsC.reverseTCA(c,newA);
                        outputText+= newc;
                    }

                    else{  //space, other thing donot change.
                        outputText += c;
                    }             
                } 
                return outputText;
            }
            
            else{
                String [] words=inputText.split(" ");
                //for (String word : words){
                    CsC.findKey(words[0]);
                    if(founded){
                        for(int i = 0;i< inputText.length();i++){
                            char c = inputText.charAt(i);
                            int pos = Character.getNumericValue(c);

                            if(pos <36 && pos>9){ // 10 ~ 35, 26 letters a-z
                                char newc = CsC.reverseTCA(c,key);
                                outputText+= newc;
                            }
                            else{  //space, other thing donot change.
                                outputText += c;
                            }             
                        } 
                    }
                ///}  
                return outputText;
            }
            
        }
    }

    public char toCipAlphbet(char inputalp, char newA){
        int pos = Character.getNumericValue(inputalp);
        int shiftDist = Character.getNumericValue(newA) - 10;
        int newpos = pos - shiftDist;
        if (newpos < 0){
            newpos += 26;
        }
        return  Character.forDigit(newpos, 36);        
    }
    
        // incase that cipher don't have the keyword 
    public char reverseTCA(char inputalp,char newA){
        
        int pos = Character.getNumericValue(inputalp);
        int shiftDist = Character.getNumericValue(newA) - 10;
        int newpos = pos + shiftDist; //shift it back
        if (newpos > 25){
            newpos -= 26;
        }
        return  Character.forDigit(newpos, 36);  
      
    }
    
    public void findKey(String inputword){
        CaesarCip CsC = new CaesarCip();
        String outputword = "";  
        int shiftDist = 0;
        while (true){
            
            for(int i = 0;i< inputword.length();i++){
                char c = inputword.charAt(i);
                int pos = Character.getNumericValue(c);
                int newpos = pos + shiftDist; 
                if(pos <36 && pos>9){ // 10 ~ 35, 26 letters a-z
                    char newc = Character.forDigit(newpos, 36); 
                    outputword+= newc;
                }

                else{  //space, other thing donot change.
                    outputword += c;
                }             
            } 
            if(CsC.HT.contains(outputword)){
                key = Character.forDigit(shiftDist+10, 36); 
                founded = true;
                break;
            }
            
            else{
                shiftDist ++; 
            }
            
        }
    }  
    
    
}
