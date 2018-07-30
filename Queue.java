package com.company;

public class Queue {
    Node root = new Node();
    Node last = new Node();

    public Queue(){
        root.data=null;
        root.next=null;
        last=root;
    }
    public void enqueue(int icData){
        if (root.data==null){
            root.data=icData;
            last=root;
        }
        else {
            Node yeni = new Node();
            yeni.data=icData;
            yeni.next=null;
            last.next=yeni;
            last=yeni;
        }
    }
    public int dequeue(){
        if (root.data==null){
            System.out.println("Kuyruk Zaten Boş!");
            return -1;
        }
        else if (root.next==null){
            Node temp = root;
            root.data=null;
            return temp.data;
        }
        else {
            Node temp = root;
            root = root.next;
            return temp.data;
        }
    }
    public int front(){
        if (root.data==null){
            System.out.println("Kuyruk Boş");
            return -1;
        }
        else {
            return root.data;
        }
    }
    public int size(){
        if (root.data == null) {
            return 0;
        } else if (root.next == null) {
            return 1;
        }
        else {
            Node iter = root;
            int i = 0;
            while (iter.next!=null){
                iter=iter.next;
                i++;
            }
            return i+1;
        }
    }
    public boolean isEmpty(){
        if (root.data==null){
            return true;
        }
        else {
            return false;
        }
    }
}
