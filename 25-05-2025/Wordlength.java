//Problem 9
//Given a string s consisting of words and spaces, return the length of the last word in the string. A word is a maximal substring consisting of non-space characters only.

import java.util.*;
public class Wordlength {

    public static int lastwordlength(String str){
        str=str.trim();

        String[] words=str.split(" ");

        return words[words.length-1].length();
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();

        System.out.println(lastwordlength(str));


    }
    
}