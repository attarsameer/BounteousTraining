//6. Remove Nth Node From End of List
//Given a linked list, remove the nth node from the end and return its head.


class Node{
    public int data;
    public Node next;

    public Node(int d1, Node nxt1){
        data=d1;
        next=nxt1;
    }
    public Node(int d1){
        data=d1;
        next=null;
    }
}
public class Problem6 {


    public static void printLL(Node head){

        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }

    }


    public static Node DeleteNode(Node head, int n){
        Node p1=head;
        Node p2=head;


        for(int i=0;i<n;i++){
            p1=p1.next;
        }

        if(p1==null){
            return head.next;
        }

        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }

        Node deletNode=p2.next;
        p2.next=p2.next.next;
        deletNode=null;
        return head;
    }

    public static void main(String[] args){
        int[] arr={2, 8, 9, 1, 3};
        int n=3;
        Node head=new Node(arr[0]);
        head.next=new Node(arr[1]);
        head.next.next=new Node(arr[2]);
        head.next.next.next=new Node(arr[3]);
        head.next.next.next.next=new Node(arr[4]);


        head=DeleteNode(head, n);
        printLL(head);


    }
    
}
