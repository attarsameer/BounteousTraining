//Problem 5: 
//Two strings are considered close if you can swap letters or change the frequency of any 
//letter to match the other string. Determine if two given strings are close.

import java.util.Arrays;
import java.util.Scanner;

public class IfTwoStringsAreClose {

    public static boolean twoStringsEqual(String str1, String str2){

        if(str1.length()!=str2.length()){
            return false;
        }


        int[] freq1=new int[26];
        int[] freq2=new int[26];

        for(char ch:str1.toCharArray()){

            freq1[ch-'a']++;

        }

        for(char ch:str2.toCharArray()){

            freq2[ch-'a']++;

        }

        for(int i=0;i<26;i++){
            if((freq1[i]==0 && freq2[i]!=0)||(freq1[i]!=0 && freq2[i]==0)){

                return false;

            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);

    }


    



    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();

        System.out.println(twoStringsEqual(str1, str2));
    }



    
}
