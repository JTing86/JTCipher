/*
 * This class is created for dealing with ceasar cipher when Cipher (shifting distance is not given)
 */
package jtcipher;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author jingting
 */
public class HashTable <T> {
    /*
    content of a Hashtable, includes size, loading/ maxnium percentage 
    and of course set its type, LinkedList
    */
    ArrayList <LinkedList<T>> table;    
    private int size;
    private int loadPerc;
    private double maxlPerc = .7;    
    
    // constructure
    public HashTable(){
        table = blank(10);
        size = 0;
    }
    
    //this method create an initial empty hashtable
    public ArrayList<LinkedList<T>> blank(int n){
        ArrayList<LinkedList<T>> arr = new ArrayList<LinkedList<T>>();
        for (int i = 0;i<n;i++){
            arr.add(null);
        }
        return arr;
    }
    
    /*This method add value into hashtable, it also prevent the max load 
    percentages exceeding 70%
    */
    public void add(T val){
        int h = Math.abs(val.hashCode());
        int pos = h % table.size();
        if (table.get(pos) == null){
            table.set(pos, new LinkedList<T>());
        }
        table.get(pos).add(val);
        size++;
        if(size/table.size()> maxlPerc){
            resize();
        }
    }
    // This method removes a val from the hash table
    public void remove(T val){
        int pos = Math.abs(val.hashCode() % size);
        table.get(pos).remove(val);
    }
    
    /*
    This method get the posiiton and return the value in that position
    */
    public T get(int num){
        int pos = Math.abs(num % table.size());
        if (table.get(pos) == null){
            return null;
        }
        else{
            for(T val:table.get(pos)){
                if(val.hashCode()==num){
                    return val;
                }
            }
        }
        return null;
    }
    /*
    This method is created for the permutation to check its base case inside the
    method to make life easier
    */
    public boolean contains(T val){
        int num = val.hashCode();
        int pos = Math.abs(num % table.size());
        if (table.get(pos) == null){
            return false;
        }
        else{
            return table.get(pos).contains(val);
        }
    }
    /*
    This method get the loading percentage of a hashtable
    */
    public int getLoad(){
        return size/table.size();
    }
    /*
    This method is designed to resize a hashtable when the load is too much
    */
    public void resize(){
        ArrayList <LinkedList<T>> tmp = table;
        table = blank(table.size() * 10);
        size = 0;
        for (LinkedList<T> lst : table){
            if (lst != null){
                for(T val : lst){
                    add(val);
                }
            }
        }          
    }
    /*
    This method is easy for people to set the maxload, instead of go into the 
    code and change the values.
    */
    public void setMaxLoad( int percInt ){
        double perc = percInt / 100;
        maxlPerc = perc;
    }
    /*
    This method make life easy to print a hashtable
    */
    public String toString(){
        String ans = "";
        for(LinkedList<T>brown : table){
            if(brown != null){
                for(T val : brown){
                    ans += val;
                }
            }
        }  
        return ans;
    }
    /*
    This method is designed for this assignemnt because of its type is arraylist
    */
    public ArrayList<T> toArray(){
        ArrayList<T> al = new ArrayList();
        for(LinkedList<T>llist : table){
            if (llist != null){
                al.addAll(llist); // llist is an collection.
            }
        }      
        return al;       
    }

    
    
}

