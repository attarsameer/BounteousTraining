//Problem 7
//Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".

import java.util.*;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String str[]){

        Arrays.sort(str);
        String s1=str[0];
        String s2=str[str.length-1];

        int index=0;

        while(index<s1.length()){
            if(s1.charAt(index)==s2.charAt(index)){
                index++;
            }else{
                break;
            }

            

        }

        return index==0?"":s1.substring(0, index);
        


    }


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str={"flower","flow","float"};
        System.out.println(longestCommonPrefix(str));

    }
    
}
