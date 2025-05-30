//Problem 3: 
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.


import java.util.*;
public class BalancedParanthesis {


    public static boolean isValid(String str){

        Stack<Character> st=new Stack<>();
        for(char ch:str.toCharArray()){
            if(ch=='('||ch=='['||ch=='{'){
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;

                char c=st.pop();
                if(ch==')' && c=='('||ch=='}' && c=='{'||ch==']' && c=='['){
                    continue;
                }else return false;
            }
        }

        return st.isEmpty();
    }


    public static void main(String[] args){
        String str="()[]{}";
        if(isValid(str)==true){
            System.out.println("True");
        }else{
            System.out.println("false");
        }
    }
    
}
