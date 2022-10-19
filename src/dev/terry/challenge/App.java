package dev.terry.challenge;

import java.util.LinkedList;
import java.util.Stack;

public class App {

    static class ThisStack
    {
        Stack<Integer> s = new Stack<Integer>();

        private int maxEle;

        int getMax(){
            if(s.empty()){
                throw new RuntimeException("Stack is empty.");
            }
            else {
                return maxEle;
            }
        }

        void push(Integer num){
            if(s.empty()){
                maxEle = num;
                s.push(num);
                return;
            }
            if(num > maxEle){
                s.push(2 * num - maxEle);
                maxEle = num;
            }
            else {
                s.push(num);
            }
        }

        int pop(){
            if(s.empty()){
                throw new RuntimeException("Stack is empty");
            }
            int t = s.peek();

            s.pop();

            if(t > maxEle){
                int num = maxEle;
                maxEle = 2 * maxEle - t;
                return num;
            }
            else {
                return t;
            }
        }
    }

    static Node head1, head2;

    static class Node {
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    int getNode(){
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;

        if(c1 > c2){
            d = c1 - c2;
            return getIntersection(d, head1, head2);
        }
        else
        {
            d = c2 - c1;
            return getIntersection(d, head2, head1);
        }
    }

    int getIntersection(int d, Node node1, Node node2){
        Node current1 = node1;
        Node current2 = node2;
        for(int i = 0; i < d; i++){
            if(current1 == null){
                return -1;
            }
            current1 = current1.next;
        }
        while(current1 != null && current2 != null){
            if(current1.data == current2.data){
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }

    int getCount(Node node){
        Node current = node;
        int count = 0;

        while(current != null){
            count++;
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {
        ThisStack stack = new ThisStack();

        stack.push(2);
        stack.pop();
        stack.getMax();

        App list = new App();

        list.head1 = new Node(3);
        list.head1.next = new Node(7);
        list.head1.next.next = new Node(8);
        list.head1.next.next.next = new Node(10);

        list.head2 = new Node(99);
        list.head2.next = new Node(1);
        list.head2.next.next = new Node(8);
        list.head2.next.next.next = new Node(10);

        list.getNode();
    }

}
