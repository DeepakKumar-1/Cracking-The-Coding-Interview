package com.company.ArraysAndStrings;

public class URLify {

    public static String replaceSpaces(char []str, int trueLength){
        // First Scan Find the Spaces in the String within True Length
        int spaceCount = 0;
        for(int i=0; i < trueLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        // Find the Final Index of the Resultant String
        int index = trueLength + spaceCount*(("%20").length() - 1);
        // int index = trueLength + spaceCount*2;
        if(trueLength < str.length){
            str[trueLength] = '\0';
        }
        // Second Scan replace the Spaces with %20
        for(int i = trueLength - 1; i >= 0; i--){
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return new String(str);
    }
    public static String replaceSpaces(String str, int trueLength){
        return replaceSpaces(str.toCharArray(), trueLength);
    }
    public static void main(String []args){
        String str = "Mr John Smith     ";
        int trueLength = 13;
        System.out.println("Resultant String is: " + replaceSpaces(str, trueLength));
    }
}
