// 4. Linked Lists
//Add Two Numbers
//You are given two non-empty linked lists representing two non-negative integers. Add the two numbers and return the sum as a linked list.

import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
    }

    Node(int data, Node next){
        this.data=data;
        this.next=next;
    }
}

public class Problem4 {

    public Node addTwoNumbers(Node l1, Node l2){
    Node head=new Node(0);
    Node curr=head;
    int carry=0;

    while(l1!=null||l2!=null||carry!=0){

        int x=(l1!=null)?l1.data:0;
        int y=(l2!=null)?l2.data:0;
        int sum=x+y+carry;
        carry=sum/10;

        curr.next=new Node(sum%10);
        curr=curr.next;
        if(l1!=null){
            l1=l1.next;
        }

        if(l2!=null){
            l2=l2.next;
        }

    }

    return head.next;





    }


    public static void main(String[] args){

        Node l1=new Node(5, new Node(6, new Node(7)));
        Node l2=new Node(4, new Node(8, new Node(9)));

        Problem4 solution=new Problem4();
        Node result=solution.addTwoNumbers(l1, l2);
        printtList(result);
        
    }


    public static void printtList(Node node){
        while(node!=null){
            System.out.print(node.data);
            if(node.next!=null){
                System.out.print("->");
            }
            node=node.next;
        }

        System.out.println();
    }



    
}
