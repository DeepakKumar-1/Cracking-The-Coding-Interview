package com.company.ArraysAndStrings;

import java.util.HashMap;
class maxChar{
    char ch;
    int max;
    maxChar(char ch, int max){
        this.ch = ch;
        this.max = max;
    }
}

public class MaxFrequencyCharacter {
    private static char ch = ' ';
    public static maxChar maxFrequencyCharacter(String str){
        // Create an HashMap
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(char c : str.toCharArray()){
            if(map.containsKey(c)) {
                int key = map.get(c)+1;
                map.put(c, key);
                if(max < key){
                    max = key;
                    ch = c;
                }
            } else{
                map.put(c, 1);
                if(max < 1){
                    max = 1;
                    ch = c;
                }
            }
        }
        return new maxChar(ch, max);
    }

    public static void main(String []args){
        String str = "Deepak Kumar";
        maxChar obj = maxFrequencyCharacter(str);
        System.out.println("Max Frequency Character is: " +  obj.ch + " With Frequency: " + obj.max);
    }
}
